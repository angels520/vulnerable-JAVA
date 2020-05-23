package com.fruit.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.fruit.dao.DBShop;
import com.fruit.dao.impl.DBShopImpl;
import com.fruit.Object.ShopObject;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.util.UUID;

public class ShopListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String cmd=request.getParameter("cmd");

        if("allshop".equals(cmd))
            doAllshop(request,response);
        else if("senddetail".equals(cmd))
            dosenddetail(request,response);
        else if("sendindex".equals(cmd))
            dosendindex(request,response);//发送到/index.jsp
        else if("addshop".equals(cmd))
            doAddshop(request,response);
        else if("updateshop".equals(cmd))
            doUpdateshop(request,response);
        else if("delshop".equals(cmd))
            doDelshop(request,response);
        else if("searchshop".equals(cmd))
            doSearchshop(request,response);

    }

    protected void doSearchshop(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        DBShop db=new DBShopImpl();
        String shopname=req.getParameter("shopname");
        int shopid=0;
        shopid=db.FindShopTwo(shopname);
        if(shopid>0)
        {
            resp.sendRedirect("/ShopListServlet?cmd=senddetail&id="+shopid);
        }
        else{
            PrintWriter out = resp.getWriter();
            out .write("<script>alert(\"没有此项！\");");
        }
       ///ShopListServlet?cmd=senddetail&id=898424364
    }

    protected void dosenddetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        DBShop db=new DBShopImpl();
        int id=Integer.valueOf(req.getParameter("id")).intValue();
        List<ShopObject> shops= db.FindShopOne(id);
        if(shops.size()>0||shops!=null)
        {
            req.setAttribute("shops",shops);
            req.getRequestDispatcher("/detail.jsp").forward(req, resp);
        }
    }

    protected void dosendindex(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBShop db=new DBShopImpl();
        List<ShopObject> shops= db.FindShopAll();
        if(shops.size()>0||shops!=null)
        {
            req.setAttribute("allshops",shops);
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }

    protected void doAllshop(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBShop db=new DBShopImpl();
        List<ShopObject> shops= db.FindShopAll();
        System.out.println(shops.toString());
        if(shops.size()>0||shops!=null)
        {
            req.setAttribute("allshops",shops);
            req.getRequestDispatcher("/admin/shop-list.jsp").forward(req, resp);
        }
    }
    protected void doAddshop(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBShop db=new DBShopImpl();
        String shopname=null;
        String shopimg=null;
        String shopdetail=null;
        int shopid=UUID.randomUUID().toString().hashCode();
        if(shopid<0){
            shopid=-shopid;
        }

        //解析和检查请求，是否是post方式，是否是二进制流格式
        Boolean isMultipart=ServletFileUpload.isMultipartContent(req);
        if (!isMultipart) {
            return; //如果不是就不用上传了
        }

        try {
            //创建FileItemFactory对象
            FileItemFactory factory=new DiskFileItemFactory();
            //创建文件上传的处理器
            ServletFileUpload upload=new ServletFileUpload(factory);
            //解析请求
            List<FileItem> items=upload.parseRequest(req);
            //迭代出每一个FileItem
            for (FileItem item : items) {
                String fileName = item.getFieldName();
                if (item.isFormField()) {
                    //普通的表单控件
                    String value = item.getString("utf-8");
                    if(fileName.equals("shopname")) {
                        shopname=value;
                    }else if(fileName.equals("shopdetail")){
                        shopdetail=value;
                    }
                } else {
                    //上传文件的控件
                    String RandomName = UUID.randomUUID().toString()+"."+ FilenameUtils.getExtension(item.getName());
                    shopimg=RandomName;
                    String path=super.getServletContext().getRealPath("/upload");
                    item.write(new File(path, RandomName)); //把上传的文件保存到某个文件中
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        shopimg="upload/"+shopimg;
        int result=db.AddShopOne(shopid,shopname,shopimg,shopdetail);
        if(result==1){
            resp.sendRedirect("/ShopListServlet?cmd=allshop");
        }
        else{
            resp.sendRedirect("/admin/error.jsp");
        }
    }
    protected void doUpdateshop(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBShop db=new DBShopImpl();

        int shopid=Integer.valueOf(req.getParameter("shopid")).intValue();
        String shopname=req.getParameter("shopname");
        String shopimg=req.getParameter("shopimg");
        String shopdetail=req.getParameter("shopdetail");

        int result=db.UpdateShopOne(shopid,shopname,shopimg,shopdetail);

        if(result==1){
            resp.sendRedirect("/ShopListServlet?cmd=allshop");
        }
        else{
            resp.sendRedirect("/admin/error.jsp");
        }
    }

    protected void doDelshop(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBShop db=new DBShopImpl();
        int shopid=Integer.valueOf(req.getParameter("shopid")).intValue();
        int result=db.DelOne(shopid);
        if(result==1){
            resp.sendRedirect("/ShopListServlet?cmd=allshop");
        }
        else{
            resp.sendRedirect("/admin/error.jsp");
        }
    }
}

package com.fruit.servlet;

import com.fruit.Object.OrderObject;
import com.fruit.dao.DBOrder;
import com.fruit.dao.impl.DBOrderImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class OrderListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String cmd=request.getParameter("cmd");

        if("allcart".equals(cmd))
            doAllOrder(request,response);
        else if("delcart".equals(cmd))
            doDelOrder(request,response);
        else if("addcart".equals(cmd))
            doAddOrder(request,response);


    }

    protected void doAllOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBOrder db=new DBOrderImpl();
        List<OrderObject> orders= db.FindOrderAll();
       ;
        if(orders.size()>0||orders!=null)
        {
            req.setAttribute("allorders",orders);
            req.getRequestDispatcher("/admin/cart.jsp").forward(req, resp);
        }
    }
    protected void doDelOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBOrder db=new DBOrderImpl();
        int shopid=Integer.valueOf(req.getParameter("shopid")).intValue();
        int result=db.DelOne(shopid);
        if(result==1){
            resp.sendRedirect("/OrderListServlet?cmd=allcart");
        }
        else{
            resp.sendRedirect("/admin/error.jsp");
        }
    }
    //添加购物车，根据用户user查找商品id
    protected void doAddOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBOrder db=new DBOrderImpl();
        //处理
        String username=req.getParameter("username");
        String email=req.getParameter("email");
        String iphone=req.getParameter("iphone");
        String address=req.getParameter("address");
        String user=req.getParameter("user");
        System.out.print(user);

        int[] shopid=db.FindOrderOne(user);
        int result = 0;

        for(int i=0;i<shopid.length;i++){
            if(shopid[i]!=0){
                result=db.AddOrderpOne(shopid[i],username,email,iphone,address);
            }
        }

        if (result == 1) {
            PrintWriter out = resp.getWriter();
            out .write("<script>alert(\"购买成功\");window.location = \"/buyshop.jsp\"</script>");
        } else {
            resp.sendRedirect("/admin/error.jsp");
        }
    }

}

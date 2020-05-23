package com.fruit.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import com.fruit.dao.DBMessage;
import com.fruit.dao.impl.DBMessageImpl;
import com.fruit.Object.MessageObject;

public class messageListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String cmd=request.getParameter("cmd");

        if("allmessage".equals(cmd))
            doAllmessage(request,response);
        else if("addmessage".equals(cmd))
            doAddmessage(request,response);
        else if("updatemessage".equals(cmd))
            doUpdatemessage(request,response);
        else if("delmessage".equals(cmd))
            doDelmessage(request,response);

    }

    protected void doAllmessage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBMessage db=new DBMessageImpl();
        List<MessageObject> shops= db.FindMessageAll();
        if(shops.size()>0||shops!=null)
        {
            req.setAttribute("allmessages",shops);
            req.getRequestDispatcher("/admin/message-list.jsp").forward(req, resp);
        }
    }
    protected void doAddmessage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBMessage db=new DBMessageImpl();
        String username=req.getParameter("username");
        String email=req.getParameter("email");
        String url=req.getParameter("url");
        String question=req.getParameter("question");
        String message=req.getParameter("message");
        String act=req.getParameter("act");

        if(username==null){
            username="null";
        }else if(email==null){
            email="null";
        }else if(url==null){
            url="null";
        }else if(question==null){
            question="null";
        }else if(message==null){
            message="null";
        }else if(act==null){
            act="null";
        }

        int id= UUID.randomUUID().toString().hashCode();
        if(id<0){
            id=-id;
        }

        int result=db.AddMessageOne(id,username,email,url,question,message);
        if(act.equals("user")){
            if(result==1){
                PrintWriter out = resp.getWriter();
                out.print("留言成功！");
            }
            else{
                resp.sendRedirect("/admin/error.jsp");
            }
        }
        else{
            if(result==1){
                resp.sendRedirect("/MessageListServlet?cmd=allmessage");
            }
            else{
                resp.sendRedirect("/admin/error.jsp");
            }
        }
    }
    protected void doUpdatemessage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBMessage db=new DBMessageImpl();

        int id=Integer.valueOf(req.getParameter("id")).intValue();
        String username=req.getParameter("username");
        String email=req.getParameter("email");
        String url=req.getParameter("url");
        String question=req.getParameter("question");
        String message=req.getParameter("message");
        System.out.println("xixii");
        int result=db.UpdateMessageOne(id,username,email,url,question,message);

        if(result==1){
            resp.sendRedirect("/MessageListServlet?cmd=allmessage");
        }
        else{
            resp.sendRedirect("/admin/error.jsp");
        }
    }

    protected void doDelmessage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBMessage db=new DBMessageImpl();
        int id=Integer.valueOf(req.getParameter("id")).intValue();
        int result=db.DelOne(id);
        if(result==1){
            resp.sendRedirect("/MessageListServlet?cmd=allmessage");
        }
        else{
            resp.sendRedirect("/admin/error.jsp");
        }
    }
}

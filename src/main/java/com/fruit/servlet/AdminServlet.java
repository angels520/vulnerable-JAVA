package com.fruit.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
//me
import com.fruit.service.MD5Service;
import com.fruit.service.impl.MD5ServiceImpl;
import com.fruit.service.LoginService;
import com.fruit.service.impl.LoginServiceImpl;

public class AdminServlet extends HttpServlet {
    HttpSession session=null;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        // java自带工具包MessageDigest
        MD5Service md5=new MD5ServiceImpl();
        password=md5.Get_MD5(password);
        //验证账号密码
        LoginService login=new LoginServiceImpl();
        int result=login.Login(username,password);
        //PrintWriter out = response.getWriter();
        if(result==0){
            //创建转发器
            response.sendRedirect("/admin/login.jsp");
        }
        else{
            //向session中
            session = request.getSession();
            session.setAttribute("admin", username);

            response.sendRedirect("/admin/index.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String cmd = request.getParameter("cmd");

        if("quit".equals(cmd)){
            doQuit(request,response);
        }
    }

    protected void doQuit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(session.getAttribute("admin")!=null){
            session.removeAttribute("admin");
        }
        resp.sendRedirect("/admin/login.jsp");
    }
}

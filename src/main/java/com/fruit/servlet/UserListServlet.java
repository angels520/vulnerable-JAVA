package com.fruit.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;
//me
import com.fruit.Object.UserObject;
import com.fruit.dao.DBDao;
import com.fruit.dao.impl.DBDaoImpl;
import com.fruit.service.MD5Service;
import com.fruit.service.impl.MD5ServiceImpl;

@WebServlet(name = "UserListServlet")
public class UserListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String cmd = request.getParameter("cmd");

        if ("alluser".equals(cmd))
            doAlluser(request, response);
        if ("updateuser".equals(cmd))
            doupdateuser(request, response);
        if ("adduser".equals(cmd))
            doadduser(request, response);
        if ("deluser".equals(cmd))
            dodeluser(request, response);
        if ("loginuser".equals(cmd))
            dologinuser(request, response);

    }

    protected void doAlluser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBDao db = new DBDaoImpl();
        List<UserObject> users = db.FindUserAll();
        System.out.println(users.toString());
        if (users.size() > 0 || users != null) {
            req.setAttribute("allusers", users);
            req.getRequestDispatcher("/admin/member-list.jsp").forward(req, resp);
        }
    }

    protected void doupdateuser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBDao db = new DBDaoImpl();
        //处理
        int id = Integer.valueOf(req.getParameter("email")).intValue();
        String username = req.getParameter("username");
        String password = req.getParameter("pass");
        String repassword = req.getParameter("repass");
        int result = 0;

        if (password.equals(repassword)) {
            // java自带工具包MessageDigest
            MD5Service md5=new MD5ServiceImpl();
            password=md5.Get_MD5(password);
            result = db.UpdateUserOne(id, username, password);
        } else {
            resp.sendRedirect("/admin/error.jsp");
        }

        if (result == 1) {
            resp.sendRedirect("/UserListServlet?cmd=alluser");
        } else {
            resp.sendRedirect("/admin/error.jsp");
        }
    }

    protected void doadduser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBDao db = new DBDaoImpl();
        //处理
        String username = req.getParameter("username");
        String password = req.getParameter("pass");
        String repassword = req.getParameter("repass");
        String email = req.getParameter("email");
        String act = req.getParameter("act");

        int islock = 0;
        int result = 0;

        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if (hashCodeV < 0) {//有可能是负数
            hashCodeV = -hashCodeV;
        }
        int id = hashCodeV;
        if (password.equals(repassword)) {
            // java自带工具包MessageDigest
            MD5Service md5=new MD5ServiceImpl();
            password=md5.Get_MD5(password);
            result = db.AddUserOne(id, username, password, email, islock);
        } else {
            resp.sendRedirect("/admin/error.jsp");
        }

        if (act == null) {
            if (result == 1) {
                resp.sendRedirect("/UserListServlet?cmd=alluser");
            } else {
                resp.sendRedirect("/admin/error.jsp");
            }
        } else {
            if (result == 1) {
                resp.sendRedirect("/login.jsp");
            } else {
                resp.sendRedirect("/admin/error.jsp");
            }
        }

    }

    protected void dodeluser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBDao db = new DBDaoImpl();
        int id = Integer.valueOf(req.getParameter("id")).intValue();
        int result = db.DelOne(id);
        if (result == 1) {
            resp.sendRedirect("/UserListServlet?cmd=alluser");
        } else {
            resp.sendRedirect("/admin/error.jsp");
        }
    }

    protected void dologinuser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBDao db = new DBDaoImpl();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        username = username.trim();
        password = password.trim();
        int result = 0;
        // java自带工具包MessageDigest
        MD5Service md5=new MD5ServiceImpl();
        password=md5.Get_MD5(password);
        result = db.UserLogin(username, password);

        //合法用户
        if (result == 1) {
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            resp.sendRedirect("/about.jsp");
        } else {
            PrintWriter out = resp.getWriter();
            out .write("<script>alert(\"登录失败！账号或者密码错误！\");window.location = \"/login.jsp\"</script>");
        }
    }
}

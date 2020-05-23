package com.fruit.servlet;

import com.fruit.Object.AdminObject;
import com.fruit.dao.DBDao;
import com.fruit.dao.impl.DBDaoImpl;
import com.fruit.service.MD5Service;
import com.fruit.service.impl.MD5ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class AdminListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String cmd = request.getParameter("cmd");

        if ("alladmin".equals(cmd))
            doAlluser(request, response);
        if ("updateadmin".equals(cmd))
            doupdateuser(request, response);
        if ("addadmin".equals(cmd))
            doadduser(request, response);
        if ("deladmin".equals(cmd))
            dodeluser(request, response);
    }

    protected void doAlluser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBDao db = new DBDaoImpl();
        List<AdminObject> admins = db.FindAdminAll();
        System.out.println(admins.toString());
        if (admins.size() > 0 || admins != null) {
            req.setAttribute("alladmins", admins);
            req.getRequestDispatcher("/admin/admin-list.jsp").forward(req, resp);
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
            result = db.UpdateAdminOne(id, username, password);
        } else {
            resp.sendRedirect("/admin/error.jsp");
        }

        if (result == 1) {
            resp.sendRedirect("/AdminListServlet?cmd=alladmin");
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
            result = db.AddAdminOne(id, username, password);
        } else {
            resp.sendRedirect("/admin/error.jsp");
        }

        if (result == 1) {
            resp.sendRedirect("/AdminListServlet?cmd=alladmin");
        } else {
            resp.sendRedirect("/admin/error.jsp");
        }
    }

    protected void dodeluser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBDao db = new DBDaoImpl();
        int id = Integer.valueOf(req.getParameter("id")).intValue();
        int result = db.DelAdminOne(id);
        if (result == 1) {
            resp.sendRedirect("/AdminListServlet?cmd=alladmin");
        } else {
            resp.sendRedirect("/admin/error.jsp");
        }
    }
}

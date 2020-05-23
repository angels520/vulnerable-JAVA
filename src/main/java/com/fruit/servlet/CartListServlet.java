package com.fruit.servlet;

import com.fruit.Object.CartObject;
import com.fruit.dao.DBCart;
import com.fruit.dao.impl.DBCartImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class CartListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String cmd = request.getParameter("cmd");

        if ("allcarts".equals(cmd))
            doAllcart(request, response);
        if ("addcart".equals(cmd))
            doaddcart(request, response);
        if ("delcart".equals(cmd))
            dodelcart(request, response);
    }

    protected void doAllcart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBCart db=new DBCartImpl();
        String username=req.getParameter("user");
        List<CartObject> carts = db.FindCartAll(username);

        if (carts.size() > 0 || carts != null) {
            req.setAttribute("allcarts", carts);
            req.getRequestDispatcher("/cart.jsp").forward(req, resp);
        }
    }

    protected void doaddcart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBCart db=new DBCartImpl();
        //处理
        String cartname =new String(req.getParameter("cartname").getBytes("ISO-8859-1"),"utf-8");
        long cartprice = System.currentTimeMillis()%100;
        String username=req.getParameter("user");
        int result = 0;

        int id = UUID.randomUUID().toString().hashCode();
        if (id < 0) {//有可能是负数
            id = -id;
        }

        result=db.AddCartOne(id,cartname,cartprice,username);
        if (result == 1) {
            resp.sendRedirect("/CartListServlet?cmd=allcarts&user="+username);//修改
        } else {
            resp.sendRedirect("/admin/error.jsp");
        }
    }

    protected void dodelcart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBCart db=new DBCartImpl();
        int id = Integer.valueOf(req.getParameter("id")).intValue();
        String username=req.getParameter("user");
        int result = db.DelOne(id);
        if (result == 1) {
            resp.sendRedirect("/CartListServlet?cmd=allcarts&user="+username);
        } else {
            resp.sendRedirect("/admin/error.jsp");
        }
    }
}

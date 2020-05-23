<%--
  Created by IntelliJ IDEA.
  User: lvy
  Date: 2020/3/14
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>后台登录</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="stylesheet" href="css/font.css">
    <link rel="stylesheet" href="css/login.css">
    <link rel="stylesheet" href="css/xadmin.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script src="lib/layui/layui.js" charset="utf-8"></script>

</head>
<body class="login-bg">
<%
    Cookie[] cookies = request.getCookies();
    //遍历cookie值，获取cookie名为uname的cookie
    String uname = "";
    if (cookies != null) {
        for (Cookie c : cookies) {
            if ("uname".equals(c.getName())) {
                uname = c.getValue();
            }
        }
    }
%>

<div class="login layui-anim layui-anim-up">
    <div class="message">管理登录</div>
    <div id="darkbannerwrap"></div>

    <form method="post" class="layui-form" action="/AdminServlet" method="post">
        <input name="username"  placeholder="用户名" type="text" lay-verify="required" class="layui-input">
        <hr class="hr15">
        <input name="password" lay-verify="required" placeholder="密码" type="password" class="layui-input">
        <hr class="hr15">
        <input value="登录" lay-submit style="width:100%;" type="submit">
        <hr class="hr20">
    </form>
</div>


</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: lvy
  Date: 2020/3/14
  Time: 13:36
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
    <link rel="stylesheet" href="css/xadmin.css">
    <link rel="stylesheet" href="css/a.css">
    <!-- <link rel="stylesheet" href="./css/theme5.css"> -->
    <script src="lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="js/xadmin.js"></script>

</head>
<body class="index">
<!-- 顶部开始 -->
<div class="container">
    <div class="logo">
        <a href="index.jsp">Admin</a></div>
    <div class="left_open">
        <a><i title="展开左侧栏" class="iconfont">&#xe699;</i></a>
    </div>

    <ul class="layui-nav right" lay-filter="">
        <li class="layui-nav-item">
            <a href="javascript:;">
                <%
                    String username = (String)session.getAttribute("admin");
                    if(username == null) {
                        response.sendRedirect("/admin/login.jsp");
                    } else {
                %>
                welcome,您! <%=username%>
                <%}%>
            </a>
            <dl class="layui-nav-child">
                <!-- 二级菜单 -->
                <dd>
                    <a href="/AdminServlet?cmd=quit">退出</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item to-index">
            <a href="/about.jsp">前台首页</a></li>
    </ul>
</div>
<!-- 顶部结束 -->
<!-- 中部开始 -->
<!-- 左侧菜单开始 -->
<div class="left-nav">
    <div id="side-nav">
        <ul id="nav">
            <li>
                <a href="javascript:;">
                    <i class="iconfont left-nav-li" lay-tips="会员管理">&#xe6b8;</i>
                    <cite>会员管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a onclick="xadmin.add_tab('会员列表','/UserListServlet?cmd=alluser')">
                            <i class="iconfont">&#xe6b8;</i>
                            <cite>会员列表</cite></a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="javascript:;">
                    <i class="iconfont left-nav-li" lay-tips="管理员管理">&#xe726;</i>
                    <cite>管理员管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i></a>
                <ul class="sub-menu">
                    <li>
                        <a onclick="xadmin.add_tab('管理员列表','/AdminListServlet?cmd=alladmin')">
                            <i class="iconfont">&#xe726;</i>
                            <cite>管理员列表</cite></a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="javascript:;">
                    <i class="iconfont left-nav-li" lay-tips="商品管理">&#xe6db;</i>
                    <cite>商品管理</cite>
                    <i class="iconfont nav_right">&#xe6db;</i></a>
                <ul class="sub-menu">
                    <li>
                        <a onclick="xadmin.add_tab('商品列表','/ShopListServlet?cmd=allshop')">
                            <i class="iconfont">&#xe6db;</i>
                            <cite>商品列表</cite></a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="javascript:;">
                    <i class="iconfont left-nav-li" lay-tips="留言管理">&#xe842;</i>
                    <cite>留言管理</cite>
                    <i class="iconfont nav_right">&#xe842;</i></a>
                <ul class="sub-menu">
                    <li>
                        <a onclick="xadmin.add_tab('留言列表','/MessageListServlet?cmd=allmessage')">
                            <i class="iconfont">&#xe842;</i>
                            <cite>留言列表</cite></a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="javascript:;">
                    <i class="iconfont left-nav-li" lay-tips="订单管理">&#xe698;</i>
                    <cite>订单管理</cite>
                    <i class="iconfont nav_right">&#xe698;</i></a>
                <ul class="sub-menu">
                    <li>
                        <a onclick="xadmin.add_tab('订单列表','/OrderListServlet?cmd=allcart')">
                            <i class="iconfont">&#xe698;</i>
                            <cite>订单列表</cite></a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</div>
<!-- <div class="x-slide_left"></div> -->
<!-- 左侧菜单结束 -->
<!-- 右侧主体开始 -->
<div class="page-content">
    <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
        <ul class="layui-tab-title">
            <li class="home">
                <i class="layui-icon">&#xe68e;</i>我的桌面
            </li>
        </ul>
        <div class="layui-unselect layui-form-select layui-form-selected" id="tab_right">
            <dl>
                <dd data-type="this">关闭当前</dd>
                <dd data-type="other">关闭其它</dd>
                <dd data-type="all">关闭全部</dd>
            </dl>
        </div>
        <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                <iframe src='welcome.jsp' frameborder="0" scrolling="yes" class="x-iframe"></iframe>
            </div>
        </div>
        <div id="tab_show"></div>
    </div>
</div>
<div class="page-content-bg"></div>
<style id="theme_style"></style>
<!-- 右侧主体结束 -->
<!-- 中部结束 -->

</html>

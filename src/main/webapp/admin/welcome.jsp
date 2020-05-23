<%@ page import="com.fruit.dao.DBDao" %>
<%@ page import="com.fruit.dao.impl.DBDaoImpl" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="sun.util.locale.provider.JRELocaleConstants" %>
<%@ page import="java.util.Locale" %><%--
  Created by IntelliJ IDEA.
  User: lvy
  Date: 2020/3/18
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>欢迎</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="stylesheet" href="./css/font.css">
    <link rel="stylesheet" href="./css/xadmin.css">
    <script src="./lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="./js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-body ">
                    <blockquote class="layui-elem-quote">欢迎管理员：
                        <span class="x-red">
                             <%
                                 String username = (String) session.getAttribute("admin");
                                 if (username == null) {
                                     response.sendRedirect("/admin/login.jsp");
                                 } else {
                             %>
                            <%=username%>
                            <%}%>
                        </span>
                        <%
                            java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            java.util.Date currentTime = new java.util.Date();//得到当前系统时间
                            String str_date1 = formatter.format(currentTime); //将日期时间格式化
                        %>
                        <%=str_date1%>
                    </blockquote>
                </div>
            </div>
        </div>
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">数据统计</div>
                <div class="layui-card-body ">
                    <ul class="layui-row layui-col-space10 layui-this x-admin-carousel x-admin-backlog">
                        <li class="layui-col-md2 layui-col-xs6">
                            <a href="javascript:;" class="x-admin-backlog-body">
                                <h3>管理员数</h3>
                                <p>
                                    <cite>
                                        <%
                                            Connection conn = null;
                                            PreparedStatement ps = null;
                                            ResultSet rs = null;
                                            int admin = 0;
                                            DBDao db = new DBDaoImpl();
                                            String sql = "select COUNT(id) as f from `admin`";
                                            try {
                                                conn = db.getConnection();
                                                ps = conn.prepareStatement(sql);
                                                rs = ps.executeQuery();
                                                while (rs.next()) {
                                                    admin = rs.getInt("f");
                                                }
                                            } catch (SQLException e) {
                                                e.printStackTrace();
                                            } finally {
                                                db.close(rs, ps, conn);
                                            }
                                        %><%=admin%>
                                    </cite>
                                </p>
                            </a>
                        </li>
                        <li class="layui-col-md2 layui-col-xs6">
                            <a href="javascript:;" class="x-admin-backlog-body">
                                <h3>会员数</h3>
                                <p>
                                    <cite>
                                        <%
                                            int user = 0;
                                            String sql1 = "select COUNT(id) as f from `user`";
                                            try {
                                                conn = db.getConnection();
                                                ps = conn.prepareStatement(sql1);
                                                rs = ps.executeQuery();
                                                while (rs.next()) {
                                                    user = rs.getInt("f");
                                                }
                                            } catch (SQLException e) {
                                                e.printStackTrace();
                                            } finally {
                                                db.close(rs, ps, conn);
                                            }
                                        %><%=user%>
                                    </cite>
                                </p>
                            </a>
                        </li>
                        <li class="layui-col-md2 layui-col-xs6">
                            <a href="javascript:;" class="x-admin-backlog-body">
                                <h3>商品数</h3>
                                <p>
                                    <cite>
                                        <%
                                            int shop = 0;
                                            String sql2 = "select COUNT(shopid) as f from `shangpin`";
                                            try {
                                                conn = db.getConnection();
                                                ps = conn.prepareStatement(sql2);
                                                rs = ps.executeQuery();
                                                while (rs.next()) {
                                                    shop = rs.getInt("f");
                                                }
                                            } catch (SQLException e) {
                                                e.printStackTrace();
                                            } finally {
                                                db.close(rs, ps, conn);
                                            }
                                        %><%=shop%>
                                    </cite>
                                </p>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">系统信息</div>
                <div class="layui-card-body ">
                    <table class="layui-table">
                        <tbody>
                        <tr>
                            <th>服务器地址</th>
                            <td><%=request.getRequestURL()%>
                            </td>
                        </tr>
                        <tr>
                            <th>操作系统</th>
                            <td><%=System.getProperty("os.name")%>
                            </td>
                        </tr>
                        <tr>
                            <th>运行语言</th>
                            <%
                                Locale locale = request.getLocale();
                                String country = locale.getCountry();
                                String language = locale.getLanguage();
                            %>
                            <td><%= locale + " " + country + " " + language%>
                            </td>
                        </tr>
                        <tr>
                            <th>JDK版本</th>
                            <td><%=
                            System.getProperty("java.version")%>
                            </td>
                        </tr>
                        <tr>
                            <th>VM版本</th>
                            <td><%=System.getProperty("java.vm.version")%>
                            </td>
                        </tr>
                        <tr>
                            <th>TOMCAT版本</th>
                            <td><%= application.getServerInfo() %>
                            </td>
                        </tr>
                        <tr>
                            <th>计算机用户名</th>
                            <td><%=System.getProperty("user.name")%>
                            </td>
                        </tr>
                        <%Runtime runtime = Runtime.getRuntime();%>
                        <tr>
                            <th>所有空间</th>
                            <td><%=runtime.totalMemory() / (1024 * 1024)%>Mb</td>
                        </tr>
                        <tr>
                            <th>剩余空间</th>
                            <td><%=runtime.freeMemory() / (1024 * 1024)%>Mb</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

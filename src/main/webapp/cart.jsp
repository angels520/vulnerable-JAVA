<%@ page import="com.fruit.Object.CartObject" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: lvy
  Date: 2020/3/15
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>购物车</title>
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all"/>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery.min.js"></script>
    <!-- Custom Theme files -->
    <!--theme-style-->
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <!--jd-->
    <link rel="stylesheet" type="text/css" href="css/jd.css"/>
    <link rel="stylesheet" type="text/css" href="css/reset.css"/>
    <script src="js/jd.js" type="text/javascript" charset="utf-8"></script>
    <!--//theme-style-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content="Vegetables Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design"/>
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);

    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>

    <script src="js/jquery.easydropdown.js"></script>
</head>
<body>
<!--header-->
<div class="header">
    <div class="container">
        <div class="header-top">
            <div class="logo">
                <a href="about.jsp"><img src="images/logo1.png" alt=" "></a>
            </div>
            <div class="search-in">
                <div class="header-grid">
                    <ul>
                        <li class="in-up"><a href="contact.jsp" class="scroll">联系</a> <label>|</label></li>
                        <li class="in-up"><a href="login.jsp" class="scroll"> 登录 </a> <label>|</label></li>
                        <li><a href="register.jsp" class="scroll">注册</a> <label>|</label></li>
                        <li>
                            <%
                                String username = (String)session.getAttribute("username");
                                if(username == null) {
                                    response.sendRedirect("/login.jsp");
                                } else {
                            %>
                            welcome,您! <%=username%>
                            <%}%>
                        </li>
                    </ul>
                </div>
                <div class="search-top">
                    <div class="search">
                        <form action="/ShopListServlet?cmd=searchshop" method="post">
                            <input type="text" value="Search" name="shopname" onfocus="this.value = '';"
                                   onblur="if (this.value == '') {this.value = '';}">
                            <input type="submit" value="">
                        </form>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
            <div class="clearfix"></div>
        </div>
        <div class="header-bottom-bottom">
            <div class="top-nav">
                <span class="menu"> </span>
                <ul>
                    <li><a href="/ShopListServlet?cmd=sendindex">主页</a></li>
                    <li><a href="about.jsp">关于我们</a></li>
                    <li class="active"><a href="/CartListServlet?cmd=allcarts&user=<%=username%>">购物车</a></li>
                    <li><a href="contact.jsp"> 联系我们 </a></li>
                </ul>
                <script>
                    $("span.menu").click(function () {
                        $(".top-nav ul").slideToggle(500, function () {
                        });
                    });
                </script>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<!---->
<div class="banner-in">
    <div class="container">
        <h6>主页 / <span>购物车</span></h6>
    </div>
</div>
<!--显示菜单的开始 -->
<!--warp令内容居中显示-->
<div style="margin-top: -120px;margin-bottom: 50px">
    <div class="tips warp">
        <ui>
            <li>
                <input type="checkbox" name="fav" id="all" onclick="checkTest1(this),checkTest2()"/>全选</li>
            <li>商品</li>
            <li>单价</li>
            <li>数量</li>
            <li>小计</li>
            <li>操作</li>
        </ui>
    </div>
    <!--显示菜单的结束-->

    <!--商品详情展示开始-->
    <%
        List<CartObject> users = new ArrayList<CartObject>();
        if (request.getAttribute("allcarts") != null) {
            users = (List<CartObject>) request.getAttribute("allcarts");
            for (CartObject user : users) {
                out.print("<div class=\"info warp\">\n" +
                        "\n" +
                        "        <ul>\n" +
                        "            <li class=\"info_1\"><input type=\"checkbox\" name=\"fav\" onclick=\"checkTest2()\" /> </li>\n" +
                        "            <li class=\"info_2\"> <img src=\""+user.getShopimg()+"\" width=\"80px\"/> </li>\n" +
                        "            <li class=\"info_3\"><a>【TT超市】"+user.getCartname()+"</a></li>\n" +
                        "            <li class=\"info_5\">"+user.getCartprice()+"</li>\n" +
                        "            <li class=\"info_6\">\n" +
                        "                <button onclick=\"checkTest3(this,1),checkTest2()\" >-</button>\n" +
                        "                <input type=\"text\" name=\"\" id=\"\" value=\"1\" />\n" +
                        "                <button class=\"bot\" onclick=\"checkTest3(this,2),checkTest2()\" >+</button>\n" +
                        "\n" +
                        "            </li>\n" +
                        "            <li class=\"info_7\">￥182.5</li>\n" +
                        "            <li>\n" +
                        "                <!--通过href触发后面的JS代码，通过点击自身-->\n" +
                        "                <a href=\"/CartListServlet?cmd=delcart&id="+user.getId()+"&user="+username+"\" class=\"scroll\">删除</a><br />\n" +
                        "                <a>已到我的关注</a>\n" +
                        "            </li>\n" +
                        "        </ul>\n" +
                        "\n" +
                        "    </div>");
            }
        }
    %>
    <!--商品详情展示结束-->

    <!--结算窗口开始-->
    <div class="balance warp">
        <ul class="balance_ul1">
            <li><input type="checkbox" name="fav" onclick="checkTest1(this),checkTest2()" />全选</li>
        </ul>

        <ul class="balance_ul2">
            <li class="butt"><a href="/buyshop.jsp">去结算</a></li>
        </ul>
    </div>
</div>
<%--<!--content-->--%>
<%--<div class="container">--%>
<%--    <div class="table-responsive">--%>
<%--        <table class="table table-condensed">--%>
<%--            <thead>--%>
<%--            <tr>--%>
<%--                <th>产品ID</th>--%>
<%--                <th>产品名称</th>--%>
<%--                <th>产品价格</th>--%>
<%--                <th>操作</th>--%>

<%--            </tr>--%>
<%--            </thead>--%>
<%--            <tbody>--%>
<%--            <%--%>
<%--                List<CartObject> users = new ArrayList<CartObject>();--%>
<%--                if (request.getAttribute("allcarts") != null) {--%>
<%--                    users = (List<CartObject>) request.getAttribute("allcarts");--%>
<%--                    for (CartObject user : users) {--%>
<%--                        out.print("<tr>\n" +--%>
<%--                                "                <td>"+user.getId()+"</td>\n" +--%>
<%--                                "                <td>"+user.getCartname()+"</td>\n" +--%>
<%--                                "                <td>"+user.getCartprice()+"</td>\n" +--%>
<%--                                "                <td>\n" +--%>
<%--                                "                <a href=\"/CartListServlet?cmd=delcart&id="+user.getId()+"&user="+username+"\" class=\"scroll\">删除商品</a>" +--%>
<%--                                "                 <a href=\"/buyshop.jsp\" class=\"scroll\">购买商品</a>"+--%>
<%--                                "                </td>\n" +--%>
<%--                                "            </tr>");--%>
<%--                    }--%>
<%--                }--%>
<%--            %>--%>
<%--            </tbody>--%>
<%--        </table>--%>
<%--    </div>--%>

<%--</div>--%>
<!--footer-->
<div class="footer">
    <div class="container">
        <p class="footer-grid">饭前吃水果，可以控制热量有利减肥。</p>
    </div>
</div>
</body>
</html>

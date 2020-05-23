<%@ page import="com.fruit.Object.ShopObject" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: lvy
  Date: 2020/3/15
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>商品详情</title>
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all"/>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery.min.js"></script>
    <!-- Custom Theme files -->
    <!--theme-style-->
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
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
                    <li>

                        <a href="/CartListServlet?cmd=allcarts&user=<%=username%>">购物车</a>
                    </li>
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
<!---->
<div class="banner-in">
    <div class="container">
        <h6>主页 / <span>商品详情</span></h6>
    </div>
</div>
<!---->
<div class="container">
    <div class="single">
        <div class="blog-top-in">
            <%
                List<ShopObject> users = new ArrayList<ShopObject>();
                if (request.getAttribute("shops") != null) {
                    users = (List<ShopObject>) request.getAttribute("shops");
                    for (ShopObject user : users) {
                        out.print("<div class=\"col-md-4 top-blog\">\n" +
                                "                <a href=\"#\"><img class=\"img-responsive\" src=\""+user.getShopimg()+"\" alt=\" \"></a>\n" +
                                "            </div>\n" +
                                "            <div class=\"col-md-8 sed-in\">\n" +
                                "                <h4>"+user.getShopname()+"</h4>\n" +
                                "                <ul>\n" +
                                "                    <li><a href=\"#\"><span><i> </i>Super user</span></a></li>\n" +
                                "                    <li><span><i class=\"clock\"> </i>2020</span></li>\n" +
                                "                    <li><span><i class=\"hit\"> </i>Hits:145</span></li>\n" +
                                "                </ul>\n" +
                                "                <p>"+user.getShopdetail()+"</p>\n" +
                                "            </div>"+
                                "<a href=\"/CartListServlet?cmd=addcart&cartname="+user.getShopname()+"&user="+username+"\" class=\"btn  btn-1c\">加入购物车</a>"
                        );
                    }
                }
            %>
            <div class="clearfix"></div>
        </div>

        <br/>
        <br/>
        <hr/>
        <!----start-leavecomment---->
        <div class="leave-comment">
            <h3>联系</h3>
            <div class="table-form">
                <form action="/MessageListServlet?cmd=addmessage" method="post">
                    <div>
                        <label>用户名<span>*</span></label>
                        <input type="text" name="username" value=" ">
                    </div>
                    <div>
                        <label>邮箱<span>*</span></label>
                        <input type="text" name="email" value=" ">
                    </div>
                    <div>
                        <input type="hidden" name="act" value="user">
                    </div>
                    <div>
                        <label>发送消息<span>*</span></label>
                        <textarea type="text" name="message"></textarea>
                    </div>
                    <input type="submit" value="提交">
                </form>
            </div>
        </div>
    </div>
</div>

<!---->
<div class="map-top">
    <div class="map">
        <iframe src=""></iframe>
    </div>
    <div class="address">
        <h5>地址</h5>
        <p>北京朝阳区</p>
        <a href="admin@btn.com" class="company">admin@btn.com</a>
    </div>
</div>

<!--footer-->
<div class="footer">
    <div class="container">
        <p class="footer-grid">饭前吃水果，可以控制热量有利减肥。</p>
    </div>
</div>

</body>
</html>

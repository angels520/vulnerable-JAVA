<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.fruit.Object.ShopObject" %><%--
  Created by IntelliJ IDEA.
  User: lvy
  Date: 2020/3/15
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>主页</title>
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
                    <li class="active"><a href="/ShopListServlet?cmd=sendindex">主页</a></li>
                    <li><a href="about.jsp">关于我们</a></li>
                    <li><a href="/CartListServlet?cmd=allcarts&user=<%=username%>">购物车</a></li>
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
<div class="banner">
    <!--slider-script-->
    <script src="js/responsiveslides.min.js"></script>
    <script>
        $(function () {
            $("#slider").responsiveSlides({
                auto: true,
                speed: 500,
                namespace: "callbacks",
                pager: true,
            });
        });
    </script>
    <!--//slider-script-->
    <!-- Slideshow 4 -->
    <div id="top" class="callbacks_container">
        <ul class="rslides" id="slider">
            <li>
                <img src="images/test.png" alt=""/>
                <div class="banner-matter">
                    <div class="price">
                        <h2>价美物廉</h2>
                    </div>
                    <div class="banner-para">
                        <p>新鲜水果每一天， 健康生活每一刻。看得见的新鲜，忘不了的美味。</p>
                    </div>
                </div>
            </li>

        </ul>
    </div>
</div>
<!-- //slider-->
<!--content-->
<div class="content">
    <div class="container">
        <div class="container">
            <div class="top-content">

                <%
                    List<ShopObject> users = new ArrayList<ShopObject>();
                    if (request.getAttribute("allshops") != null) {
                        users = (List<ShopObject>) request.getAttribute("allshops");
                        int i = 1;
                        for (ShopObject user : users) {
                            if (i % 4 == 0) {
                                out.print("<div class=\"col-md-3 look\">\n" +
                                        "                    <h4><a href=\"/ShopListServlet?cmd=senddetail&id=" + user.getShopid() + "\">" + user.getShopname() + " </a></h4>\n" +
                                        "                    <a href=\"/ShopListServlet?cmd=senddetail&id=" + user.getShopid() + "\"><img class=\"img-responsive center-block\" src=\"" + user.getShopimg() + "\" alt=\" \"></a>\n" +
                                        "                    <p>" + user.getShopdetail() + "</p>\n" +
                                        "                    <a href=\"/ShopListServlet?cmd=senddetail&id=" + user.getShopid() + "\" class=\"btn  btn-1c\">浏览更多</a>\n" +
                                        "                </div>");
                                out.print("<div class=\"clearfix\"> </div>\n" +
                                        "\t\t\t\t\t</div>");
                            } else if (i % 4 == 1) {
                                out.print("<div class=\"content-top\">");
                                out.print("<div class=\"col-md-3 look\">\n" +
                                        "                    <h4><a href=\"/ShopListServlet?cmd=senddetail&id=" + user.getShopid() + "\">" + user.getShopname() + " </a></h4>\n" +
                                        "                    <a href=\"/ShopListServlet?cmd=senddetail&id=" + user.getShopid() + "\"><img class=\"img-responsive center-block\" src=\"" + user.getShopimg() + "\" alt=\" \"></a>\n" +
                                        "                    <p>" + user.getShopdetail() + "</p>\n" +
                                        "                    <a href=\"/ShopListServlet?cmd=senddetail&id=" + user.getShopid() + "\" class=\"btn  btn-1c\">浏览更多</a>\n" +
                                        "                </div>");
                            } else {
                                out.print("<div class=\"col-md-3 look\">\n" +
                                        "                    <h4><a href=\"/ShopListServlet?cmd=senddetail&id=" + user.getShopid() + "\">" + user.getShopname() + " </a></h4>\n" +
                                        "                    <a href=\"/ShopListServlet?cmd=senddetail&id=" + user.getShopid() + "\"><img class=\"img-responsive center-block\" src=\"" + user.getShopimg() + "\" alt=\" \"></a>\n" +
                                        "                    <p>" + user.getShopdetail() + "</p>\n" +
                                        "                    <a href=\"/ShopListServlet?cmd=senddetail&id=" + user.getShopid() + "\" class=\"btn  btn-1c\">浏览更多</a>\n" +
                                        "                </div>");
                            }
                            i++;
                        }
                    }
                %>
            </div>
        </div>
    </div>
    <!---->
    <!---->
    <div class="content-bottom-top">
        <div class="wmuSlider example1">
            <div class="wmuSliderWrapper">
                <article style="position: absolute; width: 100%; opacity: 0;">
                    <div class="content-bottom">
                        <div class="container">
                            <span class="corn"> </span>
                            <h3>DO YOU KOWN ?</h3>
                            <p>真理好比水果，只有熟透时才能采摘。 </p>
                        </div>
                    </div>
                </article>
                <article style="position: absolute; width: 100%; opacity: 0;">
                    <div class="content-bottom">
                        <div class="container">
                            <span class="corn corn-in"> </span>
                            <h3>Do you Know ?</h3>
                            <p>水果不仅需要阳光，也需要凉夜。寒冷的雨水能使其成熟。人的性格陶冶不仅需要欢乐，也需要考验和困难。 </p>
                        </div>
                    </div>
                </article>
                <article style="position: absolute; width: 100%; opacity: 0;">
                    <div class="content-bottom">
                        <div class="container">
                            <span class="corn"> </span>
                            <h3>Do you Know ?</h3>
                            <p>在弥漫着收获喜悦的果园里，将甜美诱人的水果从丰硕的枝头摘下，无疑是惬意的农家的生活中最浪漫的劳作。 </p>
                        </div>
                    </div>
                </article>
            </div>
            <script src="js/jquery.wmuSlider.js"></script>
            <script>
                $('.example1').wmuSlider();
            </script>
        </div>
    </div>
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
</div>
<!--footer-->
<div class="footer">
    <div class="container">
        <p class="footer-grid">饭前吃水果，可以控制热量有利减肥。</p>
    </div>
</div>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: lvy
  Date: 2020/3/16
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>关于我们</title>
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
                    <li class="active"><a href="about.jsp">关于我们</a></li>
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
<!---->
<div class="banner-in">
    <div class="container">
        <h6>主页 / <span>关于我们</span></h6>
    </div>
</div>
<!---->
<div class="container">
    <div class="about">
        <div class="about-top">
            <div class="col-md-8 top-about">
                <h5>关于我们</h5>
                <p>
                    鲜果先送，先得鲜尝。开业钜惠，自然送个没商量。现在下单，只需稍等，您就知道天天鲜果的优惠是多么的丰厚，买三送一，买五送二，买十送五，好处多多益善啦。另有手工小酸奶即买即送，味道是极好的。什么？水果不新鲜，酸奶也不新鲜？这简直太令人发指了！没有人会容忍这种事情的发生，我们将誓死捍卫您拒收退货的权利，因为您不仅是永远正确的，还是永远可敬的。</p>
            </div>
            <div class="col-md-4 about-in">
                <a><img class="img-responsive" src="images/about.jpg" alt=" "></a>
            </div>
            <div class="clearfix"></div>
        </div>
        <!---->
        <div class="grig-top">
            <div class="col-md-4 grid-left-top">
                <h3><a >商家合作加盟</a></h3>
                <span>更优异的服务</span>
                <p>各个商家合作加盟，水果来源明确，产品新鲜</p>
            </div>
            <div class="col-md-8 grid-right-top">
                <h3><label>特点</label> <a >形态</a></h3>
                <span>果蔬类识别点</span>
                <p>1、形态：圆是圆，椭圆是椭圆，形状规整<br/>

                    2、色泽：蛇果颜色正，暗红<br/>

                    3、气味：果子气味芬芳，</p>
            </div>
            <div class="clearfix"></div>
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

/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-05-19 05:52:47 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>登录</title>\r\n");
      out.write("    <link href=\"css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\"/>\r\n");
      out.write("    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->\r\n");
      out.write("    <script src=\"js/jquery.min.js\"></script>\r\n");
      out.write("    <!-- Custom Theme files -->\r\n");
      out.write("    <!--theme-style-->\r\n");
      out.write("    <link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\"/>\r\n");
      out.write("    <!--//theme-style-->\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>\r\n");
      out.write("    <meta name=\"keywords\" content=\"Vegetables Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,\r\n");
      out.write("Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design\"/>\r\n");
      out.write("    <script type=\"application/x-javascript\"> addEventListener(\"load\", function () {\r\n");
      out.write("        setTimeout(hideURLbar, 0);\r\n");
      out.write("    }, false);\r\n");
      out.write("\r\n");
      out.write("    function hideURLbar() {\r\n");
      out.write("        window.scrollTo(0, 1);\r\n");
      out.write("    } </script>\r\n");
      out.write("    <script src=\"js/jquery.easydropdown.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<!--header-->\r\n");
      out.write("<div class=\"header\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <div class=\"header-top\">\r\n");
      out.write("            <div class=\"logo\">\r\n");
      out.write("                <a href=\"about.jsp\"><img src=\"images/logo1.png\" alt=\" \"></a>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"search-in\">\r\n");
      out.write("                <div class=\"header-grid\">\r\n");
      out.write("                    <ul>\r\n");
      out.write("                        <li class=\"in-up\"><a href=\"contact.jsp\" class=\"scroll\">联系</a> <label>|</label></li>\r\n");
      out.write("                        <li class=\"in-up\"><a href=\"login.jsp\" class=\"scroll\"> 登录 </a> <label>|</label></li>\r\n");
      out.write("                        <li><a href=\"register.jsp\" class=\"scroll\">注册</a> <label>|</label></li>\r\n");
      out.write("                        <li>\r\n");
      out.write("                            ");

                                String username = (String)session.getAttribute("username");
                                username="游客";
                            
      out.write("\r\n");
      out.write("                            welcome,您! ");
      out.print(username);
      out.write("\r\n");
      out.write("                        </li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"search-top\">\r\n");
      out.write("                    <div class=\"search\">\r\n");
      out.write("                        <form action=\"/ShopListServlet?cmd=searchshop\" method=\"post\">\r\n");
      out.write("                            <input type=\"text\" value=\"Search\" name=\"shopname\" onfocus=\"this.value = '';\"\r\n");
      out.write("                                   onblur=\"if (this.value == '') {this.value = '';}\">\r\n");
      out.write("                            <input type=\"submit\" value=\"\">\r\n");
      out.write("                        </form>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"clearfix\"></div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"clearfix\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"header-bottom-bottom\">\r\n");
      out.write("            <div class=\"top-nav\">\r\n");
      out.write("                <span class=\"menu\"> </span>\r\n");
      out.write("                <ul>\r\n");
      out.write("                    <li><a href=\"/ShopListServlet?cmd=sendindex\">主页</a></li>\r\n");
      out.write("                    <li><a href=\"about.jsp\">关于我们</a></li>\r\n");
      out.write("                    <li><a href=\"/CartListServlet?cmd=allcarts&user=");
      out.print(username);
      out.write("\">购物车</a></li>\r\n");
      out.write("                    <li><a href=\"contact.jsp\"> 联系我们 </a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("                <script>\r\n");
      out.write("                    $(\"span.menu\").click(function () {\r\n");
      out.write("                        $(\".top-nav ul\").slideToggle(500, function () {\r\n");
      out.write("                        });\r\n");
      out.write("                    });\r\n");
      out.write("                </script>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"clearfix\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<!---->\r\n");
      out.write("<div class=\"banner-in\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <h6>HOME / <span>CONTACT</span></h6>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<!---->\r\n");
      out.write("<!--content-->\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("    <div class=\"sign\">\r\n");
      out.write("        <h3>登录</h3>\r\n");
      out.write("        <form action=\"/UserListServlet?cmd=loginuser\" method=\"post\">\r\n");
      out.write("\r\n");
      out.write("            <div>\r\n");
      out.write("                <label>用户名</label>\r\n");
      out.write("                <input type=\"text\" name=\"username\" value=\" \">\r\n");
      out.write("            </div>\r\n");
      out.write("            <div>\r\n");
      out.write("                <label>密码</label>\r\n");
      out.write("                <input type=\"password\" name=\"password\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <input type=\"submit\" value=\"登录\">\r\n");
      out.write("        </form>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<!---->\r\n");
      out.write("<div class=\"map-top\">\r\n");
      out.write("    <div class=\"map\">\r\n");
      out.write("        <iframe src=\"\"></iframe>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"address\">\r\n");
      out.write("        <h5>地址</h5>\r\n");
      out.write("        <p>北京朝阳区</p>\r\n");
      out.write("        <a href=\"admin@btn.com\" class=\"company\">admin@btn.com</a>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<!--footer-->\r\n");
      out.write("<div class=\"footer\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <p class=\"footer-grid\">饭前吃水果，可以控制热量有利减肥。</p>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

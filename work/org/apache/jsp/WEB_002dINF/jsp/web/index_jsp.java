/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.59
 * Generated at: 2015-12-10 10:10:47 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
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
      out.write("<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\">\r\n");
      out.write("<title>对眼猫FM</title>\r\n");
      out.write("<meta http-equiv=\"keywords\" content=\"对眼猫FM，对眼猫，胎教音乐，古典音乐,classical music, classical，中国古典音乐,古典音乐下载,古典音乐播放,古典音乐试听,中国音乐,民族音乐,民间音乐,轻音乐,儿童音乐,经典歌曲,舞曲,民族舞蹈,芭蕾,乐器,钢琴,二胡,琵琶,古筝,萨克斯,小提琴,吉他,乐谱,贝多芬,莫扎特,巴赫,FM,fm\">\r\n");
      out.write("<meta name=\"description\" content=\"对眼猫FM是库客音乐推出的一款国内主打古典音乐的非流行音乐播放电台,以非流行音乐服务者身份切入，满足个人用户对于大量古典音乐及个性化电台供用户在线收听。\">\r\n");
      out.write("<link type=\"text/css\" rel=\"stylesheet\" href=\"/css/web/common.css\">\r\n");
      out.write("<link type=\"text/css\" rel=\"stylesheet\" href=\"/css/web/classicat.css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/jquery-1.11.1.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/download.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(function(){\r\n");
      out.write("\t$(\".cbtn-iphone\").click(function(){\r\n");
      out.write("\t\twindow.location = classicat.itunes;\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t$(\".cbtn-android\").click(function(){\r\n");
      out.write("\t\twindow.location = classicat.android;\r\n");
      out.write("\t});\r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"ctop-box\">\r\n");
      out.write("\t<div class=\"ctop-bg\">\r\n");
      out.write("\t\t<div class=\"ctop\">\r\n");
      out.write("\t\t\t<div class=\"cbox g4\">\r\n");
      out.write("\t\t\t\t<div class=\"cbox-top clearfix\">\r\n");
      out.write("\t\t\t\t\t<div class=\"cbox-top-pic\"><img src=\"/images/web/cbox-top-pic.png\" alt=\"\"></div>\r\n");
      out.write("\t\t\t\t\t<div class=\"cbox-top-info\">\r\n");
      out.write("\t\t\t\t\t\t<dl>\r\n");
      out.write("\t\t\t\t\t\t\t<dt>对眼猫</dt>\r\n");
      out.write("\t\t\t\t\t\t\t<dd>您的音乐新宠</dd>\r\n");
      out.write("\t\t\t\t\t\t</dl>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"cbox-bottom clearfix\">\r\n");
      out.write("\t\t\t\t\t<div class=\"cbox-bottom-qr\"><img src=\"/images/web/qr.png\" alt=\"\" width=\"136\" height=\"136\"></div>\r\n");
      out.write("\t\t\t\t\t<div class=\"cbox-bottom-btn\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:void(0)\" class=\"cbtn-iphone\">iPhone版下载</a>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:void(0)\" class=\"cbtn-android\">Android版下载</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<img src=\"/images/web/img1.png\" alt=\"\" class=\"g1\">\r\n");
      out.write("\t\t\t<img src=\"/images/web/img2.png\" alt=\"\" class=\"g2\">\r\n");
      out.write("\t\t\t<img src=\"/images/web/img3.png\" alt=\"\" class=\"g3\">\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"wrap\">\r\n");
      out.write("\t<div class=\"main\">\r\n");
      out.write("\t\t<div class=\"cbox-info clearfix\">\r\n");
      out.write("\t\t\t<div class=\"cbox-info-list t1\">\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t<li>海量全球古典乐资源</li>\r\n");
      out.write("\t\t\t\t\t<li>音乐听书相声应有尽有</li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"cbox-info-list t2\">\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t<li>新鲜唱片抢先听</li>\r\n");
      out.write("\t\t\t\t\t<li>古典专题也流行</li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"cbox-info-list t3\">\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t<li>传情、致谢、问候、贺喜</li>\r\n");
      out.write("\t\t\t\t\t<li>纷繁的人生需要一张简单的卡片</li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"cbox-foot\">\r\n");
      out.write("\t\t\t<p><span><em>@</em>库客音乐</span><span>京ICP证030879号 Copyright kuke.com</span><span>All rights reserved</span></p>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.59
 * Generated at: 2015-12-15 02:14:37 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class share_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width,initial-scale=1,user-scalable=no\">\r\n");
      out.write("<meta name=\"format-detection\" content=\"telephone=no\">\r\n");
      out.write("<meta name=\"apple-mobile-web-app-capable\" content=\"yes\">\r\n");
      out.write("<meta name=\"apple-mobile-web-app-status-bar-style\" content=\"black\">\r\n");
      out.write("<title>单曲分享</title>\r\n");
      out.write("<meta name=\"keywords\" content=\"\">\r\n");
      out.write("<meta name=\"description\" content=\"\">\r\n");
      out.write("<link href=\"../../css/init.css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"../../css/dym.css\" rel=\"stylesheet\" id=\"device\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"../../js/jquery-1.11.1.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../../js/play/TrackPlayer.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../../js/weixinshare.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"wrap dpn\" id=\"PC\"><!-- PC端单曲分享 -->\r\n");
      out.write("\t<div class=\"main\">\r\n");
      out.write("\t\t<div class=\"mbox clear\">\r\n");
      out.write("\t\t\t<div class=\"mright\">\r\n");
      out.write("\t\t\t\t<a href=\"index.html\">\r\n");
      out.write("\t\t\t\t\t<div class=\"qrbox\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"qr\"><img src=\"../../images/qr.png\" width=\"180\" height=\"180\" alt=\"\"></div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t<div class=\"dl clear\">\r\n");
      out.write("\t\t\t\t\t<div class=\"dl-list\">\r\n");
      out.write("\t\t\t\t\t\t<div><a href=\"javascript:void(0)\" class=\"dl-iphone\" id=\"ios_download\"></a></div>\r\n");
      out.write("\t\t\t\t\t\t<p>版本 1.0.4（14.9MB）</p>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"dl-list\">\r\n");
      out.write("\t\t\t\t\t\t<div><a href=\"javascript:void(0)\" class=\"dl-android\" id=\"android_download\"></a></div>\r\n");
      out.write("\t\t\t\t\t\t<p>版本 4.1.0（4.8MB）</p>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"mleft\">\r\n");
      out.write("\t\t\t\t<div class=\"cd-pic\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${track.img }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" alt=\"\">\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:void(0)\" class=\"cd-btn cd-play\" title=\"播放\" id=\"cdPlay\"></a>\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:void(0)\" class=\"cd-btn cd-pause\" title=\"暂停\" style=\"display:none;\" id=\"cdPause\"></a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"cd-title\">\r\n");
      out.write("\t\t\t\t\t<p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${track.title }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</p>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"saomiao\" id=\"saomiao\">\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:void(0)\">扫描到手机上</a>\r\n");
      out.write("\t\t\t\t\t<div class=\"s-qr dpn\" id=\"sqr\"><img src=\"../../images/qr.png\" width=\"180\" height=\"180\" alt=\"\"></div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"foot\">\r\n");
      out.write("\t\t\t<p><em>@</em><span>库客音乐</span><span>京ICP证030879号</span><span>Copyright kuke.com All rights reserved</span></p>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"wrap dpn\" id=\"Mobile\"><!-- 移动端单曲分享 -->\r\n");
      out.write("\t<div class=\"cdbox\">\r\n");
      out.write("\t\t<div class=\"cd-pic1\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${track.img }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" width=\"128\" height=\"128\">\r\n");
      out.write("\t\t\t<a href=\"javascript:void(0)\" class=\"cd-btn1 cd-play1\" title=\"播放\" id=\"cdPlay1\" ></a>\r\n");
      out.write("\t\t\t<a href=\"javascript:void(0)\" class=\"cd-btn1 cd-pause1\" title=\"暂停\" style=\"display:none;\" id=\"cdPause1\" ></a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"cd-title1\">\r\n");
      out.write("\t\t\t<p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${track.title }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</p>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"dlbox\">\r\n");
      out.write("\t\t<h1>对眼猫 让音乐找到你</h1>\r\n");
      out.write("\t\t<a href=\"javascript:void(0) \" id=\"mdl\">马上下载</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"qrbox1\">\r\n");
      out.write("\t\t<div class=\"qrbox-bg1\"><img src=\"../../images/qr-m.png\" alt=\"\" width=\"118\" height=\"119\"></div>\r\n");
      out.write("\t\t<p>扫描二维码下载</p>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<p class=\"foot\"><em>@</em><span>库客音乐</span><span>京ICP证030879号</span><span>Copyright kuke.com</span><span>All rights reserved</span></p>\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"pop-bg\"></div>\r\n");
      out.write("<div id=\"popup\"><img width=\"100%\" alt=\"\" src=\"http://ponent.kuke.com/static/images/notice.png\"></div>\r\n");
      out.write("<script>\r\n");
      out.write("function weixin_share_spt(){\r\n");
      out.write("\tvar title = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${track.title }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\tvar desc =  \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${track.title }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\tvar link = window.location.href.split('#')[0]; // 分享链接\r\n");
      out.write("\tvar imgUrl = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${track.img }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";// 分享图标\r\n");
      out.write("\t\r\n");
      out.write("\tvar weixin = ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${wx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(";\r\n");
      out.write("\t//调取分享方法\r\n");
      out.write("\tshareWX(title, desc, link, imgUrl, weixin);\r\n");
      out.write("}\r\n");
      out.write("$(function(){\r\n");
      out.write("\tvar player = new TrackPlayer();\r\n");
      out.write("\t(function(player){\r\n");
      out.write("\t\tvar item_code = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${track.item_code }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t\tvar l_code = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${track.l_code }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t\tvar labelid = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${track.labelid }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t\tvar array = new Array();\r\n");
      out.write("\t\tarray.push(l_code);\r\n");
      out.write("\t\tarray.push(item_code);\r\n");
      out.write("\t\tarray.push(labelid);\r\n");
      out.write("\t\tplayer.item_l_code_array.push(array);\r\n");
      out.write("\t})(player);\r\n");
      out.write("\t//player.mp3_play(0);\r\n");
      out.write("\t\r\n");
      out.write("\t//播放\r\n");
      out.write("\t$(\".cd-play,.cd-play1\").on(\"click\", function(){\r\n");
      out.write("\t\tplayer.mp3_play();\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("// \t//暂停\r\n");
      out.write("\t$(\".cd-pause,.cd-pause1\").on(\"click\", function(){\r\n");
      out.write("\t\tplayer.mp3_pause();\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function G(id){\r\n");
      out.write("\treturn document.getElementById(id);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("G(\"ios_download\").onclick=function(){\r\n");
      out.write("\tlocation.href=\"https://itunes.apple.com/app/id1001444595\"\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("G(\"android_download\").onclick=function(){\r\n");
      out.write("\tlocation.href=\"http://static.kuke.com/android/kkmusicfm3nd.apk\"\r\n");
      out.write("}\r\n");
      out.write("var ua = navigator.platform;\r\n");
      out.write("var pc = /win32|macintel/i.test(ua);\r\n");
      out.write("if(!pc){\r\n");
      out.write("\tG(\"device\").href = \"../../css/dym-m.css\";\r\n");
      out.write("\tG(\"PC\").style.display = \"none\";\r\n");
      out.write("\tG(\"Mobile\").style.display = \"block\";\r\n");
      out.write("}else{\r\n");
      out.write("\tG(\"device\").href = \"../../css/dym.css\";\r\n");
      out.write("\tG(\"PC\").style.display = \"block\";\r\n");
      out.write("\tG(\"Mobile\").style.display = \"none\";\r\n");
      out.write("}\r\n");
      out.write("G(\"saomiao\").onmouseover = function(){\r\n");
      out.write("\tG(\"sqr\").style.display = \"block\";\r\n");
      out.write("}\r\n");
      out.write("G(\"saomiao\").onmouseout = function(){\r\n");
      out.write("\tG(\"sqr\").style.display = \"none\";\r\n");
      out.write("}\r\n");
      out.write("G(\"cdPlay\").onclick = function(){\r\n");
      out.write("\tthis.style.display = \"none\";\r\n");
      out.write("\tG(\"cdPause\").style.display = \"block\";\r\n");
      out.write("}\r\n");
      out.write("G(\"cdPause\").onclick = function(){\r\n");
      out.write("\tthis.style.display = \"none\";\r\n");
      out.write("\tG(\"cdPlay\").style.display = \"block\";\r\n");
      out.write("}\r\n");
      out.write("G(\"cdPlay1\").onclick = function(){\r\n");
      out.write("\tthis.style.display = \"none\";\r\n");
      out.write("\tG(\"cdPause1\").style.display = \"block\";\r\n");
      out.write("}\r\n");
      out.write("G(\"cdPause1\").onclick = function(){\r\n");
      out.write("\tthis.style.display = \"none\";\r\n");
      out.write("\tG(\"cdPlay1\").style.display = \"block\";\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("var isIPhone = /iPhone/i.test(navigator.userAgent);\r\n");
      out.write("var isIPad = /iPad/i.test(navigator.userAgent);\r\n");
      out.write("var isAndroid = /android/i.test(navigator.userAgent);\r\n");
      out.write("var btndl = document.getElementById(\"mdl\");\r\n");
      out.write("//var btnAndroid = document.getElementById(\"bt19\");\r\n");
      out.write("//if(isIPhone || isIPad){\r\n");
      out.write("//\tbtnIOS.style.display = \"inline-block\";\r\n");
      out.write("\t// IOS 下载地址\r\n");
      out.write("//\tbtnIOS.href = encodeURI(\"https://itunes.apple.com/cn/app/ku-ke-yin-le/id730228198?mt=8\");\r\n");
      out.write("//}\r\n");
      out.write("//if(isAndroid){\r\n");
      out.write("//\tbtnAndroid.style.display = \"inline-block\";\r\n");
      out.write("\t// Indroid 下载地址\r\n");
      out.write("//\tbtnAndroid.href = \"http://static.kuke.com/android/kukemusic.apk\";\r\n");
      out.write("//\tbtnAndroid.onclick = is_weixn;\r\n");
      out.write("//\tG(\"btndl\").onclick =function(){\r\n");
      out.write("//\t\tlocation.href=\"http://static.kuke.com/android/kkmusicfm3nd.apk\";\r\n");
      out.write("//\t}\r\n");
      out.write("//}\r\n");
      out.write("//if(!/win32|macintel/i.test(navagator.platform)){\r\n");
      out.write("\tif(isAndroid){\r\n");
      out.write("\t\tbtndl.onclick =function(){\r\n");
      out.write("\t\t\tlocation.href=\"http://static.kuke.com/android/kkmusicfm3nd.apk\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tif(isIPhone){\r\n");
      out.write("\t\tbtndl.onclick =function(){\r\n");
      out.write("\t\t\tlocation.href=\"https://itunes.apple.com/app/id1001444595\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tif(/micromessenger/i.test(navigator.userAgent)){\r\n");
      out.write("\t\tbtndl.onclick =function(){\r\n");
      out.write("\t\t\tshowpop();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tG(\"pop-bg\").onclick = G(\"popup\").onclick = hidepop;\r\n");
      out.write("//}\r\n");
      out.write("function showpop(){\r\n");
      out.write("\tdocument.getElementById('pop-bg').style.display = 'block';\r\n");
      out.write("\tdocument.getElementById('popup').style.display = 'block';\r\n");
      out.write("}\r\n");
      out.write("function hidepop(){\r\n");
      out.write("\tdocument.getElementById('pop-bg').style.display = 'none';\r\n");
      out.write("\tdocument.getElementById('popup').style.display = 'none';\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("<audio src=\"/mp3/load.mp3\" id=\"playerxEnvXYXWHbCc\">您的浏览器不支持 audio 标签。</audio>\r\n");
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
/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.59
 * Generated at: 2015-12-15 08:05:38 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class reset_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>密码重置</title>\r\n");
      out.write("<meta name=\"keywords\" content=\"\">\r\n");
      out.write("<meta name=\"description\" content=\"\">\r\n");
      out.write("<link href=\"../../css/init.css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"../../css/dym.css\" rel=\"stylesheet\" id=\"device\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"../../js/jquery-1.11.1.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"main\">\r\n");
      out.write("\t<div class=\"resetbox clear\">\r\n");
      out.write("\t\t<div class=\"sleft\">\r\n");
      out.write("\t\t\t<h1>对眼猫密码重置</h1>\r\n");
      out.write("\t\t\t<form action=\"/kuke/classicat/resetPassword\">\r\n");
      out.write("\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" placeholder=\"密码\" class=\"st01\" name=\"password\" id=\"password\">\r\n");
      out.write("\t\t\t\t\t\t\t<span id=\"errorNew\" style=\"display:block;height:40px;line-height:40px;\"></span>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" placeholder=\"确认密码\" class=\"st01\" name=\"rePassword\" id=\"rePassword\">\r\n");
      out.write("\t\t\t\t\t\t\t<span id=\"errorCNew\" style=\"display:block;height:40px;line-height:40px;\"></span>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"email\" id=\"email\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${email}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"   ></input>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"button\"  value=\"提 交\" href=\"javascript:void(0)\" onclick=\"updatePassword()\" class=\"st02\"></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"sright\"><img src=\"../../images/logo.png\" alt=\"\"></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("    function isLengthInRange(obj, min, max){\r\n");
      out.write("    \tslen=getLength(obj);\r\n");
      out.write("    \tif (slen < min){\r\n");
      out.write("    \t\treturn false;\r\n");
      out.write("    \t}else if (slen > max){\r\n");
      out.write("    \t\treturn false;\r\n");
      out.write("    \t}else{\r\n");
      out.write("    \t\treturn true;\r\n");
      out.write("    \t}\r\n");
      out.write("    }\r\n");
      out.write("    var obj='';\r\n");
      out.write("    function getLength(obj){\r\n");
      out.write("    \treturn obj.replace(/[^x00-xff]/g,\"01\").length;\r\n");
      out.write("    \t}\r\n");
      out.write("\tfunction checkCPwd() {\r\n");
      out.write("\t\t var message = \"\";\r\n");
      out.write("\t\t\tvar position=\"\";\r\n");
      out.write("\t\t\topt = true;\r\n");
      out.write("\t\t    var newPass = $(\"#password\").val();\r\n");
      out.write("\t\t\tvar newCPass = $(\"#rePassword\").val();\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\tif (newPass != newCPass) {\r\n");
      out.write("\t\t\tmessage = error7;\r\n");
      out.write("\t\t\tposition=\"errorCNew\";\r\n");
      out.write("\t\t\topt = false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif (!isLengthInRange(newCPass, 6, 16)) {\r\n");
      out.write("\t\t\tmessage = error5_1;\r\n");
      out.write("\t\t\tposition=\"errorCNew\";\r\n");
      out.write("\t\t\topt = false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif (!isLengthInRange(newPass, 6, 16)) {\r\n");
      out.write("\t\t\tmessage = error5;\r\n");
      out.write("\t\t\tposition=\"errorNew\";\r\n");
      out.write("\t\t\topt = false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif (!opt) {\r\n");
      out.write("\t\t\t$(\"#\"+position).html(returnErrorHtml(message));\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\t$(\"#errorNew\").html(returnSureHtml(message));\r\n");
      out.write("\t\t\t$(\"#errorCNew\").html(returnSureHtml(message));\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\treturn opt;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction returnErrorHtml(message) {\r\n");
      out.write("\t\tif (null != message) {\r\n");
      out.write("\t\t\tvar html = \"\";\r\n");
      out.write("\t\t\thtml += '<span style=\"color:red;font-size:12px;\">' + message + '</span>';\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\treturn html;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction returnSureHtml() {\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction updatePassword(){\r\n");
      out.write("\t\tvar res = checkCPwd();\r\n");
      out.write("\t    var newPass = $(\"#password\").val();\r\n");
      out.write("\t\tvar newCPass = $(\"#rePassword\").val();\r\n");
      out.write("\t\tvar email = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${email}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t\tif(res){\r\n");
      out.write("\t\t\tjQuery.ajax({\r\n");
      out.write("\t\t\t\ttype : \"POST\",\r\n");
      out.write("\t\t\t\turl : \"/kuke/classicat/resetPassword\",\r\n");
      out.write("\t\t\t\tdataType : \"json\",\r\n");
      out.write("\t\t\t\t// async:true,\r\n");
      out.write("\t\t\t\tdata : {\r\n");
      out.write("\t\t\t\t\t'email' : email,\r\n");
      out.write("\t\t\t\t\t'password' : newPass,\r\n");
      out.write("\t\t\t\t\t'rePassword' : newCPass\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tsuccess : function(res,textStatus) {\r\n");
      out.write("\t\t\t\t\tif (res.flag==\"true\") {\r\n");
      out.write("\t\t\t\t\t\t$(\"#errorNew\").html('');\r\n");
      out.write("\t\t\t\t\t\t$(\"#errorCNew\").html('');\r\n");
      out.write("\t\t\t\t\t\t$(\"#password\").val('');\r\n");
      out.write("\t\t\t\t\t\t$(\"#rePassword\").val('');\r\n");
      out.write("\t\t\t\t\t\talert(\"密码修改成功。\");\r\n");
      out.write("\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\talert(res.msg);\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\terror : function(textStatus,errorThrown) {\r\n");
      out.write("\t\t\t\t\talert(errorThrown+ \"服务器错误！\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tvar error1 = \"注册失败，请稍后再试！\";\r\n");
      out.write("\tvar error2 = \"请详细填写必填项！\"\r\n");
      out.write("\tvar error3 = \"可输入4-16个英文或者2-8个汉字\"\r\n");
      out.write("\tvar error4 = \"昵称只能由字母、数字或汉字组成！\"\r\n");
      out.write("\tvar error5 = \"密码长度应该在6-16位字符之间！\"\r\n");
      out.write("\tvar error5_1 = \"密码长度应该在6-16位字符之间！\"\r\n");
      out.write("\tvar error6 = \"密码只能由字母和数字组成！\"\r\n");
      out.write("\tvar error7 = \"两次输入的密码不一致，请重新输入！\"\r\n");
      out.write("\tvar error8 = \"邮箱地址格式不正确！\"\t\r\n");
      out.write("\tvar error9 = \"昵称名已经存在，请重新输入！\"\r\n");
      out.write("\tvar error10 = \"邮箱已被使用，请您更换其他邮箱 ！\"\r\n");
      out.write("\tvar error11 = \"验证码错误！\"\r\n");
      out.write("\tvar error12 = \"用户名或密码错误！\"\r\n");
      out.write("\tvar error13 = \"发送失败，请稍后再试！\"\r\n");
      out.write("\tvar error14 = \"邮箱地址不正确！\"\r\n");
      out.write("\r\n");
      out.write("\tvar error15 = \"请填写用户名！\";\r\n");
      out.write("\tvar error16 = \"请填写密码！\";\r\n");
      out.write("\tvar error17 = \"请填验证码！\";\r\n");
      out.write("</script>\r\n");
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

/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.64
 * Generated at: 2015-10-19 07:34:19 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.relatorios;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class relatorios_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=ISO-8859-1");
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
      out.write("\r\n");
      out.write("\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../cabecalho.jsp", out, false);
      out.write(" \r\n");
      out.write("<div class=\"jumbotron\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-md-12 text-center\"\">\r\n");
      out.write("                    <h3 class=\"\"><strong>Relatórios</strong></h3>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-md-12 text-center\">\r\n");
      out.write("                    <div class=\"\">\r\n");
      out.write("                        <a href=\"\"><input type=\"button\" class=\"btn btn-inverse\" id=\"relatorio1\" value=\"Veículos mais consultados por idade\"/></a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"\">\r\n");
      out.write("                        <a href=\"\"><input type=\"button\" class=\"btn btn-inverse\" id=\"relatorio2\" value=\"Veículos mais consultados por Sexo\"/></a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"\">\r\n");
      out.write("                        <a href=\"\"><input type=\"button\" class=\"btn btn-inverse\" id=\"relatorio3\" value=\"Veículos mais consultados por região\"/></a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"\">\r\n");
      out.write("                        <a href=\"\"><input type=\"button\" class=\"btn btn-inverse\" id=\"relatorio4\" value=\"Concessionárias que mais venderam\"/></a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"\">\r\n");
      out.write("                        <a href=\"\"><input type=\"button\" class=\"btn btn-inverse\" id=\"relatorio5\" value=\"Veículos mais vendidos\"/></a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../rodape.jsp", out, false);
      out.write(' ');
      out.write(' ');
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

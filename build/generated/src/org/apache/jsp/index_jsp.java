package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "includes/topo.jsp", out, false);
      out.write("\r\n");
      out.write("    <div id=\"barra_horizontal_topo\">\r\n");
      out.write("        <img id=\"logo_psicologia\" src=\"imagens/psicologia_icone.png\" width=\"40\" height=\"40\"/>\r\n");
      out.write("        <h3>Mini Exame do Estado Mental</h3>\r\n");
      out.write("    </div>\r\n");
      out.write("    <form action=\"./LoginPsicologoController\" method=\"post\"><br><br><br><br><br>\r\n");
      out.write("        <center><div id=\"caixa-login\">\r\n");
      out.write("                <div id=\"caixa-login-titulo\"><img src=\"imagens/chave.png\" width=\"20\" height=\"20\"/> Faça seu login</div><br>\r\n");
      out.write("                <br>\r\n");
      out.write("                <table border=\"0\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td><img src=\"imagens/usuario.png\" width=\"20\" height=\"20\"/>\r\n");
      out.write("                        <input required=\"true\" autocomplete=\"on\" id=\"campo-login\" name=\"usuario\" placeholder=\"Usuário\"></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td><img src=\"imagens/senha.png\" width=\"20\" height=\"20\"/> \r\n");
      out.write("                        <input required=\"true\" autocomplete=\"on\" id=\"campo-login\" name=\"senha\" placeholder=\"Senha\" type=\"password\"></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td><center><input class=\"botao-login\" type=\"submit\" name=\"login\" value=\"Login\"></center></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                </table><br>\r\n");
      out.write("                \r\n");
      out.write("            <div id=\"aviso-caixa-login\">\r\n");
      out.write("                Não possui cadastro? Cadastre-se <a href=\"cadastro-psicologo.jsp\"><b>aqui!</b></a>\r\n");
      out.write("            </div><br>\r\n");
      out.write("            \r\n");
      out.write("        </div></center>           \r\n");
      out.write("               \r\n");
      out.write("    </form>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

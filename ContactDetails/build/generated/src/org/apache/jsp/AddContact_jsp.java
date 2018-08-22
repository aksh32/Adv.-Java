package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.jboss.weld.context.http.Http;

public final class AddContact_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Add Contact</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <center>\n");
      out.write("            ");
      MyPack.ContactList contact = null;
      synchronized (_jspx_page_context) {
        contact = (MyPack.ContactList) _jspx_page_context.getAttribute("contact", PageContext.PAGE_SCOPE);
        if (contact == null){
          contact = new MyPack.ContactList();
          _jspx_page_context.setAttribute("contact", contact, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.handleSetProperty(_jspx_page_context.findAttribute("contact"), "cFname",
 request.getParameter("fname"));
      out.write("\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.handleSetProperty(_jspx_page_context.findAttribute("contact"), "cLname",
 request.getParameter("lname"));
      out.write("\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.handleSetProperty(_jspx_page_context.findAttribute("contact"), "cnumber",
 request.getParameter("Cnum"));
      out.write("\n");
      out.write("            \n");
      out.write("            <h2>Contact Info</h2>\n");
      out.write("            ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((MyPack.ContactList)_jspx_page_context.findAttribute("contact")).getcFname())));
      out.write("\n");
      out.write("            ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((MyPack.ContactList)_jspx_page_context.findAttribute("contact")).getcLname())));
      out.write("\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((MyPack.ContactList)_jspx_page_context.findAttribute("contact")).getCnumber())));
      out.write("\n");
      out.write("            ");

                 String cname1=request.getParameter("cname");
            String cnumber1=request.getParameter("cnumber");
            Cookie cookie=null;
            Cookie[]cookies=null;
            cookies=request.getCookies();
            if(cookies!=null){
                out.print("<br>");
                out.println("Cookies found");
                out.print("<br>");
                //response.addCookie(cookie);
                for(int i=1;i<cookies.length;i++){
                    cookie=cookies[i];
                    out.println(cookie.getName());
                    out.print(cookie.getValue());
                    out.print(" ");
                    Cookie cn = new Cookie("cname"+i,request.getParameter("cname")); 
                response.addCookie(cn);
                Cookie cnum = new Cookie("cnumber"+i,request.getParameter("cnumber")); 
                response.addCookie(cnum);
                    
                }
                
            }
            else
            {
                out.println("<h2> Created new Cookie </h2>");
                Cookie cn = new Cookie("cname",request.getParameter("cname")); 
                response.addCookie(cn);
                Cookie cnum = new Cookie("cnumber",request.getParameter("cnumber")); 
                response.addCookie(cnum);
                
            }
            
      out.write("\n");
      out.write("        </center>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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

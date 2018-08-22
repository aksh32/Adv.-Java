<%-- 
    Document   : AddContact
    Created on : 22 Aug, 2018, 2:22:02 PM
    Author     : studentadmin
--%>


<%@page import="org.jboss.weld.context.http.Http"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Contact</title>
    </head>
    <body>
        <center>
            <jsp:useBean id="contact" class="MyPack.ContactList"/>
            <jsp:setProperty name="contact" property="cFname" value="<%= request.getParameter("fname")%>"/>
            <jsp:setProperty name="contact" property="cLname" value="<%= request.getParameter("lname")%>"/>
            <jsp:setProperty name="contact" property="cnumber" value="<%= request.getParameter("Cnum")%>"/>
            
            <h2>Contact Info</h2>
            <jsp:getProperty name="contact" property="cFname"/>
            <jsp:getProperty name="contact" property="cLname"/>
            <br>
            <br>
            <jsp:getProperty name="contact" property="cnumber"/>
            <%
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
            %>
        </center>
    </body>
</html>

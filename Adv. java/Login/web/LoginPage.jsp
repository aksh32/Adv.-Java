<%-- 
    Document   : LoginPage
    Created on : 9 Oct, 2018, 9:43:31 AM
    Author     : studentadmin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <center>
            <html:form action="/login">
                <table border="1">
                    <tbody>
                        <tr>
                            <td colspan="2" align="center"><bean:write name="LoginForm" property="error" filter="false"/></td>
                        </tr>
                        <tr>
                            <td>Enter Your Name: </td>
                            <td><html:text property="name"/></td>
                        </tr>
                        <tr>
                            <td>Enter Your Email: </td>
                            <td><html:text property="email"/></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><html:submit value="Login"/></td>
                        </tr>
                    </tbody>
                </table> 
            </html:form>
        </center>
    </body>
</html>

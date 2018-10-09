<%-- 
    Document   : success
    Created on : 9 Oct, 2018, 9:57:43 AM
    Author     : studentadmin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Successful</title>
    </head>
    <body>
        <center>
            <h1>Congratulations!</h1>
            
            <p>You Have Successfully Logged in.</p>
            
            <p>Your Name is: <bean:write name="LoginForm" property="name"/></p>
            <p>Your Email id is: <bean:write name="LoginForm" property="email"/></p>
        </center>
    </body>
</html>

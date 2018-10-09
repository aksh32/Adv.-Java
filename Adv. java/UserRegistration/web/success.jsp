<%-- 
    Document   : success
    Created on : 9 Oct, 2018, 11:37:24 AM
    Author     : studentadmin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Successful</title>
    </head>
    <body>
        <center>
            <h1>Congratulations!</h1>
            <p>You Have Registered Successfully.</p>
            <table border="1">
                <tr align="center">
                    <th>Name</th>
                    <th>Email id</th>
                    <th>Contact Number</th>
                </tr>
                <tr align="center">
                    <td><bean:write name="RegisterUser" property="name"/></td>
                    <td><bean:write name="RegisterUser" property="email"/></td>
                    <td><bean:write name="RegisterUser" property="contNo"/></td>
                </tr>
            </table>
        </center>
    </body>
</html>

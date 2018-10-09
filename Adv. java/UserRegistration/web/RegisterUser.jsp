<%-- 
    Document   : RegisterUser
    Created on : 9 Oct, 2018, 11:02:11 AM
    Author     : studentadmin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib  uri="http://struts.apache.org/tags-html" prefix="html"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register User</title>
    </head>
    <body>
        <center>
            <html:form action="/register">
                <table>
                    <tr align="center">
                        <td>Enter Name: </td>
                        <td><html:text property="name"/></td>
                        <td><bean:write name="RegisterUser" property="error" filter="false"/></td>
                    </tr>
                    <tr align="center">
                        <td>Enter Designation: </td>
                        <td><html:text property="designation"/></td>
                        <td><bean:write name="RegisterUser" property="error" filter="false"/></td>
                    </tr>
                    <tr align="center">
                        <td>Enter Organization: </td>
                        <td><html:text property="org"/></td>
                        <td><bean:write name="RegisterUser" property="error" filter="false"/></td>
                    </tr>
                    <tr align="center">
                        <td>Enter Experience (no. of years): </td>
                        <td><html:text property="exp"/></td>
                        <td><bean:write name="RegisterUser" property="error" filter="false"/></td>
                    </tr>
                    <tr align="center">
                        <td>Select Gender: </td>
                        <td><html:radio property="gender" value="male">Male</html:radio></td>
                        <td><html:radio property="gender" value="female">Female</html:radio></td>
                        <td><bean:write name="RegisterUser" property="error" filter="false"/></td>
                    </tr>
                    <tr align="center">
                        <td>Enter Email id: </td>
                        <td><input type="email"></td>
                        <td><bean:write name="RegisterUser" property="error" filter="false"/></td>
                    </tr>
                    <tr align="center">
                        <td>Enter Contact No.: </td>
                        <td><input type="number"></td>
                        <td><bean:write name="RegisterUser" property="error" filter="false"/></td>
                    </tr>
                    <tr align="center">
                        <td><input type="submit" value="Register"></td>
                    </tr>
                </table>
            </html:form>
        </center>
    </body>
</html>

<%-- 
    Document   : Transfer
    Created on : 8 Sep, 2018, 2:22:00 PM
    Author     : studentadmin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<jsp:useBean id="sess" scope="session" class="Beans.CustomerDetails"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Transfer Amount</title>
    </head>
    <body>
        <center>
            <h1>Welcome <c:out value="sess.cust_name"/> </h1>
        </center>
    </body>
</html>

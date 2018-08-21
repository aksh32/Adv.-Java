<%-- 
    Document   : index
    Created on : 14 Aug, 2018, 11:53:58 AM
    Author     : studentadmin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Time Table</title>
    </head>
    <body>
        <center>
            <jsp:include page = "header.html" />
            <sql:setDataSource var="timetable" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/timetable" user="root" password="root" scope="page"/>
            <h1>Welcome!</h1>
            <fieldset style="width: 500px">
                <legend align="left">Set Time Table</legend>
                <sql:query var="timeTableQuery" dataSource="timetable" scope="page">
                    select * from slots;
                </sql:query>
                <form method="POST" action="">
                    <label for="TS">Select Time Slot: </label>
                    <select name="TS">
                        <option value="0"></option>
                    </select>
                    <br>
                    <br>
                    <label for="day">Select Day: </label>
                    <select name="day">
                        <option value="0"></option>
                    </select>
                    <br>
                    <br>
                    <label for="sub">Select Subject: </label>
                    <select name="sub">
                        <option value="0"></option>
                    </select>
                    <br>
                    <br>
                    <input type="submit" value="Submit">
                </form>
            </fieldset>
        </center>
    </body>
</html>

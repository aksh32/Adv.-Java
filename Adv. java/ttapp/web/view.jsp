<%-- 
    Document   : view
    Created on : 5 Sep, 2018, 3:32:25 PM
    Author     : studentadmin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>view Time Table</title>
    </head>
    <body>
        <center>
            <jsp:include page = "header.html" />
             <sql:setDataSource var="timeTableDataSource" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/timetable?useSSL=FALSE" user="root" password="root" scope="page"/>
                 <fieldset style="width: 500px">
                     <legend align="left">View Time Table</legend>
                    <form method="Post" action="ViewTT">                  
                        <label for="day">Select Day: </label>
                        <select name="day">
                            <option value="Monday">Monday</option>
                            <option value="Tuesday">Tuesday</option>
                            <option value="Wednesday">Wednesday</option>
                            <option value="Thursday">Thursday</option>
                            <option value="Friday">Friday</option>
                            <option value="Saturday">Saturday</option>
                        </select>
                        <br><br>
                        <input type="Submit" value="VIEW"/>
                    </form> 
                 </fieldset>
        </center>
    </body>
</html>

<%-- 
    Document   : edit
    Created on : 28 Aug, 2018, 11:45:00 AM
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
            
            <sql:setDataSource var="timetable" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/timetable?useSSL=FALSE" user="root" password="root" scope="page"/>
            <h2>Edit Time Table</h2>
            <fieldset style="width: 500px">
                <legend align="left">Set Time Table</legend>
                <form method="POST" action="editTT">
                    <label for="TS">Select Time Slot: </label>
                    <sql:query var="timeTableQuery" dataSource="${timetable}">
                        select * from slots;
                    </sql:query>
                    <select name="TS">
                        <c:forEach var="row" items="${timeTableQuery.rows}">
                            <option value="<c:out value="${row.Slot_id}"/>"> <c:out value="${row.Time}"/> </option>
                        </c:forEach>
                    </select>
                    <br>
                    <br>
                    <label for="day">Select Day: </label>
                    <select name="day">
                        <option value="Monday">Monday</option>
                        <option value="Tuesday">Tuesday</option>
                        <option value="Wednesday">Wednesday</option>
                        <option value="Thursday">Thursday</option>
                        <option value="Friday">Friday</option>
                        <option value="Saturday">Saturday</option>
                    </select>
                    <br>
                    <br>
                    <label for="sub">Select Subject: </label>
                    <sql:query var="SubjectQuery" dataSource="${timetable}">
                        select * from subjects;
                    </sql:query>
                    <select name="sub">
                        <c:forEach var="row" items="${SubjectQuery.rows}">
                            <option value="<c:out value="${row.Subject_id}"/>"> <c:out value="${row.Course}"/> </option>
                        </c:forEach>
                    </select>
                    <br>
                    <br>
                    <input type="submit" value="Done">
                </form>
            </fieldset>
        </center>
    </body>
</html>

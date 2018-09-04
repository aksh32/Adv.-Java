<%-- 
    Document   : AccountDetails
    Created on : 4 Sep, 2018, 10:38:42 AM
    Author     : studentadmin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Account Details</title>
    </head>
    <body>
        <center>
            <c:set var="uname" value="<%=request.getParameter("uname")%>"/>
            <c:set var="pass" value="<%=request.getParameter("passwrd")%>"/>
            
            <sql:setDataSource var="bankDataSource" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/bank_db?useSSL=FALSE" user="root" password="root" scope="page"/>
            <sql:query var="cust_query" dataSource="${bankDataSource}">
                SELECT * FROM customer WHERE user_name=? AND password=?;
                <sql:param value="${uname}"/>
                <sql:param value="${pass}"/>
            </sql:query>
                
                <c:forEach var="row" items="${cust_query.rows}">
                    <c:set var="custid" value="${row.cust_id}"/>
                    <jsp:useBean id="customer" scope="session" class="Beans.CustomerDetails">
                        <jsp:setProperty name="customer" property="cust_id" value="${row.cust_id}"/>
                        <jsp:setProperty name="customer" property="cust_name" value="${row.cust_name}"/>
                        <jsp:setProperty name="customer" property="user_name" value="${row.user_name}"/>
                    </jsp:useBean>
                    Welcome <c:out value="${row.cust_name}"/>
                </c:forEach>
                    <sql:query var="accQuery" dataSource="${bankDataSource}">
                        SELECT * FROM account WHERE cust_id =?;
                        <sql:param value="${custid}"/>
                    </sql:query>
                        <table border="1" width="50%">
                            <tr>
                                <th>Account Number</th>
                                <th>Account Type</th>
                                <th>Balance</th>
                            </tr>
                            <c:forEach var="row" items="${accQuery.rows}">
                                <tr>
                                    <td> <c:out value="${row.acc_no}"/> </td>
                                    <td> <c:out value="${row.type}"/> </td>
                                    <td> <c:out value="${row.balance}"/> </td>
                                </tr>
                            </c:forEach>
                        </table>
                        <a href="Transfer.jsp">Transfer Amount</a>
        </center>
    </body>
</html>

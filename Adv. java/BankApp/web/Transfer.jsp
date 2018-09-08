<%-- 
    Document   : Transfer
    Created on : 8 Sep, 2018, 2:22:00 PM
    Author     : studentadmin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Transfer Amount</title>
    </head>
    <body>
        <center>
            Welcome, <c:out value=" ${customer.cust_name} "/>
            <br>
            <br>
            <br>
            <fieldset style="width: 500px">
            <legend align="left">Account Transfer</legend>
                <form method="POST" action="transfer">
                    <sql:setDataSource var="bankDataSource" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/bank_db?useSSL=FALSE" user="root" password="root" scope="page"/>

                    <sql:query var="AccQuery" dataSource="${bankDataSource}" >
                        select * from account WHERE cust_id = ?;
                        <sql:param value="${customer.cust_id}"/>
                    </sql:query>
                        
                    <label for="from_acc">Select Account Number: </label>
                    <select name="from_acc">
                        <c:forEach var="row" items="${AccQuery.rows}">
                            <option value="<c:out value="${row.acc_no}"/>"><c:out value="${row.acc_no}"/></option>
                        </c:forEach>
                    </select>
                    <br>
                    <br>
                    <label for="to_acc">Beneficiary Account Number: </label>
                    <input type="text" name="to_acc">
                    <br>
                    <br>
                    <label for="amt">Amount: </label>
                    <input type="text" name="amt">
                    <br>
                    <br>
                    <input type="submit" value="Transfer">
                </form>
            </fieldset>
        </center>
    </body>
</html>

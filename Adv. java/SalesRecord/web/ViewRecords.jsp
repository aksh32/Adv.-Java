<%-- 
    Document   : ViewRecords
    Created on : 25 Sep, 2018, 10:14:21 AM
    Author     : studentadmin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sales Record</title>
    </head>
    <body>
        <center>
            <fieldset style="width: 500px">
                <legend align="left">View Sales Records</legend>
                    <fieldset style="width: 200px">
                        <legend align="left">By Name</legend>
                        <form method="POST" action="viewByName.jsp">
                        <c:import var="SalesRecord" url="SalesRecord.xml"/>

                        <x:parse xml="${SalesRecord}" var="file"/>

                        <label for="ByName">Search By Name: </label>
                        <select name="ByName" id="Byname">
                            <x:forEach select="$file/sales/record" var="name">
                                <option value="<x:out select="firstname/text()"/>"><x:out select="firstname/text()"/></option>
                            </x:forEach>
                        </select>
                        <input type="submit" value="view">
                        </form>
                    </fieldset>

                        <br>
                    <fieldset style="width: 200px"> 
                        <legend align="left">By Quarter</legend>
                        <label for="Byquarter">Search By Quarter: </label>
                        <select name="Byquarter" id="Byquarter">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                        </select>
                    </fieldset>
                        <br>
                    <fieldset style="width: 200px">    
                        <legend align="left">By Country</legend>
                        <label for="Bycountry">Search By Country: </label>
                        <select name="Bycountry" id="Bycountry">
                            <x:forEach select="$file/sales/record" var="name">
                                <option value="<x:out select="country/text()"/>"><x:out select="country/text()"/></option>
                            </x:forEach>
                        </select>
                    </fieldset>
            </fieldset>
        </center>
    </body>
</html>

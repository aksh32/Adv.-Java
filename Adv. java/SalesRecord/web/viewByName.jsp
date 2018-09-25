<%-- 
    Document   : viewByName
    Created on : 25 Sep, 2018, 12:25:33 PM
    Author     : studentadmin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:import var="SalesRecord" url="SalesRecord.xml"/>
        <x:parse xml="${SalesRecord}" var="file"/>
        <c:set var="name" value="<%= request.getParameter("Byname") %>"/>
        <x:set var="na" select="$file/sales/record[1]/firstname/text()" />
                        <x:if select="na = name">
                            <table>
                                <tr>
                                    <th>Quarter</th>
                                    <th>Sales</th>
                                </tr>
                                <x:forEach select = "$file/sales/record/sale/quarter">
                                    <tr>
                                        <td><x:out select="id"/></td>
                                        <td><x:out select="amount"/></td>
                                    </tr>
                                </x:forEach>
                            </table>
                        </x:if>
    </body>
</html>

<%--
    Document   : create_status
    Created on : May 14, 2023, 7:10:01 PM
    Author     : vince
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Create status</title>
    </head>
    <body>
        <c:choose>
            <c:when test="${status == 'exist'}">
                <h1>User exists</h1>
            </c:when>

            <c:otherwise>
                <h1>Create ${requestScope.status}</h1>
            </c:otherwise>
        </c:choose>
        <hr />
        
        <a href="index.jsp">Back</a>
    </body>
</html>

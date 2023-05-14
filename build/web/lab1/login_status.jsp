<%--
    Document   : login_status
    Created on : May 14, 2023, 7:24:40 PM
    Author     : vince
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Login status</title>
    </head>
    <body>
        <c:choose>
            <c:when test="${status == 'failed'}">
                <h1>Login failed.</h1>
            </c:when>

            <c:when test="${status == 'successful'}">
                <h1>Welcome, ${student.name}</h1>
            </c:when>

            <c:when test="${status == 'exception'}">
                <h1>Encounter error</h1>
            </c:when>
        </c:choose>
        <hr />

        <c:if test="${status == 'successful'}">
            <p>ID: ${student.id}</p>
            <p>Name: ${f:escapeXml(student.name)}</p>
            <p>Password: ${f:escapeXml(student.password)}</p>
            <br />
        </c:if>

        <a href="index.jsp">Back to index</a>
    </body>
</html>

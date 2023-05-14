<%--
    Document   : product_get
    Created on : May 15, 2023, 1:29:14 AM
    Author     : vince
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Login</title>
    </head>
    <body>
        <h1>You choose: ${productsChosen == '' ? 'none' : productsChosen}</h1>
        <hr />

        <a href="index.jsp">Back to index</a>
    </body>
</html>

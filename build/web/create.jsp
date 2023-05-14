<%--
    Document   : create
    Created on : May 13, 2023, 1:04:07 PM
    Author     : vince
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Create</title>
    </head>

    <body>
        <h1>Create</h1>
        <hr />

        <form action="CreateServlet" method="post">
            <label for="username">Username: </label>
            <input id="username" type="text" name="username" placeholder="name here..." />
            <br />

            <label for="password">Password: </label>
            <input id="password" type="password" name="password" placeholder="pass here..." />
            <br />

            <input type="submit" value="Create" />
        </form>
    </body>
</html>

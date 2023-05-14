<%--
    Document   : Login
    Created on : May 13, 2023, 1:09:38 PM
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
        <h1>Login</h1>
        <hr />

        <form action="/Demo/LoginServlet" method="post">
            <label for="username">Username: </label>
            <input id="username" type="text" name="txtName" placeholder="name here..." required />
            <br />

            <label for="password">Password: </label>
            <input id="password" type="password" name="txtPass" placeholder="pass here..." required />
            <br />

            <input type="submit" value="Login" />
        </form>
    </body>
</html>

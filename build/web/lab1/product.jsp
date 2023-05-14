<%--
    Document   : product.jsp
    Created on : May 15, 2023, 1:20:03 AM
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
        <h1>Choose your products:</h1>
        <hr />

        <form action="/Demo/ProductServlet" method="post">
            <input id="product1" type="checkbox" name="products" value="Servlet & JSP" />
            <label for="product1">Servlet & JSP</label>
            <br />

            <input id="product2" type="checkbox" name="products" value="Struts & JSF" />
            <label for="product2">Struts & JSF</label>
            <br />

            <input id="product3" type="checkbox" name="products" value="EJB" />
            <label for="product3">EJB</label>
            <br />

            <input id="product4" type="checkbox" name="products" value="XMJ" />
            <label for="product4">XMJ</label>
            <br />

            <input id="product5" type="checkbox" name="products" value="Java Web Services" />
            <label for="product5">Java Web Services</label>
            <br />

            <input type="submit" value="Choose" />
        </form>
    </body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Welcome</title>
    </head>

    <body>
        <section class="admin-container">
            <img src="" alt="logo" />
            <h1>Welcome back [${f:escapeXml(sessionScope.user.roleID)}]: ${f:escapeXml(sessionScope.user.fullName)}</h1>

            <div class="search-container">
                <form action="/Management/c?a=search-admin&p=admin" method="post">
                    <div class="input">
                        <input id="search" type="text" name="txtSearch" value="${prevTxtSearch}" placeholder="Search user..." />
                        <label for="search" class="hidden">Search for user</label>

                        <input type="submit" value="Search" />
                    </div>
                </form>
            </div>

            <div class="table">
                <c:choose>
                    <c:when test="${not empty users}">
                        <c:forEach items="${users}" var="userObj">
                            <div>
                                <p>User ID: ${f:escapeXml(userObj.roleID)}</p>
                                <p>Full Name: ${f:escapeXml(userObj.fullName)}</p>
                                <p>Role ID: ${f:escapeXml(userObj.roleID)}</p>
                                <p>Password: &#x2022;&#x2022;&#x2022;&#x2022;&#x2022;</p>
                                <a>Delete</a>
                                <a>Update</a>
                            </div>
                        </c:forEach>
                    </c:when>

                    <c:otherwise>
                        <h2>No user found.</h2>
                    </c:otherwise>
                </c:choose>
            </div>
        </section>
    </body>
</html>

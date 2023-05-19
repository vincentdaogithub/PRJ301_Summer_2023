<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="main.css" />
        <title>Welcome</title>
    </head>

    <body>
        <div class="bg">
            <img src="img/bg.jpg" />
        </div>

        <main>
            <c:choose>
                <c:when test="${sessionScope.user == null}">
                    <section class="login-container">
                        <h2>Welcome</h2>
                        <p>Enter your details</p>

                        <form action="/Management/c?a=login" method="post">
                            <div class="input">
                                <label for="user-id">User ID</label>
                                <input id="user-id" type="text" name="txtUserID" value="${f:escapeXml(prevUserID)}" placeholder="Your userID" required />
                            </div>

                            <div class="input">
                                <label id="password">Password</label>
                                <input id="password" type="password" name="txtPassword" value="${f:escapeXml(prevPassword)}" placeholder="Your password" required />
                            </div>

                            <c:if test="${failedLogin}">
                                <p class="error">Invalid userID or password</p>
                            </c:if>

                            <input class="submit" type="submit" value="Submit" />
                        </form>

                        <p class="sign-up">New user? <a href="/Management?p=sign-up">Click here</a></p>
                    </section>
                </c:when>

                <c:otherwise>
                    <h1>Already signed in</h1>
                </c:otherwise>
            </c:choose>
        </main>
    </body>
</html>

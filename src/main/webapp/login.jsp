<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registration Page</title>
</head>
<body>
    <h3>Init time: ${applicationScope.servletTimeInit}</h3>


    <form action="${pageContext.request.contextPath}/login" method="post">
        <label for="login">Login</label><br/>
        <input id="login" type="text" name="login" size="30"><br/><br/>

        <label for="password">Password</label><br/>
        <input id="password" type="password" name="password" size="30"><br/><br/>

        <input type="submit" value="OK">
    </form>
</body>
</html>

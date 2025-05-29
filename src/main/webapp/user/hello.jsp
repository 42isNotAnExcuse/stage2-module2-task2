<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>

<head>
    <title>Registration Page</title>
</head>

<body>
<p> Welcome you to the user page </p>

<form action="${pageContext.request.contextPath}/logout" method="post">
    <button type="submit">Logout</button>
</form>

</body>

</html>
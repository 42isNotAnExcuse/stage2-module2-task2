<%@ page contentType="text/html" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="language" value="en" scope="session" />

<%-- Redirect to login page if user not logged in --%>
<c:choose>
    <c:when test="${empty sessionScope.user}">
        <jsp:forward page="login.jsp"/>
    </c:when>
    <c:otherwise>
        <jsp:forward page="user/hello.jsp"/>
    </c:otherwise>
</c:choose>

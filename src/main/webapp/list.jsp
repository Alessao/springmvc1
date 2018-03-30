<%--
  Created by IntelliJ IDEA.
  User: Aoko
  Date: 2018/3/21
  Time: 9:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
>
<html>
<head>
    <%@include file="commons/commons.jsp"%>
    <title>Title</title>
</head>
<body>
<ul>
    <c:forEach items="${users}" var="user">
        <li><a href="test/users/${user.userId}">${user.username}</a></li>
    </c:forEach>
</ul>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Aoko
  Date: 2018/3/19
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <%@include file="commons/commons.jsp"%>
    <title>登录</title>
</head>
<body>
    <h2>用户登录</h2>
    <form method="post" action="<%=request.getContextPath()%>/user/login">
        <p>用户名：<input name="username"></p>
        <p>密码：<input type="password" name="userPwd"></p>
        <p><input type="submit" value="登录"></p>
        <p style="color: red">${msg}</p>
    </form>
</body>
</html>

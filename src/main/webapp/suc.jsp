<%--
  Created by IntelliJ IDEA.
  User: Aoko
  Date: 2018/3/20
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="commons/commons.jsp"%>

    <title>成功</title>
</head>
<body>
    <img src="images/${fileName }">
    <a href="download?fileName=${fileName}">点击下载</a>
</body>
</html>

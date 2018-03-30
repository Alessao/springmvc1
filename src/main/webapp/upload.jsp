<%--
  Created by IntelliJ IDEA.
  User: Aoko
  Date: 2018/3/22
  Time: 9:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="commons/commons.jsp"%>
    <title>Title</title>
</head>
<body>
    <form action="upload" method="post" enctype="multipart/form-data">
        <p><input type="file" name="myPic"></p>
        <p><input type="submit" value="上传"></p>
    </form>

</body>
</html>

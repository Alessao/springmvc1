<%@page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<html>
<body>
<h2>登录成功！${loginer.userId}:${loginer.username}</h2>

<form method="post" action="<%=request.getContextPath()%>/user/changePwd">
    <input type="hidden" name="userId" value="${loginer.userId}">
    <p>新密码：<input type="password" required name="userPwd"></p>
    <p><input type="submit" value="保存"></p>
</form>
</body>
</html>

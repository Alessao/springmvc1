<%--
  Created by IntelliJ IDEA.
  User: Aoko
  Date: 2018/3/20
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="commons/commons.jsp"%>
    <title>Title</title>
    <script src="js/jquery-3.2.1.js"></script>
</head>
<body>
    <p>用&nbsp;户&nbsp;名：<input id="username"></p>
    <span id="msg"></span>
    <p>密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" id="userpwd"></p>
    <p>确认密码：<input type="password" id="cpwd"><span id="cpwdmsg"></span></p>
    <p>性&nbsp;&nbsp;&nbsp;&nbsp;别：<input type="radio" name="sex" id="usersex1" value="男" checked>男
             <input type="radio" name="sex" id="usersex2" value="女">女
    </p>
    <p>出生日期：<input type="date" id="userBirthday"></p>
    <p>用户邮箱：<input type="text" id="userEmail"></p>
    <p id="regMsg"></p>
    <p><input type="button" id="register" value="注册"></p>
    <script>
        $(function(){
            $("#cpwd").blur(function(){
                var pwd = $("#userpwd").val();
                var cpwd = $("#cpwd").val();
                if(pwd != cpwd){
                    alert(1);
                    $("#cpwdmsg").text('两次密码输入不一致');
                }
            });
            $("#cpwd").focus(function(){
               $("#cpwdmsg").text('');
            });
            $("#userpwd").focus(function(){
                $("#cpwdmsg").text('');
            });

            $("#username").blur(function(){
                $.ajax({
                    url:"user/checkName",
                    data:{"username":$("#username").val()},
                    success:function (data) {
                        $("#msg").text(data);
                    }
                })
            });
            $("#register").click(function(){
                $.ajax({
                    url:"user/registerUser",
                    data:{"username":$("#username").val(),"userPwd":$("#userpwd").val(),"userSex":$("input:radio:checked"),"userBirthday":$("#userBirthday").val(),"userEmail":$("#userEmail").val()},
                    success:function(data){
                        if(data){
                            location.href="../suc.jsp";
                        }else{
                            $("#regMsg").text("注册失败，请重试！")
                        }
                    }
                })
            })
        })
    </script>
</body>
</html>

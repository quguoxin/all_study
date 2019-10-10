<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=UTF-8"
         isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <base href="<%= basePath %>"/>
    <title>登录</title>
    <link rel="stylesheet" href="css/commonality.css" />
</head>
<body>
<h2>Hello World!</h2>
<h2>${sayText}</h2>
<form action="hello.action" method="post">
    <input type="text" name="sayText">
    <input type="submit" value="提交">
</form>

<form action="#" method="post" id="loginForm">
    用户名：<input type="text" name="loginBean.username"><br>
    密码：<input type="password"  name="loginBean.password"><br>
    <input type="button" value="登录" id="submitBtn">
    <div id="errorMsg"></div>
</form>

<script src="js/jquery-1.11.1.min.js"></script>
<script>
    $(function () {
        $("#submitBtn").click(function () {
            $.getJSON("login.action",$("#loginForm").serialize(),function (res) {
                if(res.code==200){
                    //跳转
                    location="success.jsp";
                }else {
                    $("#errorMsg").html(res.msg);
                }
            })
        })
    })
</script>
</body>
</html>

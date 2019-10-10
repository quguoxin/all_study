<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/9
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
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
</head>
<body>
<h1 align="center">登录</h1>
<div align="center">
    <form action="login_upload/login.action" method="post">
        用户名：<input type="text" name="username"><br><br>
        密&nbsp;&nbsp;&nbsp;码：<input type="password" name="password"><br>
        <input type="submit">
    </form>

</div>
</body>
</html>
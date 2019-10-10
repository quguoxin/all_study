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
    <title>default page</title>
</head>
<body>
<a href="user/hello.action"><h2>来自新哥的请求，不容拒绝</h2></a><br>

<a href="user/hello2.action?username=quguoxin"><h2>请求参数</h2></a><br>

<a href="user/hello3.action?username=quguoxin"><h2>请求对象</h2></a><br>

<a href="ex/myException.action?i=6"><h2>点我自定义异常测试</h2></a><br><br>

<a href="interceptor/interceptorTest.action"><h2>点我测试拦截器o(*￣︶￣*)o</h2></a>
</body>
</html>
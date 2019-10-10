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
    <title>上传</title>
</head>
<body>
<form enctype="multipart/form-data" action="login_upload/upload.action" method="post">
    <input type="file" name="myfile1"><br>
    <input type="file" name="myfile2"><br>
    <input type="file" name="myfile3"><br>
    <input type="file" name="myfile4"><br>
    <input type="submit" value="上传">
</form>
</body>
</html>
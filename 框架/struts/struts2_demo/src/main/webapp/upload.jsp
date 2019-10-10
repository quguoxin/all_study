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
<form enctype="multipart/form-data" method="post" action="uploadfile.action">
    文件：<input type="file" name="myfile"><br>
    文件描述：<input type="text" name="file_desc"><br>
    <input type="submit" value="上传">
</form>
</body>
</html>
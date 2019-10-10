<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/21
  Time: 16:34
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
    <title>default page</title>
</head>
<body>

<div>
    <form method="post" action="update.s?id2=${goods2.goodno}">
    <table style="background-color: #EFEFEF" border="1px" width="500px" height="200px" align="center">
        <tr>
            <th style="background-color: #7F7F7F; color: white" colspan="2" align="center">修改頁面</th>
        </tr>
        <tr>
            <td align="center">名称</td>
            <td><input type="text" name="goodname" value="${goods2.goodname}"></td>
        </tr>
        <tr>
            <td align="center">价格</td>
            <td><input type="text" name="goodprice" value="${goods2.goodprice}"></td>
        </tr>
        <tr>
            <td align="center">数量</td>
            <td><input type="text" name="goodnum" value="${goods2.goodnum}"></td>
        </tr>
        <tr>

            <td align="center" colspan="2"><input type="submit" name="update" style="width: 60px;background-color: white" value="OK"></td>
        </tr>
    </table>
    </form>
</div>
</body>
</html>
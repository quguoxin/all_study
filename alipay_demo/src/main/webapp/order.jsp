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
    <title>下单</title>
</head>
<body>
<form action="buy.s" method="post">
    订单：<input type="text" name="out_trade_no"><br>
    付款金额：<input type="text" name="total_amount"><br>
    订单标题：<input type="text" name="subject"><br>
    <input type="submit" value="购买">
</form>
</body>
</html>
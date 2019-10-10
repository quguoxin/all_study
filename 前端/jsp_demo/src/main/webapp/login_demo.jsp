<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=UTF-8"
         isELIgnored="false" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URLDecoder" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<%

    //取出cookie信息
    Cookie[] cookie=request.getCookies();//返回值为数组
    String loginName="";
    String loginPwd="";
    String msg="";
    if(cookie!=null) {
       // msg = "";
        //循环取出
        for (Cookie cookie1 : cookie) {
            //取出我们需要的信息
            if (cookie1.getName().equals("loginMsg")) {
                msg = URLDecoder.decode(cookie1.getValue(), "utf-8");
                break;//跳出循环
            }
        }
        String[] massage = msg.split("-");
        //loginName = "";
        //loginPwd = "";
        //判断是否为空
        if (massage.length == 2) {
            loginName = massage[0];
            loginPwd = massage[1];
        }
    }
%>
<form action="dologin.s" method="post">
    <table cellspacing="0" cellpadding="0" border="1px" width="500px" height="180px" align="center">
        <tr>
            <td colspan="2" align="center"><h2>登录</h2></td>
        </tr>
        <tr>
            <td align="right">用户名：</td>
            <td><input type="text" name="username" value="<%=loginName%>"></td>
        </tr>
        <tr>
            <td align="right">密码：</td>
            <td><input type="password" name="password" value="<%=loginPwd%>"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="checkbox" name="timer" value="15">保存15秒</td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="登录">&nbsp;&nbsp;<a href="register.jsp">注册</a></td>
        </tr>
    </table>
</form>
</body>
</html>
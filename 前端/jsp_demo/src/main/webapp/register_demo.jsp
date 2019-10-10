
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
<form action="register.s" method="post">
    <table cellspacing="0" cellpadding="0" border="1px" width="500px" align="center" height="300px">
        <tr>
            <td colspan="2" align="center"><h2>注册</h2></td>
        </tr>
        <tr>
            <td align="right">用户名称：</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td align="right">密码：</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td align="right">确认密码：</td>
            <td><input type="password" name="repassword"></td>
        </tr>
        <tr>
            <td align="right">性别：</td>
            <td><input type="radio" name="sex" value="男">男
                <input type="radio" name="sex" value="女">女
            </td>
        </tr>
        <tr>
            <td align="right">爱好：</td>
            <td>
              <input type="checkbox" name="love" value="篮球">篮球
              <input type="checkbox" name="love" value="排球">排球
              <input type="checkbox" name="love" value="男">男
              <input type="checkbox" name="love" value="女">女
            </td>
        </tr>
        <tr>
            <td align="right">邮箱：</td>
            <td><input type="email" name="email"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="注册">&nbsp;&nbsp;
                <input type="submit" value="返回">&nbsp;&nbsp;
                <a href="login.jsp">登录</a>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
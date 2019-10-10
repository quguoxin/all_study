<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/17
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=UTF-8"
         isELIgnored="false" %>
<%@ page import="com.qgx.www.entity.Userinfo" %>
<%@ page import="com.qgx.www.util.DateUtil" %>
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
    <title></title>
    <style>
        .bg{
            background-color:#F7FAFF;
        }
        .bg2{
            background-color: #FFFAE3;
        }
    </style>
</head>
<body>
<%--<h2>hello,【<%=session.getAttribute("loginUser") %>】</h2>
<%
    List<Userinfo> list= (List<Userinfo>) session.getAttribute("userlist");

%>--%>
<h2>hello,【${loginUser}】</h2>
<a href="loginOut.s">注销</a>
<table width="700px" border="1px" cellpadding="0" cellspacing="0">
    <tr align="center" style="background-color: #7F7F7F;color: white">
        <td>编号</td><td>姓名</td><td>密码</td><td>性别</td><td>爱好</td><td>邮箱</td>
    </tr>
    <c:forEach var="userinfo" items="${userlist}" varStatus="s">
        <c:if test="${s.index%2==0}">
            <tr align="center" class="bg">
                <td>${userinfo.id}</td>
                <td>${userinfo.username}</td>
                <td>${userinfo.password}</td>
                <td>${userinfo.sex}</td>
                <td>${userinfo.love}</td>
                <td>${userinfo.email}</td>
            </tr>
        </c:if>
        <c:if test="${s.index%2!=0}">
            <tr align="center" class="bg2">
                <td>${userinfo.id}</td>
                <td>${userinfo.username}</td>
                <td>${userinfo.password}</td>
                <td>${userinfo.sex}</td>
                <td>${userinfo.love}</td>
                <td>${userinfo.email}</td>
            </tr>
        </c:if>
    </c:forEach>
   <%-- <%
        for(Userinfo userinfo:list){
    %>
    <tr align="center">
        <td><%=userinfo.getId() %></td>
        <td><%=userinfo.getUsername() %></td>
        <td><%=userinfo.getPassword() %></td>
        <td><%=userinfo.getSex() %></td>
        <td><%=userinfo.getLove() %></td>
        <td><%=userinfo.getEmail() %></td>
    </tr>
    <%
        }
    %>--%>
</table>
</body>
</html>
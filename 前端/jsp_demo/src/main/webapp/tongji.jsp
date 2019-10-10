
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=UTF-8"
         isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <base href="<%= basePath %>"/>
    <title>default page</title>
</head>
<body>
<h1>操作日志</h1>
<h2>在线人数：${online_num}</h2>
<c:forEach var="maps" items="${online_user}" varStatus="s">
    ${maps.key}<br>
</c:forEach>
<%--<%
    if(application.getAttribute("tongji")==null){
        return;
    }
    List<Map> list=(List<Map>) application.getAttribute("tongji");
%>--%>
<%--<c:if test="${tongji==null}">return</c:if>--%>
<table border="1"  width="700px">
    <tr align="center">
        <td>登录时间</td>
        <td>登录用户</td>
        <td>次数</td>
        <td>操作类型</td>
    </tr>
    <%--<% for(Map map:list){%>
    <tr align="center">
    <td><%=map.get("loginDate")%></td>
    <td><%=map.get("loginName")%></td>
    <td><%=map.get("loginNumber")%></td>
    <td><%=map.get("doType")%></td>
    </tr>
    <%}%>--%>
    <c:forEach var="map" items="${tongji}" varStatus="s">
        <tr align="center">
            <td><fmt:formatDate value="${map.get('loginDate')}" pattern="yyyy-MM-dd hh:mm:ss"></fmt:formatDate></td>
            <td>${map.get("loginName")}</td>
            <td>${map.get("loginNumber")}</td>
            <td>${map.get("doType")}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=UTF-8"
         isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <base href="<%= basePath %>"/>
    <title>default page</title>
</head>
<body>
&nbsp;&nbsp;&nbsp;&nbsp;
${choice.title}<br><br>
<%--<input type="radio" name="optionType" value="1">单选&nbsp;&nbsp;
<input type="radio" name="optionType" value="2">多选<br><br>--%>
<div>
    <form id="contentall">
    <table id="tables">
        <c:forEach var="map" items="${choice.list}" varStatus="s">
            <tr style="height: 40px">
                <c:if test="${choice.optionType==1}"><td><input value="${map.id}" name="select" type="radio" ></td></c:if>
                <c:if test="${choice.optionType==2}"><td><input value="${map.id}" name="select" type="checkbox" ></td></c:if>
                <%--<td>选项&nbsp;&nbsp;&nbsp;&nbsp;</td>--%>
                <td>${map.content}</td>
            </tr>
        </c:forEach>
    </table>
    </form>
    <a href="vote_success.jsp" id="tijiao">提交</a>
</div>
</body>

<script src="js/jquery-1.11.1.min.js"></script>
<script>
    $(function () {
        $("#tijiao").click(function () {
            $.getJSON("votevote.action",$("#contentall").serialize(),function (res) {
            })
        })

    })
</script>
</html>
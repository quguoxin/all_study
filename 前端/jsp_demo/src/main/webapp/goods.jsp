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
    <title>商品列表</title>
</head>
        <a id="shuaxin" href="showAll.s" style="margin-left: 330px;font-size: 20px;">请点击刷新</a>
    <table border="1px" align="center" width="700px">
        <tr style="background-color: #7F7F7F; color: white" align="center">
            <th>编号</th>
            <th>名称</th>
            <th>价格</th>
            <th>数量</th>
            <th>时间</th>
            <th>操作</th>
        </tr>
        <c:forEach var="goods" items="${goodslist}" varStatus="s">
            <c:if test="${s.index%2==0}">
            <tr height="20px" align="center" style="background-color: #F7FAFF">
                <td>${s.index+1}</td>
                <td>${goods.goodname}</td>
                <td>${goods.goodprice}</td>
                <td>${goods.goodnum}</td>
                <td><fmt:formatDate value="${time}" pattern="yyyy-MM-dd hh:mm:ss"></fmt:formatDate></td>
                <td>
                    <a class="update" href="update_front.s?no=${goods.goodno}&name=${goods.goodname}&price=${goods.goodprice}&num=${goods.goodnum}">修改</a><br>
                    <a class="del" href="del.s?no=${goods.goodno}">删除</a>
                </td>
            </tr>
            </c:if>
            <c:if test="${s.index%2==1}">
                <tr height="20px" align="center" style="background-color: #FFFAE3">
                    <td>${s.index+1}</td>
                    <td>${goods.goodname}</td>
                    <td>${goods.goodprice}</td>
                    <td>${goods.goodnum}</td>
                    <td><fmt:formatDate value="${time}" pattern="yyyy-MM-dd hh:mm:ss"></fmt:formatDate></td>
                    <td>
                        <a class="update" href="update_front.s?no=${goods.goodno}&name=${goods.goodname}&price=${goods.goodprice}&num=${goods.goodnum}">修改</a><br>
                        <a class="del" href="del.s?no=${goods.goodno}">删除</a>
                    </td>
                </tr>
            </c:if>
        </c:forEach>
    </table>
</div>

</body>
</html>
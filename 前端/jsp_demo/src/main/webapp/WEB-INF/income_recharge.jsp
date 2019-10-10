
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
    <link rel="stylesheet" href="css/income_recharge.css">
</head>
<body>
<div class="in_recharge">
  <div class="recharge_cz">任意金额充值</div><hr style="color: green">
    <div class="in_recharge_top">
        <div class="recharge_cz_top">充值：</div>
        <div class="recharge_cz_bot"><input type="text"  class="je" id="money">元</div>
        <%--<div class="recharge_ljcz_bg">--%><input type="button" style="background-color: green" value="立即充值" class="recharge_ljcz" id="recharge"><%--</div>--%>
    </div>
</div>

</body>
<script src="js/jquery-1.11.1.min.js"></script>

<script>
$(function () {
    $("#recharge").click(function () {
        var money=$("#money").val();
        $.getJSON("recharge.s",{"money":money},function (res) {
            if(res.code==200){//请求成功
                window.location="toview.s?vn=income_statement";
            }
        })
    })
})
</script>

</html>

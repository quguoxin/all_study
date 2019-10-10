<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/19
  Time: 21:09
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
    <link href="css/income_statement.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<div class="balance">
    <div class="son1">
        <div class="myBalance">帐户余额</div>
        <hr width="100%" color="#008743" size="1"/>
    </div>
    <div class="viewBalance">
        <div class="viewBalance1">
            当前可用余额：<span color="#E7380F" id="cur_Balance"></span>
        </div>
        <div class="recharge"><a href="toview.s?vn=recharge" target="myOrder" class="recharge_a" >充值</a></div>

    </div>
    <div class="son3">
        <div class="detail">收支明细</div>
        <hr width="100%" color="#EAEAEA" size="1"/>
        <div class="record">
            <select>
                <option>近一个月记录</option>
                <option>三个月内记录</option>
                <option>全部记录</option>
            </select>
        </div>
    </div>
    <div class="table">
        <div class="float">日期</div>
        <div class="float1">流水号/储值卡号</div>
        <div class="float">存入</div>
        <div class="float">支出</div>
        <div class="float">帐户余额</div>
        <div class="float">详情</div>
    </div>
    <div class="noRrecord" >
        <div id="incomeStatementlist">

        </div>

    </div>

</div>
<script src="js/jquery-1.11.1.min.js"></script>
<script>
    $(function () {
        getIncomeStatement();

        $("#cur_Balance").html();
        function getIncomeStatement() {
            $.getJSON("getIncomeStatement.s", "", function (res) {
                if (res.code == 200) {
                    var list = res.data;
                    var tmp = '';
                    var total=0;
                    for (var i = 0; i < list.length; i++) {
                        var obj = list[i];
                        tmp += '<table width="930px" >';
                        tmp += '<tr>';
                        tmp += '<td width="150px">' + obj.create_date + '</td>';
                        tmp += '<td width="150px">' + obj.cardNo + '</td>';
                        tmp += '<td width="120px">' + obj.income + '</td>';
                        tmp += '<td width="120px">' + obj.expend + '</td>';
                        tmp += '<td width="120px">' + obj.balance + '</td>';
                        tmp += '<td width="120px">' + obj.detail + '</td>';
                        tmp += '</tr>';
                        tmp += '</table>';
                        if(i==list.length-1){
                            total=obj.balance;
                        }
                    }
                    $("#incomeStatementlist").html(tmp);
                    $("#cur_Balance").html("￥"+total);
                }
            })
        }

    });

</script>
</body>
</html>


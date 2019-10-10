<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/19
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=UTF-8"
         isELIgnored="false" %>

<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <link href="css/accountBalance.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<div class="balance">
    <div class="son1">
        <div class="myBalance">帐户余额</div>
        <hr width="100%" color="#008743"size="1"/>
    </div>
    <div class="viewBalance">
        <div class="viewBalance1">
            当前可用余额<span color="#E7380F">￥0.00</span>
        </div>
        <div class="recharge">充值</div>

    </div>
    <div class="son3">
        <div class="detail">收支明细</div>
        <hr width="100%" color="#EAEAEA"size="1"/>
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
    <div class="noRrecord">记录为空</div>
</div>
</body>
</html>
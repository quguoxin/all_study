<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/19
  Time: 19:05
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
    <title>公共</title>
    <link rel="stylesheet" href="css/commonality.css" />
</head>
<body>
<div class="acc_all">

    <div class="acc_top">
        <%@include file="after_top.jsp"%>
    </div>


    <div class="acc_mid">
        <div class="mid_all">

            <div class="mid_a">
                <dl style="clear: both;">
                    <dd id="a_1"><strong>全部商品分类</strong></dd>
                    <dd class="a_2"><strong>新品专区</strong></dd>
                    <dd class="a_2"><strong>优质生活</strong></dd>
                    <dd class="a_2"><strong>银行专区</strong></dd>
                    <dd class="a_2"><strong>菜谱专区</strong></dd>
                </dl>
            </div>

            <p class="mid_c" style="font-size: 13px; line-height: 30px;">首页&nbsp;&nbsp;&gt;&nbsp;&nbsp;我的易果</p>

            <div class="mid_d_e">
                <div class="mid_d">
                    <div id="d_1">
                        <dl>
                            <dd style="font-size: 15px; line-height: 30px;"><strong>交易信息</strong></dd>
                            <dd style="font-size: 13px;line-height: 30px; ">
                                <a href="toview.s?vn=myOrder" target="myOrder" >我的订单</a>
                            </dd>
                            <dd style="font-size: 13px;line-height: 30px;">
                                <a href="toview.s?vn=myDiscountCoupon" target="myOrder">我的优惠券</a>
                            </dd>
                            <dd style="font-size: 13px;line-height: 30px;">
                                <a href="toview.s?vn=youbi" target="myOrder" >我的悠币</a>
                            </dd>
                            <dd style="font-size: 13px;line-height: 30px;">我的礼品卡</dd>
                            <dd style="font-size: 13px;line-height: 30px;">我的礼品兑换券</dd>
                            <dd style="font-size: 13px;line-height: 30px;">
                                <a href="toview.s?vn=historyBuy" target="myOrder" >购买过得商品</a>
                            </dd>
                            <dd style="font-size: 13px;line-height: 30px;">
                                <a href="toview.s?vn=myCollects" target="myOrder" >我的收藏</a>
                            </dd>
                            <dd style="font-size: 13px;line-height: 30px;">评论商品</dd>
                        </dl>
                        <dl>
                            <dd style="font-size: 15px; line-height: 30px;"><strong>账户信息</strong></dd>
                            <dd style="font-size: 13px;line-height: 30px;">
                                <a href="toview.s?vn=income_statement" target="myOrder">账户余额</a>
                            </dd>
                            <dd style="font-size: 13px;line-height: 30px;">
                                <a href="toview.s?vn=personalData" target="myOrder">个人资料</a>
                            </dd>
                            <dd style="font-size: 13px;line-height: 30px;">账号安全</dd>
                            <dd style="font-size: 13px;line-height: 30px;">
                                <a href="toview.s?vn=takegood" target="myOrder" >收货地址管理</a>
                            </dd>
                            <dd style="font-size: 13px;line-height: 30px;">企业福利入口</dd>
                        </dl>
                        <dl>
                            <dd style="font-size: 15px; line-height: 30px;"><strong>售后服务</strong></dd>
                            <dd style="font-size: 13px;line-height: 30px;">在线退换货</dd>
                            <dd style="font-size: 13px;line-height: 30px;">投诉建议</dd>
                        </dl>
                    </div>
                </div>
                <div class="mid_e">
                    <iframe name="myOrder" src="toview.s?vn=myOrder" width="100%" height="800px" frameborder="0" framespacing="0" scrolling="no"></iframe>
                </div>
            </div>

        </div>
    </div>


    <div class="acc_bottom">
        <%--<iframe src="front_bottom.html" width="100%" height="469px" frameborder="0" framespacing="0" scrolling="no"></iframe>--%>
        <%@include file="front_bottom.jsp"%>
    </div>
</div>
</body>
</html>
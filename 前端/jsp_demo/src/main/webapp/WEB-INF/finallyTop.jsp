
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=UTF-8"
         isELIgnored="false" %>

<!doctype html>
<html>
<head>
    <meta charset="utf-8">

    <title>最后头部</title>
    <link rel="stylesheet" href="css/finallyTop.css" />
</head>
<body>
<form method="post" action="#">
    <div class="producttop">
        <div class="top">
            <div class="left">
                <dl >
                    <dd>
                        欢迎光临易果生鲜！
                    </dd>
                </dl>
            </div>
            <div class="right">
                <dl >
                    <dd>
                        <img src="imgs/products/zhongren.png">
                        礼品兑换券入口
                    </dd>
                    <dd>
                        <img src="imgs/products/juan.png" />
                        储值卡
                    </dd>
                    <dd>
                        <img src="imgs/products/erweim.png" />
                        手机易果
                    </dd>
                    <dd >
                        <img src="imgs/products/to.png">
                        我的易果
                    </dd>
                    <dd>[<a href="loginOut.s" target="_blank" style="text-decoration:none ">退出</a>]</dd>
                    <dd>你好！<a href="toview.s?vn=main"  style="text-decoration:none ">${loginUser}</a></dd>
                </dl>
            </div>
        </div>
        <div class="productbottom">
            <div class="a">
                <img src="imgs/login/Image 001.png">
            </div>
            <div class="b">
                <dl class="b_1">
                    <dd>我的购物车</dd>
                    <dd><div id="b_1_1"></div></dd>
                </dl>
                <dl id="b_2">

                </dl>
                <dl class="b_1">
                    <dd>确认订单信息</dd>
                    <dd><div id="b_1_3"></div></dd>
                </dl>
                <dl id="b_3">

                </dl>
                <dl class="b_1">
                    <dd>成功提交订单</dd>
                    <dd><div id="b_1_5"></div></dd>
                </dl>

            </div>
        </div>
    </div>
</form>
</body>
</html>
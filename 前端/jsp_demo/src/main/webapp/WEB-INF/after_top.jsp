<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/19
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=UTF-8"
         isELIgnored="false" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>after_top</title>
    <link rel="stylesheet" href="css/after_top.css" />
</head>
<body>
<form method="post" action="#">
    <div class="producttop">
        <div class="top" >
            <div class="left" >
                <dl >
                    <dd  >
                        欢迎光临易果生鲜！&nbsp;&nbsp;&nbsp;<font color="#008743">配送至：
                        <span id="shengzheng"
                              onmouseover='javascript:document.getElementById("adress").style.display="block";'
                              onmouseout='javascript:document.getElementById("adress").style.display="none";'
                        >深圳市
								<div id="adress">
						    	  <img src="imgs/address.png" />
						        </div>
							</span>

                    </font>
                    </dd>
                </dl>
            </div>
            <div class="right" style="width: 652px;height: 28px" >
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
                    <dd class="myYiguo3">
                        <div class="myYiguo1" style="width: 95px; text-indent: 10px;"><img src="imgs/products/to.png">我的易果</div>
                        <div class="myYiguo2">
                            <dl>
                                <dt>我的订单</dt>
                                <dt>我的优惠券</dt>
                                <dt>我的收藏</dt>
                                <dt>我的悠币</dt>
                                <dt>我的退换货</dt>
                                <dt>预存款查询</dt>
                                <dt>立即充值</dt>
                            </dl>
                        </div>
                    </dd>

                    <dd>[<a href="loginOut.s" target="_blank" style="text-decoration:none ">退出</a>]</dd>
                    <dd>你好！<a href="toview.s?vn=main"  style="text-decoration:none ">${loginUser}</a></dd>
                </dl>
            </div>
        </div>


        <div class="productbottom" style="clear: both;">
            <div class="a" >
                <a href="toview.s?vn=productList"><img  src="imgs/login/Image 001.png"></a>
            </div>
            <div class="b">
                <div>
                    <input type="text" name="xxx" placeholder="输入产品名/编号/拼音" style="border: 1px #008743 solid; background-color:  #DFDFDF; color: #008743; width: 447px;height: 28px;">
                    <input type="submit" value="搜索" style="background-color: #008743;width: 82px;height: 32px;margin-left: -6px;color: white;">
                </div>
                <div class="b1">
                    <dl >
                        <dd>奇异果</dd>
                        <dd><font color="green">澳大利亚脐橙</font></dd>
                        <dd>西瓜</dd>
                        <dd><font color="green">蓝莓</font></dd>
                        <dd>黑猪肉</dd>
                        <dd><font color="green">鳕鱼</font></dd>
                        <dd>贝类</dd>
                        <dd> 三文鱼</dd>
                    </dl>
                </div>
            </div>
            <a href="toview.s?vn=gouwuche">
            <div class="c"  >
                <img style="margin-left: 20px;float: left" id="img1" src="imgs/products/car_none.png">
                <span id="totalNum" style="margin: 0px -125px;"></span>
                <span id="totalPrice" style="color: red;float: left;margin-top: 5px;margin-left: -40px;font-size: 23px"></span>
            </div>
            </a>
        </div>
    </div>
</form>

<script type="text/javascript" src="js/jquery-1.11.1.min.js" ></script>
<script>
    var totalPrice=0.00;
    var totalNum=0;
    $(function(){
        getShopDatas();
        $(".myYiguo3").bind({
            mouseover:function(){
                $(".myYiguo1").css("background-color","white").css("color","green");
                $(".myYiguo2").css("display","block")
            },
            mouseout:function(){
                $(".myYiguo1").css("background-color","").css("color","");;
                $(".myYiguo2").css("display","none")
            }
        })
    })

    function getShopDatas() {
        $.getJSON("getShopData.s","",function (res) {

            if(res.code==200){
                totalPrice=res.data.totalPrice;
                totalNum=res.data.totalNum;
                $("#totalPrice").html("¥"+totalPrice);
                $("#totalNum").html(totalNum);
            }
        })
        
    }


</script>
</body>
</html>
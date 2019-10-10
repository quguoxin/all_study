
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
    <head>
        <meta charset="UTF-8">
        <title>海鲜水产_虾在线购买_海鲜水产网上订购_易果生鲜Yiguo官网</title>
        <link href="css/productList.css" rel="stylesheet" />
        <style>
            .mouseOver{
                background-color:#008842 ;
                color: white;
                width: 180px;
                height: 25px;
                /*position: absolute;
                z-index: 9999;*/
                margin: 0px auto;
            }
        </style>
    </head>

<body>
<form action="#" method="post">
<div style="width: 1349px;overflow: hidden;margin: 0px auto">
    <%@include file="after_top.jsp"%>
   <%-- <iframe src="font_top.jsp" border="0" frameborder="0" framespacing="0" scrolling="no" width="100%" height="110"></iframe>--%>
    <div style="background-color: #F7F8F8;margin-top: -6px;">
        <div style="clear: both;height: 31px;">
            <div class="all">
                <a href="#" style="color: white;">全部商品分类▼</a>
            </div>
            <div style="float: left;">
                <ul style="clear: both;">
                    <li class="new"><a href="#">新品专区</a></li>
                    <li class="new"><a href="#">优质生活</a></li>
                    <li class="new"><a href="#">银行专区</a></li>
                    <li class="new"><a href="#">菜谱专栏</a></li>
                </ul>
            </div>
        </div>
        <div style="margin-left: 75px;"><a href="#"><img src="imgs/products/9288725160895708.jpg"></a></div>
        <div style="margin-left: 75px;">
            <a href="#"><img src="imgs/products/9288691294740375.jpg"></a>
            <a href="#" style="padding-left: 6px;"><img src="imgs/products/9288725160764636.jpg"></a>
            <a href="#" style="padding-left: 6px;"><img src="imgs/products/9288725160928476.jpg"></a>
            <a href="#" style="padding-left: 6px;"><img src="imgs/products/9288698512220526.jpg"></a>
        </div>
        <div id="list">
            <div id="pix_list">
               <a  id="moRen" style="cursor: pointer;" >►所有分类</a>
            </div>
            <div style="float: left;" >
                <ul style="clear: both;">
                    <li class="fish"><a id="yu">鱼</a></li>
                    <li class="fish">|&nbsp;&nbsp;&nbsp;&nbsp;<a id="sanYu" >三文鱼</a></li>
                    <li class="fish">|&nbsp;&nbsp;&nbsp;&nbsp;<a  id="xia">虾</a></li>
                    <li class="fish">|&nbsp;&nbsp;&nbsp;&nbsp;<a  id="xie">蟹</a></li>
                    <li class="fish">|&nbsp;&nbsp;&nbsp;&nbsp;<a  id="bei">贝</a></li>
                    <li class="fish">|&nbsp;&nbsp;&nbsp;&nbsp;<a  id="xian">活鲜</a></li>
                    <li class="fish">|&nbsp;&nbsp;&nbsp;&nbsp;<a  id="ganHuo">海产干货</a></li>
                    <li class="fish">|&nbsp;&nbsp;&nbsp;&nbsp;<a  id="teSe">特色海产</a></li>
                </ul>
            </div>
        </div>
        <div id="list_params">
            <table id="list_table">
                <tr id="t1">
                    <td align="center" ><a   id="moRen1">默认排序</a></td>
                    <td align="center"><a  id="sales" >销量</a></td>
                    <td align="center"><a id="price"  >价格</a></td>
                    <td align="center"><a id="evaluate" >评论</a></td>
                </tr>
            </table>
        </div>
    </div>
    <!--图片展示-->
    <%--<div id="shop_body"> </div>--%>
        <div class="body" id="productBody" style="padding-top: 10px;">
          <%--  <div class="food">
                <dl class="foods">
                    <dt><img src="img/imgs/products/9288715872871294_300.jpg" width="290" height="290"/></dt>
                    <dd class="desc">原膳南美白虾仁（中）250g</dd>
                    <dd class="price">¥32.90</dd>
                    <div style="float: left;">
                        <p class="promote">促</p><p class="more">多份优惠</p>
                    </div>
                </dl>

                <dl class="foods">
                    <dt><img src="img/imgs/products/9288718078977072_300.jpg"  width="290" height="290"/></dt>
                    <dd class="desc">原膳南美白虾仁（小）250g</dd>
                    <dd class="price">¥27.90</dd>
                    <div style="float: left;">
                        <p class="promote">促</p><p class="more">海鲜满128减30</p>
                    </div>
                </dl>

                <dl class="foods">
                    <dt><img src="img/imgs/products/9288719653577819_300.jpg"  width="290" height="290"/></dt>
                    <dd class="desc">原膳加拿大北极甜虾熟冻500g(120+/kg)</dd>
                    <dd class="price">¥41.90</dd>
                </dl>

                <dl class="foods">
                    <dt><img src="img/imgs/products/9288722248541339_300.jpg"  width="290" height="290"/></dt>
                    <dd class="desc">红功夫麻辣味小龙虾700g(17-25只)</dd>
                    <dd class="price">¥49.80</dd>
                    <div style="float: left;">
                        <p class="promote">促</p><p class="more">第2件19.9元</p>
                    </div>
                </dl>
            </div>
            <div class="food">
                <dl class="foods">
                    <dt><img src="img/imgs/products/9288724545119438_300.jpg"  width="290" height="290"/></dt>
                    <dd class="desc">原膳越南草虾仁(黑虎虾)(小)200g</dd>
                    <dd class="price">¥32.90</dd>
                    <div style="float: left;">
                        <p class="promote">促</p><p  class="more">多份优惠</p>
                    </div>
                </dl>

                <dl class="foods">
                    <dt><img src="img/imgs/products/9288717027550105_300.jpg"  width="290" height="290"/></dt>
                    <dd class="desc">原膳深海大虾200g</dd>
                    <dd class="price">¥25.90</dd>
                    <div style="float: left;">
                        <p class="promote">促</p><p  class="more">多份优惠</p>
                    </div>
                </dl>

                <dl class="foods">
                    <dt><img src="img/imgs/products/9288722247885979_300.jpg"  width="290" height="290"></dt>
                    <dd class="desc">红功夫十三香味小龙虾700g(17-25只)</dd>
                    <dd class="price">¥49.80</dd>
                    <p class="promote">促</p><p  class="more">多份优惠</p>
                </dl>

                <dl class="foods">
                    <dt><img src="img/imgs/products/9288722720433320_300.jpg"  width="290" height="290"/></dt>
                    <dd class="desc">洪湖渔家麻辣虾球300g</dd>
                    <dd class="price">¥39.90</dd>
                    <div style="float: left;">
                        <p class="promote">促</p><p  class="more">多份优惠</p>
                    </div>
                </dl>
            </div>--%>
        </div>
        <div style="height: 55px;"></div>
  <%--  <%@include file="font_bottom.jsp"%>--%>
    <iframe style="background-color: #F7F8F8;margin-top: -12px;" src="front_bottom.jsp" frameborder="0" framespacing="0" scrolling="no" width="100%" height="600"></iframe>
</div>
</form>
</body>
<script src="../js/jquery-1.11.1.min.js"></script>
<script>
    var product_type="";
    var orderType="0";
    function getProduct(product_type,orderType) {
        $.getJSON("getProductList.s",{"pageNo":1,"product_type":product_type,"orderType":orderType},function (res) {
            if(res.code==200){
                var list=res.data.data;
                var tmp="";
                for(var i=0;i<list.length;i++){
                    var obj=list[i];
                    tmp+='<div class="food">';
                    tmp+='<dl class="foods">';
                    tmp+='<dt><a href="getProductDetail.s?qgx='+obj.product_code+'" ><img class="mouse" src="'+obj.prodect_img+'" width="290" height="290"/></a></dt>';
                    tmp+='<a href="getProductDetail.s?qgx='+obj.product_code+'" ><div style="height: 25px;width: 200px;text-align: center;border-radius: 5%" class="addShopCar"></div></a>';
                    tmp+='<dd class="desc">'+obj.product_name+'250g</dd>';
                    tmp+='<dd class="price">¥'+obj.price+'</dd>';
                    tmp+='<div style="float: left;">';
                    tmp+='<p class="promote">促</p><p class="more">多份优惠</p></div></dl>';
                    tmp+='</div>';
                }
                $("#productBody").html(tmp);//绑定事件写在页面形成后面，如果是方法可以写在其他地方
                $(".foods").each(function () {
                    $(this).bind({
                        mouseover:function () {
                            $(this).children().eq(1).children().addClass("mouseOver").html("加入购物车").show();
                        },
                        mouseout:function () {
                            $(this).children().eq(1).children().addClass("mouseOver").html("加入购物车").hide();
                        }
                    })
                })
            }
        })
    }
    $(function () {
        getProduct(product_type,orderType);
        $("#yu").click(function () {
            product_type= $(this).text();
            getProduct(product_type,orderType);
        });
        $("#xia").click(function () {
            product_type= $(this).text();
            getProduct(product_type,orderType);
        });
        $("#sanYu").click(function () {
            product_type= $(this).text();
            getProduct(product_type,orderType);
        });
        $("#xie").click(function () {
            product_type= $(this).text();
            getProduct(product_type,orderType);
        });
        $("#bei").click(function () {
            product_type= $(this).text();
            getProduct(product_type,orderType);
        });
        $("#xian").click(function () {
            product_type= $(this).text();
            getProduct(product_type,orderType);
        });
        $("#ganHuo").click(function () {
            product_type= $(this).text();
            getProduct(product_type,orderType);
        });
        $("#teSe").click(function () {
            product_type= $(this).text();
            getProduct(product_type,orderType);
        });
        $("#moRen").click(function () {
            product_type="";
            orderType="0";
            getProduct(product_type,orderType);
        });

        $("#sales").click(function () {
            orderType="1";
            getProduct(product_type,orderType);
        });
        $("#price").click(function () {
            orderType="2";
            getProduct(product_type,orderType);
        });
        $("#evaluate").click(function () {
            orderType="3";
            getProduct(product_type,orderType);
        });
        $("#moRen1").click(function () {
            orderType="0";
            getProduct(product_type,orderType);
        });
    })

</script>
</html>
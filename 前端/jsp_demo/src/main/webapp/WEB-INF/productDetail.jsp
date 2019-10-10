
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
    <title>虾_红功夫麻辣味小龙虾700g_17-25只_0403_xia_虾在线购买_易果生鲜Yiguo官网</title>
    <link rel="stylesheet" href="css/productDetail.css">
    <%--<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">--%>
</head>
<body style="width: 1366px">
<div id="total">

    <%--<div style="border: 0px;margin: 0px;height: 110px ;">--%>
        <%@include file="after_top.jsp"%>
    <%--</div>--%>
    <div class="midddddd" style="clear: both;">
    <div class="header-nav" style="margin-top: -6px;">
        <div class="wrap">
            <!--商品分类 开始-->
            <div class="catalogs">
                <div class="catalogs-title btn-green"><a href="#"><i></i>全部商品分类▼</a></div>
            </div>
            <!--商品分类 结束-->
            <div class="nav-items">
                <ul id="homenav">
                    <li><a href="#" target="_blank">新品专区</a></li>
                    <li><a href="#" target="_blank">优质生活</a></li>
                    <li><a href="#" target="_blank">银行专区</a></li>
                    <li><a href="#" target="_blank">菜谱专栏</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="wrap">
        <div class="crumbs">
            <a href="#">首页</a> >
            <a href="#">海鲜水产</a> >
            <a href="#">虾</a> >
            ${product.product_name}
        </div>
        <div class="content_clearfix" id="productInfo">
            <div class="product-intro">
                <!--预览图-->
                <div class="pic-preview">
                    <div class="pic-big">
                        <img src="${product.prodect_img}" width="500" height="500"/>
                    </div>
                    <div class="pic-thumb">
                        <div class="picList">
                            <ul style="clear: both;">
                                <li><img width="85" height="85" src="${product.prodect_img}" /></li>
                                <li><img width="85" height="85" src="${product.prodect_img}" /></li>
                                <li><img width="85" height="85" src="${product.prodect_img}"/></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="product-info">
                    <div class="summary-name" style="height: 80px;">
                        <h1>${product.product_name}</h1>
                    </div>
                    <div class="summary-price">
                        <div class="pro-price">
                            <div style="background-color: white;">
                                <span>价格：</span>
                                <span style="color: #ff0000;"><em>¥</em><strong>${product.price}</strong></span>
                            </div>
                        </div>
                        <div class="pro-review">
                            <p>总体满意度</p>
                            <p><b>5.0</b> 分</p>
                            <p><a href="#"><span>(评论数666)</span></a></p>
                        </div>
                    </div>
                    <div class="summary-other" style="font-size: 12px;font-family: arial;margin-top: 20px;height:253px ">
                        <div class="left" style="width: 450px">
                            <div class="pro-promo">
                                <ul>
                                    <li><span class="fl"><em>促</em>第2件19.9</span></li>
                                </ul>
                            </div>
                            <div class="choose" style="margin-bottom: 20px;clear: both;border: 0px solid black;height: 66px;width: 529px;margin-top: 15px;">
                                <div class="one">规格：</div>
                                <div class="two">
                                    <ul>
                                        <li><a >
                                            <span style="background-color: white;">￥${product.price}</span>
                                            <span style="background-color: white;">700g/盒</span>
                                            <div id="abc"></div>
                                        </a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="pro-service">
                                <b>16:00</b> 前完成订单 预计明日<b>(7月04日)</b>送达
                            </div>
                            <div class="pro-service">不支持7天无理由退货</div>
                            <div class="pro-amount">
                                <div class="three" style="float: left;line-height: 43px;width: 40px;padding: 0 10px;">数量：</div>
                                <div class="four" style="float: left;">
                                    <div class="spinner" maxlength="2">
                                        <button class="decrease">-</button>
                                        <input type="text" value="1" class="spinner" id="p_number" maxlength="3">
                                        <button class="increase">+</button>
                                    </div>
                                    <div class="addcart">
                                        <a class="btn-gn" href="JavaScript:addByCar()"><img src="imgs/product_detail/put_basket_button.png"></a>
                                    </div>
                                </div>
                                <div id="maxNum" style="font-size: 18px;text-align: center;color: red;"></div>
                            </div>
                        </div>
                        <div class="right" style="margin-right: 0px;margin-top: 40px">
                            <table width="100%" cellspacing="0" cellpadding="0" border="0" class="zx">
                                <tr><th align="left" height="25px">原产地：</th><td>湖北荆州</td></tr>
                                <tr><th align="left" height="25px">商品编号：</th><td>${product.product_code}</td></tr>
                                <tr><th align="left" height="25px">品牌：</th><td>红功夫</td></tr>
                                <tr><th align="left" height="25px">发货地：</th><td>广州</td></tr>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="content_clearfix_two" style="height: 12650px;clear: both;">
            <!--左侧-->
            <div class="left-con" style="width: 255px;float: left;">
                <div class="box"
                     style="border: 1px solid #cde4c0;background-color: white;font-family: arial;font-size: 12px;">
                    <div class="like">猜你喜欢</div>
                    <div class="bd">
                        <div class="j_product"
                             style="padding: 10px 10px;clear: both;height: 70px;border-bottom: 1px dashed #cdcdcd;background-color: white;">
                            <div class="one_img"
                                 style="float: left;width: 68px;height: 68px;border: 1px solid #dfdfdf;">
                                <a href="#"><img src="imgs/product_detail/9288722247885979_300.jpg" width="68"
                                                 height="68"></a>
                            </div>
                            <div style="float: left;width: 146px;margin-left: 10px;padding: 4px 0;line-height: 20px;background-color: white;">
                                <a href="#">
                                    <strong style="display: block;height: 40px;margin-bottom: 5px;color: #717171;font-weight: normal;">红功夫十三香味小龙虾700g(17-25只)</strong>
                                    <span>¥49.80</span>
                                </a>
                            </div>
                        </div>
                        <div class="j_product"
                             style="padding: 10px 10px;clear: both;height: 70px;background-color: white;">
                            <div class="one_img"
                                 style="float: left;width: 68px;height: 68px;border: 1px solid #dfdfdf;">
                                <a href="#"><img src="imgs/product_detail/9288722248410267_300.jpg" width="68"
                                                 height="68"></a>
                            </div>
                            <div style="float: left;width: 146px;margin-left: 10px;padding: 4px 0;line-height: 20px;background-color: white;">
                                <a href="#">
                                    <strong style="display: block;height: 40px;margin-bottom: 5px;color: #717171;font-weight: normal;">红功夫麻辣味小龙虾700g(13-17只)</strong>
                                    <span>¥55.80</span>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--右侧-->
            <div class="main-con" style="float: right;border: 0px solid #cdcdcd;width: 930px;">
                <!--当季热卖-->
                <div class="hot" style="height: 280px;">
                    <div class="hd" style="background-color: white;">当季热卖</div>
                    <div class="bdd" style="background-color: white;">
                        <table>
                            <tr>
                                <td align="center" width="175"><img
                                        src="imgs/product_detail/9288723447096504_300.jpg" width="135" height="135">
                                </td>
                                <td align="center" width="175"><img
                                        src="imgs/product_detail/9288724483253453_300.jpg" width="135" height="135">
                                </td>
                                <td align="center" width="175"><img
                                        src="imgs/product_detail/9288721780843665_300.jpg" width="135" height="135">
                                </td>
                                <td align="center" width="175"><img
                                        src="imgs/product_detail/170118150234302_1233566_300.jpg" width="135"
                                        height="135"></td>
                                <td align="center" width="175"><img
                                        src="imgs/product_detail/170508095120808_154370_300.jpg" width="135"
                                        height="135"></td>
                            </tr>
                            <tr>
                                <td colspan="5">
                                    <table>
                                        <td align="center" width="175" height="40"
                                            style="padding-bottom: 14px;color: #777">海南妃子笑荔枝2.5kg
                                        </td>
                                        <td width="20"></td>
                                        <td align="center" width="135" style="color: #777">美威欧式原味三文鱼排（2片装）250g</td>
                                        <td width="40"></td>
                                        <td align="center" width="135" style="color: #777">新西兰Jazz爵士苹果6个150g以上/个</td>
                                        <td width="40"></td>
                                        <td align="center" width="135" style="color: #777">澳洲谷饲小公牛雪花牛肉粒250g</td>
                                        <td width="20"></td>
                                        <td align="center" width="175" style="padding-bottom: 14px;color: #777">
                                            崇明生态乳鸽300g
                                        </td>
                                    </table>
                                </td>

                            </tr>
                            <tr>
                                <td align="center"><strong>¥86.90</strong>
                                    <del>￥86.90</del>
                                </td>
                                <td align="center"><strong>¥62.90</strong>
                                    <del>￥62.90</del>
                                </td>
                                <td align="center"><strong>¥25.90</strong>
                                    <del>￥25.90</del>
                                </td>
                                <td align="center"><strong>¥58.00</strong>
                                    <del>￥58.00</del>
                                </td>
                                <td align="center"><strong>¥33.90</strong>
                                    <del>￥33.90</del>
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>
                <div class="product-detail" style="border: 1px solid #cdcdcd;background-color: white;">
                    <div class="detail-tab">
                        <ul class="detail-ul">
                            <li class="active">
                                <a href="#">商品详情</a>
                            </li>
                            <li>
                                <a href="#">用户评论<b>688</b></a>
                            </li>
                        </ul>
                    </div>
                    <div class="detail-content" style="background-color: white;">
                        <!--商品详情-->
                        <div class="detail-item details clearfix" id="details" style="background-color: white;">
                            <div id="ProductAttribute">
                                <table class="detail-table">
                                    <tbody>
                                    <tr>
                                        <th>商品状态</th>
                                        <td>冷冻</td>
                                    </tr>
                                    <tr>
                                        <th>QS号</th>
                                        <td>SC11142108300099</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                            <p><img class="lazy" src="imgs/product_detail/513691882087163071_880x836.jpg"></p>
                            <p><img class="lazy" src="imgs/product_detail/513691882087195839_880x837.jpg"></p>
                            <p><img class="lazy" src="imgs/product_detail/513691882087130303_880x835.jpg"></p>
                            <p><img class="lazy" src="imgs/product_detail/513691882087228607_880x836.jpg"></p>
                            <p><img class="lazy" src="imgs/product_detail/513691882087261375_880x837.jpg"></p>
                            <p><img class="lazy" src="imgs/product_detail/513691882087294143_880x837.jpg"></p>
                            <p><img class="lazy" src="imgs/product_detail/513691882087326911_880x835.jpg"></p>
                            <p><img class="lazy" src="imgs/product_detail/513691882087392447_880x836.jpg"></p>
                            <p><img class="lazy" src="imgs/product_detail/513691882087359679_880x837.jpg"></p>
                            <p><img class="lazy" src="imgs/product_detail/513691882087425215_880x837.jpg"></p>
                            <p><img class="lazy" src="imgs/product_detail/513691882087457983_880x835.jpg"></p>
                            <p><img class="lazy" src="imgs/product_detail/513691882087490751_880x837.jpg"></p>
                            <p><img class="lazy" src="imgs/product_detail/513691882087523519_880x836.jpg"></p>
                            <p><img class="lazy" src="imgs/product_detail/513691882087556287_880x837.jpg"></p>
                            <p><img class="lazy" src="imgs/product_detail/513691882087621823_880x835.jpg"></p>
                            <p><img class="lazy " src="imgs/product_detail/513691882087589055_880x837.jpg "></p>
                            <p><br></p>
                            <p><img class="lazy " width="880px" src="imgs/product_detail/513691872596960091_1125x414.jpg "></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
    <div style="width: 1345px;overflow: hidden;margin-left: 75px">
        <iframe src="front_bottom.jsp" frameborder="0" framespacing="0" scrolling="no" width="100%" height="600"></iframe>
    </div>
</div>
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal_del" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel"></h4>
            </div>
            <div class="modal-body">

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>

            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</body>
<!-- jQuery(Bootstrap的所有JavaScript插件都依赖jQuery，所以必须放在前面)-->
<script src="js/jquery-1.11.1.min.js"></script>
<!-- 加载Bootstrap的所有JavaScript插件，可根据需要只加载单个插件-->
<script src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<!--bootstrap-table插件-->
<script src="bootstrap-3.3.7-dist/bootstrap-table/bootstrap-table.js"></script>
<script src="bootstrap-3.3.7-dist/bootstrap-table/bootstrap-table-zh-CN.js"></script>
<script>

    function getQueryString(name){
        var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if(r!=null)return  unescape(r[2]); return null;
    }

    var product_code=getQueryString("qgx");


    //单个加入购物车方法
    function addByCar(){
        var productNum=$("#p_number").val();
        //调用后台加入购物车方法
        $.getJSON("addBuyCar.s",{"obj":product_code,"productNum":productNum},function (res) {
            if(res.code==200){
               /* //弹框显示
                $("#myModalLabel").html("加入购物车");
                $("#myModal_del div.modal-body").html("加入购物车成功！");
                $("#myModal_del").modal('show');*/
                getShopDatas();
            }
        })

    }

    $(function () {

      $(".increase").click(function () {
          var num=$("#p_number").val();
              num++;
              if (num>=999){
                  num=999;
                  $("#maxNum").html("已达单次购买上线").show();
              }
              $(this).prev().prop("value",num);
              $(this).mouseout(function () {
                  $("#maxNum").html("已达单次购买上线").hide();
              })
      });
        $(".decrease").click(function () {
            var num=$("#p_number").val();
                num--;
                if (num<=1){
                    num=1;
                    $("#maxNum").html("购买数量不能为小于1").show();
                }
                $(this).next().prop("value",num);
            $(this).mouseout(function () {
                $("#maxNum").html("购买数量不能为小于1").hide();
            })
        })
    /*    //通过参数名获取请求url中参数值得通用方法
        function getQueryString(name) {
            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
            var r = window.location.search.substr(1).match(reg);
            if (r != null) return unescape(r[2]);
            return null;
        }
        //获取商品编号
        var id = getQueryString("id");
        $.getJSON("getProductDetail.s", {"id": id}, function (res) {
            if (res.code == 200) {
                //单挑商品详情内容设置到页面上特定位置

            }
        })*/
    })
</script>
</html>

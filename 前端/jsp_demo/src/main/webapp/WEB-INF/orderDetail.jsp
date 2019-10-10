<%--
  User: Administrator
  Date: 2018/7/25
  Time: 15:21
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
         contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" +
            request.getServerPort()
            + path + "/";
%>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <base href="<%= basePath %>"/>
    <title>易果生鲜_订单详情</title>
    <link rel="stylesheet" href="css/orderDetail.css">
    <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
</head>
<body>
<div style="width: 1349px;overflow: hidden;">
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

            <div class="mid_b">
                <strong>订单号：82632672&nbsp;&nbsp;&nbsp;状态：<font color="#008644" id="orderState"></font></strong>
            </div>

            <div class="mid_c">
                <div class="c_1"><strong>订单跟踪</strong></div>
                <div id="c_2">
                    <dl>
                        <dd id="c_2_1"></dd>
                        <dd class="c_2_t"><font color="#008644">提交订单</font></dd>
                    </dl>

                    <dl>
                        <dd id="c_2_2"></dd>
                    </dl>

                    <dl>
                        <dd id="c_2_3"></dd>
                        <dd class="c_2_t"><font color="#008644">已取消</font></dd>
                    </dl>

                    <dl>
                        <dd class="c_2_4"></dd>
                    </dl>

                    <dl>
                        <dd id="c_2_5"></dd>
                        <dd class="c_2_t">等待配送</dd>
                    </dl>
                    <dl>
                        <dd class="c_2_4"></dd>
                    </dl>
                    <dl>
                        <dd id="c_2_6"></dd>
                        <dd class="c_2_t">配送中</dd>
                    </dl>
                    <dl>
                        <dd class="c_2_4"></dd>
                    </dl>
                    <dl>
                        <dd id="c_2_7"></dd>
                        <dd class="c_2_t">已完成</dd>
                    </dl>
                </div>
                <table class="c_3">
                    <tr style="background-color: #F0F7F3; ">
                        <td class="c_3_1"><strong>处理时间</strong></td>
                        <td class="c_3_2"><strong>处理信息</strong></td>
                    </tr>
                    <tr>
                        <td class="c_3_1">2018-6-28&nbsp;19:41:01</td>
                        <td class="c_3_2">您的订单已出仓</td>
                    </tr>
                    <tr>
                        <td class="c_3_1">2018-6-28&nbsp;18:39:23</td>
                        <td class="c_3_2">您的订单正在加工分拣</td>
                    </tr>
                    <tr>
                        <td class="c_3_1">2018-6-28&nbsp;17:11:21</td>
                        <td class="c_3_2">您的订单预计1月1日送达您手中</td>
                    </tr>
                    <tr>
                        <td class="c_3_1">2018-6-28&nbsp;16:41:50</td>
                        <td class="c_3_2">您的订单已进入安鲜达订单处理平台</td>
                    </tr>
                    <tr>
                        <td class="c_3_1">2018-6-28&nbsp;15:41:31</td>
                        <td class="c_3_2">您的订单已通过审核</td>
                    </tr>
                    <tr>
                        <td class="c_3_1">2018-6-28&nbsp;14:11:11</td>
                        <td class="c_3_2">您提交了订单等待客服审核</td>
                    </tr>
                    <tr>
                        <td class="c_3_1"><font color="#008644">查看全部信息</font></td>
                        <td class="c_3_2"></td>
                    </tr>
                    <tr>
                        <td colspan="2"><hr color="#F0F7F3"></td>
                    </tr>
                    <tr>
                        <td class="c_3_1" >发货方式：易果生鲜物流</td>
                        <td class="c_3_2">&nbsp;</td>
                    </tr>
                </table>
            </div>
            <div class="mid_d">
                <div class="c_1"><strong>订单信息</strong></div>
                <div class="d_1" id="getAddress">
                    <%--<dl >
                        <dd class="d_1_1"><strong>收货人信息</strong></dd>
                        <dd class="d_1_1">收货人：第三组</dd>
                        <dd class="d_1_1">地址：深圳拥抱互联java#1216</dd>
                        <dd class="d_1_1">手机号：150****4407</dd>
                    </dl>--%>
                </div>
                <div class="d_1">
                    <dl>
                        <dd class="d_1_1"><strong>配送方式</strong></dd>
                        <dd class="d_1_1">运费：¥10.00</dd>
                        <dd class="d_1_1">送货日期：2018-6-29</dd>
                        <dd class="d_1_1">配送时间：全天09:00-21:00</dd>
                    </dl>
                </div>
                <div id="d_2">
                    <dl>
                        <dd class="d_1_1"><strong>商品清单</strong></dd>
                        <dd id="d_2_1" >
                            <table class="d_2_1_1" id="getProduct">

                                <!--  预留-->
                            </table>
                        </dd>
                    </dl>
                </div>
                <div id="d_3" STYLE="margin-top: 20px">
                    商品总金额：¥<span id="totalPrice1"></span>&nbsp;&nbsp;&nbsp;&nbsp;<br>
                    运费：¥10.00&nbsp;&nbsp;&nbsp;&nbsp;<br>
                    <%--支付宝：¥530.00&nbsp;&nbsp;&nbsp;&nbsp;<br/>--%>
                    <hr style="border: dashed 1px #CFDAC8; width: 16%; margin-left: 905px;" />
                    <font size="5"><strong>应付金额：<font color="#F20100" id="totalPrice2">&nbsp;&nbsp;&nbsp;</font></strong></font>
                </div>
            </div>
        </div>
    </div>
    <div class="acc_bottom">
        <%@include file="front_bottom.jsp"%>
    </div>

</div>

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

    //页面显示方法
    function jiazai() {

        //获取订单详情
        $.getJSON("getOrderDetail.s",{"product_listNo":getQueryString("product_list2")},function (res) {
            if(res.code==200){
                var addresslist=res.data.addressList;
                var productlist=res.data.productList;
                var totalPrice=0;
                var tmp1='';
                var tmp2='';
                for(var i=0;i<addresslist.length;i++){
                    var obj=addresslist[i];
                    tmp1+='<dl><dd class="d_1_1"><strong>收货人信息</strong></dd>';
                    tmp1+='<dd class="d_1_1">收货人：'+obj.name+'</dd>';
                    tmp1+='<dd class="d_1_1">地址：'+obj.detail_address+'6</dd>';
                    tmp1+='<dd class="d_1_1">手机号：'+obj.phone+'</dd></dl>';
                }
                $("#getAddress").html(tmp1);
                tmp2+='<tr bgcolor="#F6F7F7" align="middle" valign="center" style="margin: 0px; padding: 0px;">';
                tmp2+='<td width="150">商品编号</td><td></td><td width="350">商品名称</td>';
                tmp2+='<td width="150">单价</td><td width="150">数量</td>';
                tmp2+='<td width="150">规格</td><td width="150">金额小计</td><td width="150">操作</td></tr>';
                for(var j=0;j<productlist.length;j++){
                    var obj2=productlist[j];
                    tmp2+='<tr align="middle" valign="center"><td>'+obj2.product_code+'</td>';
                    tmp2+='<td><img style="width: 60px;height: 60px;" src="'+obj2.prodect_img+'" ></td>';
                    tmp2+='<td valign="center">'+obj2.product_name+'<font color="#797979"><br>不支持7天无理由退货</font></td>';
                    tmp2+='<td>'+obj2.price+'</td><td>1</td><td>'+obj2.product_type+'</td><td>'+obj2.price+'</td>';
                    totalPrice+=obj2.price;
                    tmp2+='<td><font color="#00823E"><a href="JavaScript:addByCar('+obj2.product_code+');">加入购物车</a></font></td></tr>';
                }
                $("#getProduct").html(tmp2);
                $("#totalPrice1").html(totalPrice);
                $("#totalPrice2").html('¥'+(totalPrice+10));
            }
        })
    }

    //单个加入购物车方法
    function addByCar(obj){
        //调用后台加入购物车方法
        $.getJSON("addBuyCar.s",{"obj":obj},function (res) {
            if(res.code==200){
                //弹框显示
                $("#myModalLabel").html("加入购物车");
                $("#myModal_del div.modal-body").html("加入购物车成功！");
                $("#myModal_del").modal('show');
                getShopDatas();
            }
        })

    }

    $(function () {
        //给订单加状态
        var orderState=getQueryString("orderState2");
        if(orderState==1){
            $("#orderState").html("待支付");
        }else if(orderState==2){
            $("#orderState").html("已支付");
        }else if(orderState==3){
            $("#orderState").html("待发货");
        }else if(orderState==4){
            $("#orderState").html("已发货");
        }else if(orderState==5){
            $("#orderState").html("已收货");
        }else if(orderState==6){
            $("#orderState").html("已取消");
        }
        jiazai();
    })
</script>

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
</html>
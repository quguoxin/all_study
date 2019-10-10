<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/27
  Time: 9:34
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
    <title>易果_购物车</title>
    <link rel="stylesheet" href="css/myShopping.css">
   <%-- <link href="bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">--%>
    <style>
        #niubi{
            border: 1px red solid;
            width: 300px;
            height: 200px;
            z-index: 9999;
            position: absolute;
            top: 100px;
            left: 550px;
            display: none;
        }
    </style>
</head>
<body>
<div id="niubi"></div>
<div style="width: 1349px;overflow: hidden;">
    <div class="acc_top">
        <%@include file="finallyTop.jsp"%>
    </div>
    <%--<iframe src="after_top2.html" frameborder="0" framespacing="0" scrolling="no" width="1366" height="110"></iframe>--%>
    <div class="cart">
        <div class="wrap">
            <h2>
                我的购物车
                <div class="city clearfix">
                    <div class="city-sz"><i></i>配送至：</div>
                    <div class="city-tit" onmouseover="showAddress(1)" onmouseout="showAddress(0)">
                        <a class="city-name" href="#">深圳市</a>
                        <div id="address" ><img src="imgs/address.png"></div>
                    </div>

                </div>
                <a class="on-shopping" href="http://www.yiguo.com">继续购物 &gt; &gt;</a>
            </h2>
            <div class="cart-alert">
                <div class="cart-header">
                    <table class="cart-table" cellspacing="0px">
                        <tbody>
                        <tr>
                            <th class="cart-t-check" width="120px"><label>
                                <input type="checkbox"  class="chkAll" name="selectAll"  checked>
                                全选</label></th>
                            <th class="cart-t-info" width="251px">商品信息</th>
                            <th class="cart-t-ub" style="width:75px;">悠币</th>
                            <th class="cart-t-price" width="100px">单价</th>
                            <th class="cart-t-num" width="110px">购买数量</th>
                            <th class="cart-t-total" width="110px">合计</th>
                            <th class="cart-t-spec" width="110px">规格</th>
                            <th class="cart-t-opera" width="110px">操作</th>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <!--开始-->
                <div id="myshoppinglist"></div>
                <%--<div class="cart-list" id="theInsulationCan">
                    <table class="cart-table">
                        <tbody>
                        <tr>
                            <td class="cart-t-check"><input type="checkbox"  ></td>
                            <td class="cart-t-img"><a href="#"><img src="imgs/myOrder/9288713496666940_300.jpg"></a></td>
                            <td class="cart-t-info" width="250"><a href="#">勤富新奥尔良味鲷鱼片300g</a></td>
                            <td class="cart-t-ub" style="width:75px;"></td>
                            <td class="cart-t-price" width="100px">￥19.90</td>
                            <td class="cart-t-num" width="110px">
                                <div class="quantity-form">
                                    <input  type="text" class="itxt" oldnum="1" value="1">
                                </div>
                            </td>
                            <td class="cart-t-total" width="110px">￥<span>19.90</span></td>
                            <td class="cart-t-spec" width="110px">300g/袋</td>
                            <td class="cart-t-opera" width="110px">
                                <a href="#">移入收藏</a>
                                <br>
                                <a href="#" >删除</a>
                            </td>
                        </tr>

                        </tbody>
                    </table>
                    <table class="cart-table">
                        <tbody>
                        <tr>
                            <td class="cart-t-check"><input type="checkbox" checked="checked" ></td>
                            <td class="cart-t-img"><a href="#"><img src="imgs/myOrder/170508095120808_154370_300.jpg"></a></td>
                            <td class="cart-t-info"  width="250"><a href="#">崇明生态乳鸽300g</a></td>
                            <td class="cart-t-ub" style="width:75px;"></td>
                            <td class="cart-t-price" width="100px">￥33.90</td>
                            <td class="cart-t-num" width="110px">
                                <div class="quantity-form">
                                    <input  type="text" class="itxt" oldnum="1" value="1" >
                                </div>
                            </td>
                            <td class="cart-t-total" width="110px">￥<span>33.90</span></td>
                            <td class="cart-t-spec" width="110px">300g/袋</td>
                            <td class="cart-t-opera" width="110px">
                                <a href="#;" >移入收藏</a>
                                <br>
                                <a href="#" >删除</a>
                            </td>
                        </tr>

                        </tbody>
                    </table>

                </div>--%>
                <!--结束-->
                <!--选择保温箱-->
                <div class="cart-slct-box">
                </div>
                <div class="settle-space"></div>
                <div class="cart-footer clearfix settle">
                    <div class="wrap">
                        <div class="fl">
                            <label><input type="checkbox"class="chkAll" id="checkAll" name="selectAll" checked>全选</label>
                            <a href="javascript:delSelect(ids)" id="removeSelect" >删除选中的商品</a>

                        </div>
                        <div class="fr">

                            <span class="ub">悠币：<em>0</em>个</span>
                            <span class="fs14">总价：<em>￥<span id="totalPrice1"></span></em></span>
                            <input id="SelectedCommIds" name="SelectedCommIds" type="hidden" value="">

                            <a href="#" class="btn" id="btnSubmit" name="btnSubmit" style="cursor:pointer;">去结算</a>

                        </div>
                    </div>
                </div>
            </div>

            <!--特惠换购-->
            <div class="preferential-buy">


                <h3>特惠换购<div style="margin-left: 1050px;margin-top: -38px"><a id="changePage" href="#"><h3>换一批</h3></a></div></h3>
                <div style="display:none;">
                    <span id="currPage">1</span>
                    <span id="totalPage">1</span>
                </div>
                <ul>
                    <li class="product">
                        <div class="p-img"><a href="#"><img src="http://img09.yiguoimg.com/e/items/2017/170816/9288711650190096_300.jpg" width="90" height="90"></a></div>
                        <div class="p-info">
                            <div class="p-name"><a href="#">俏侬鲜花胚250g(9个装) X 1</a></div>
                            <div class="p-price">
                                <span><strong><b>￥</b>9.90</strong>/盒</span>
                                <del>￥13.80</del>
                            </div>
                            <div class="p-hg"><a href="#" >换购</a></div>
                        </div>
                    </li>
                </ul>

            </div>

        </div>
        <div style="height: 20px;"></div>
    </div>
    <div class="acc_bottom">
        <%--<iframe src="front_bottom.html" width="100%" height="469px" frameborder="0" framespacing="0" scrolling="no"></iframe>--%>
        <%@include file="front_bottom.jsp"%>
    </div>
    <%--<iframe style="margin-right: 40px;" src="after_bottom1.html"  frameborder="0" framespacing="0" scrolling="no"  width="100%" height="450"></iframe>--%>
</div>
<script src="js/jquery-1.11.1.min.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<script src="bootstrap-3.3.7-dist/bootstrap-table/bootstrap-table.js"></script>
<script src="bootstrap-3.3.7-dist/bootstrap-table/bootstrap-table-zh-CN.js"></script>

<script>

    var totalPrice1=0.00;
    //
    function getShopDatas1() {
        $.getJSON("getShopData.s","",function (res) {
            if(res.code==200){
                totalPrice1=res.data.totalPrice;
                $("#totalPrice1").html(totalPrice1);
            }
        })
    }

   //加入收藏方法
    //单个加入购物车方法
    function addMyCollects(obj){
        //调用后台加入购物车方法
        $.getJSON("addMyCollects.s",{"obj3":obj},function (res) {
            if(res.code==200){
                //弹框显示
                /*$("#myModalLabel").html("收藏");
                $("#myModal_del div.modal-body").html("加入收藏成功！");
                $("#myModal_del").modal('show');*/
            }
        })

    }

    //删除单个方法
    function del(obj) {
        $.getJSON("delect.s",{"id":obj},function (res) {
            if(res.code==200){
                /*$("#myModal_shopping  .modal-body").html("删除成功");
                $("#myModal_shopping").modal('show');*/
                getList();
            }
        })
    }

    //删除所选
    function delSelect(ids) {
        $.getJSON("shopDel.s",{"ids":ids},function (res) {
            if(res.code==200){
                getList();
            }
     })
    }


    //显示方法
    function getList() {
        $.getJSON("getMyShopping.s",{"pageNo":"1"},function (res) {
            if (res.code==200){
                var list=res.data;
                var tmp='';
                for(var i=0;i<list.length;i++){
                    var obj=list[i];
                    tmp+='<div class="cart-list" id="theInsulationCan">';
                    tmp+='<table class="cart-table"><tbody><tr>';
                    tmp+='<td class="cart-t-check"><input  type="checkbox" value="'+obj.product_code+'" name="checkbox" checked></td>';
                    tmp+=' <td class="cart-t-img"><a href="#"><img src="'+obj.prodect_img+'"></a></td>';
                    tmp+='<td class="cart-t-info" width="250"><a href="#">'+obj.product_name+'</a></td>';
                    tmp+='<td class="cart-t-ub" style="width:75px;"></td>';
                    tmp+=' <td class="cart-t-price" width="100px">￥'+obj.price+'</td>';
                    tmp+='<td class="cart-t-num" width="110px">';
                    tmp+='<div class="quantity-form">';
                    tmp+='<input  type="number" name="number" class="itxt" min="1" value='+obj.buy_num+'  id="'+obj.id+'">';
                    tmp+='<td class="cart-t-total" width="110px">￥<span>'+(obj.price*obj.buy_num)+'</span></td>';
                    tmp+=' <td class="cart-t-spec" width="110px">300g/袋</td>';
                    tmp+='<td class="cart-t-opera" width="110px">';
                    tmp+='<a href="JavaScript:addMyCollects('+obj.product_code+')">移入收藏</a><br>';
                    tmp+='<a href="javascript:del('+obj.id+')">删除</a></td>';
                    tmp+='</tr> </tbody></table>';
                    tmp+='</div>';
                }
                $("#myshoppinglist").html(tmp);
                /*getShopDatas1();*/
                //单击删除事件
                $("#removeSelect").click(function () {
                    var ids = "";
                    var array = new Array();
                    var num = 0;
                    $("input[name='checkbox']:checked").each(function () {
                        array[num]=$(this).val();
                        num++;

                    });
                    for(var i=0;i<array.length;i++){
                        if(i==array.length-1){
                            ids = ids+array[i];
                        }else {
                            ids = ids+array[i]+"-";
                        }
                    }

                    delSelect(ids);
                    /*getShopDatas1();*/
                })

                //改变事件
                $("input[name='number']").change(function () {
                    var buy_num=$(this).val();
                    var id=$(this).prop("id");
                        $.getJSON("change.s",{"id":id,"num":buy_num},function (res) {
                            if(res.code==200){
                                getList();
                            }
                        })
                    /*getShopDatas1();*/
                })


                //初始获取val值
               /* var nums=0;
                $("input[name='checkbox']:checked ").each(function () {

                    nums+=parseFloat($(this).parent().next().next().next().next().next().next().children().html());
                });
                $("#totalPrice1").html(nums.toFixed(2));*/


                //单击获取值
                var nums=0;
                $("input[type='checkbox']").click(function () {
                    nums=0;
                    $("input[name='checkbox']:checked ").each(function () {

                        nums+=parseFloat($(this).parent().next().next().next().next().next().next().children().html());
                    });

                    $("#totalPrice1").html(nums.toFixed(2));
                })
            }
        })

    }

    //加载
    $(function () {
        getList();
        selectAllMember();

    })

    //展示地址
    function showAddress(m) {
        if(m==1){
            document.getElementById("address").style.display="block";
        }else {
            document.getElementById("address").style.display="none";
        }
    }

    //全选反选
   function selectAllMember(){
        $("input[type='checkbox'][name='selectAll']").click(function(){
            var n=$(this).prop("checked")
            $("input[type='checkbox']").prop("checked",n);

        });
    }
</script>

<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal_shopping" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
              <%--  <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>--%>
                <h4 class="modal-title" id="myModalLabel"></h4>
            </div>
            <div class="modal-body">


            </div>
            <%--<div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal"></button>

            </div>--%>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</body>
</html>





















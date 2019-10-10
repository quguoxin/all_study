<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/19
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=UTF-8"
         isELIgnored="false" %>

<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <link href="css/myDiscountCoupon.css" rel="stylesheet" />
    <style>

    </style>
</head>

<body>
<div class="yh_all"  >
    <div class="yh_top"  >我的优惠劵
        <span class="tz"><a href="#" class="a">关于会员礼发放调整的通知</a></span>
    </div>
    <!--top -->
    <div class="yh_middle"  >
        <span class="mi-1"><a href="#" class="mi_a_1">未使用优惠券</a></span>
        <span class="mi-2"><a href="#" class="mi_a_2">已使用优惠券</a></span>
        <span class="mi-3"><a href="#" class="mi_a_2">已过期优惠券</a></span>

    </div>

    <!--middle -->
    <div class="yh_bottom"  >
        <div id="discountCouponList" style="border: 0px red solid;overflow: hidden">
        <%--<div class="tupian">
            <div class="f1">
                <span class="size">30</span>元 <br>满99.00元</div>
            <div class="f2">
                <p><span><span class="color">【优惠券】</span>新人好礼：全网满99减30元券</p>
                <div class="riqi">截止日期：2018/07/09</div>
            </div>
        </div>
        <div class="tupian">
            <div class="f1">
                <span class="size">50</span>元 <br>满188.00元</div>
            <div class="f2">
                <p><span class="color">【优惠券】</span>新人好礼：全网满188减50元券</p>
                <div class="riqi">截止日期：2018/0716</div>
            </div>
        </div>--%>
        </div>
        <div class="d1" style="border: 0px black  solid;width: 400px;margin-left: 550px">
            <input id="nextBtn" type="button" value="上一页" size="2px" />
            <input id="cur_page" type="text" value="1" size="1px" />
            <input id="prvBtn" type="button" value="下一页" size="2px" />&nbsp;&nbsp;&nbsp;&nbsp;
            <span id="totalPage"></span>&nbsp;&nbsp;&nbsp;&nbsp; 到第
            <input id="gotoPage" type="text" value="1" size="1px" />页
            <input id="gotoBtn" type="button" value="确定" />
        </div>
    </div>

    <!--bottom-->
</div>


<script type="text/javascript" src="js/jquery-1.11.1.min.js" ></script>
<script>
    $(function () {
        var totalPage=0;
        var pageNo=1;

        //方法
        function getOrders(no) {
            $.getJSON("getDiscountCoupon.s",{"pageNo":no},function (res) {
                if(res.code==200){
                    //为总页面赋值
                    totalPage=res.data.totalPage;
                    $("#totalPage").html("共"+totalPage+"页");
                    //为当前页赋值
                    pageNo=res.data.pageNo;
                    $("#cur_page").val(pageNo);
                    var tmp="";
                    //处理集合信息，为页面加载订单
                    var list=res.data.data;
                    for(var i=0;i<list.length;i++){
                        var obj=list[i];
                        tmp+='<div class="tupian" ><div class="f1">';
                        tmp+='<span class="size">'+obj.money+'</span>元 <br>满'+obj.limit_money+'元</div>';
                        tmp+='<div class="f2">';
                        tmp+='<p><span><span class="color">【优惠券】</span>'+obj.name+'</p>';
                        tmp+='<div class="riqi">截止日期：'+obj.end_date+'</div></div></div>';
                    }
                    $("#discountCouponList").html(tmp);
                }
            })
        }

        //调用加载
        getOrders(1);

        //点击上一页
        $("#nextBtn").click(function () {
            pageNo--;
            if(pageNo<=1){
                pageNo=1;
            }
            getOrders(pageNo);
        });

        //点击下一页
        $("#prvBtn").click(function () {
            pageNo++;
            if(pageNo>=totalPage){
                pageNo=totalPage;
            }
            getOrders(pageNo);
        });

        //跳转指定页面
        //判断
        $("#gotoPage").blur(function () {
            var num=$(this).val();
            if(num<=1){//先文本框内内容判断
                num=1;
            }else if(num>=totalPage){
                num=totalPage;
            }
            $(this).val(num);//更改过后重新赋值给文本框

        });
        //跳转
        $("#gotoBtn").click(function () {
            getOrders($("#gotoPage").val())
        });
    })
</script>

</body>

</html>
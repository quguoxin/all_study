
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=UTF-8"
         isELIgnored="false" %>
<%--<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>--%>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
   <%-- <base href="<%= basePath %>"/>--%>
    <title></title>
    <link href="css/myOrder.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<div class="father">
    <div class="son1">
        <div class="span">我的订单</div>
        <div class="select1">
            <select id="order_statu">
                <option value="0">全部状态</option>
                <option value="1">等待支付</option>
                <option value="2">已支付</option>
                <option value="3">等待发货</option>
                <option value="4">已发货</option>
                <option value="5">已收货</option>
                <option value="6">已取消</option>
            </select>
        </div>
        <div class="select2">
            <select>
                <option value="0">近一个月的订单</option>
                <option value="1">三个月内订单</option>
                <option value="2">近4年订单</option>
                <option value="3">历史订单</option>
            </select>
        </div>
        <hr width="100%" color="#008743"size="1"/>
    </div>
    <div class="son2">
        <div class="son2A">订单信息</div>
        <div class="son2B">实付金额</div>
        <div class="son2C" >订单状态</div>
        <div class="son2D">操作</div>
    </div>
    <div class="dingDan" >

        <div id="ordersList">
            <!--预留加载-->
        </div>
        <div class="jump">
            <div><input id="gotoBtn" type="button" value="确定" class="ok"/></div>
            <div class="ye">页</div>
            <div><input id="gotoPage" type="number" style="height: 24px;width: 30px" class="pageNum2"/></div>
            <div class="daoDi">到第</div>
            <div id="totalPage" class="pageSum" ></div>
            <div><input type="button" id="prvBtn" value="下一页" class="down"/></div>
            <input type="button" id="cur_page" class="pageNum1" value="1" style="background-color: white" >
            <div><input type="button" id="nextBtn" value="上一页" class="up"/></div>
        </div>

    </div>
</div>

<script src="js/jquery-1.11.1.min.js"></script>
<script>
    $(function () {
        var totalPage=0;
        var pageNo=1;
        var order_statu=0;//默认类型为所有

        //下拉框类型更改事件
        $("#order_statu").change(function () {
            order_statu=$(this).val();
            getOrders(1);
        })

        //显示页面方法
        function getOrders(no) {
            $.getJSON("getOrders.s",{"pageNo":no,"order_statu":order_statu},function (res) {
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
                        tmp+='<div class="dingDanInFo">订单号：'+obj.orders_no+'提交时间：'+obj.create_date+'</div>';
                        tmp+='<div class="ji"></div>';
                        tmp+='<div class="jiKuai"></div>';
                        var num=(obj.product_list.length+1)/2;
                        tmp+='<div class="shuLiang">共计'+num+'件商品</div>';
                        tmp+='<div class="jinE">￥'+obj.total_money+'</div>';
                        if(obj.statu==1){
                            tmp+='<div class="state">待支付</div>';
                        }else if(obj.statu==2){
                            tmp+='<div class="state">已支付</div>';
                        }else if(obj.statu==3){
                            tmp+='<div class="state">待发货</div>';
                        }else if(obj.statu==4){
                            tmp+='<div class="state">已发货</div>';
                        }else if(obj.statu==5){
                            tmp+='<div class="state">已收货</div>';
                        }else if(obj.statu==6){
                            tmp+='<div class="state">已取消</div>';
                        }
                        tmp+='<div class="pay"><a href="#"target="_self">立即支付</a></div>';
                        tmp+='<div class="modify"><a href="#"target="_self">修改支付</a></div>';
                        tmp+='<div class="cancel"><a href="#"target="_self">取消订单</a></div>';
                        //获取订单里的商品编号
                        var product_list1= obj.product_list;
                        var orderState=obj.statu;
                        tmp+='<div class="view"><a target="_blank" href="toview.s?vn=orderDetail&product_list2='+product_list1 +'&orderState2='+orderState+'">查看详情</a></div>';
                    }
                    $("#ordersList").html(tmp);
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

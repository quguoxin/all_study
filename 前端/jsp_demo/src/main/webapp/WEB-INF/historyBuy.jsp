
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=UTF-8"
         isELIgnored="false" %>

<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>购买过得商品</title>
    <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/myOrder.css">
    <link rel="stylesheet" type="text/css" href="css/historyBuy.css">
</head>
<body style="background-color: #F5F6F6">
<div class="dakuai">
    <div class="shoucang">
        <span>购买过的商品</span>
    </div>
    <div class="qxsc">
        <label>
            <input type="checkbox" name="selectAll">全选
        </label>
        <div class="quanxuananniu">
            <input type="button" value="加入购物车" id="addAllBtn" class="qx">
        </div>
    </div>
    <div class="dht">
        <table width="940" >
            <tr style="font-size: 14px">
                <td height="50" style="text-indent: 70px">商品名称</td>
                <td align="center">商品价格</td>
                <td align="center">操作</td>
            </tr>
        </table>
    </div>

    <div>
        <div id="historyProduct">
            <!-- 预留 -->
            <%--<div style="width: 940px;height: 90px;border: 1px #F1F1F1 solid;margin:10px 20px;clear: both">
                <div style="float: left;margin-top: 35px"><input type="checkbox"></div>
                <div style="margin-top: 15px;width: 60px;height: 60px;float: left"><img src="" ></div>
                <div style="margin-top: 15px;width: 600px;height: 60px;float: left"></div>
                <div style="margin-top: 15px;width: 160px;height: 60px;float: left"></div>
                <div style="margin-top: 15px;width: 90px;height: 60px;float: left">
                    <a>加入购物车</a><br><a><br>删除</a>
                </div>
            </div>--%>
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

<!-- jQuery(Bootstrap的所有JavaScript插件都依赖jQuery，所以必须放在前面)-->
<script src="js/jquery-1.11.1.min.js"></script>
<!-- 加载Bootstrap的所有JavaScript插件，可根据需要只加载单个插件-->
<script src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<!--bootstrap-table插件-->
<script src="bootstrap-3.3.7-dist/bootstrap-table/bootstrap-table.js"></script>
<script src="bootstrap-3.3.7-dist/bootstrap-table/bootstrap-table-zh-CN.js"></script>
<script>
    var totalPage=0;
    var pageNo=1;

    //头部数据加载方法
    function getShopDatas() {
        $.getJSON("getShopData.s","",function (res) {
            if(res.code==200){
                totalPrice=res.data.totalPrice;
                totalNum=res.data.totalNum;
                parent.$("#totalPrice").html("¥"+totalPrice);
                parent.$("#totalNum").html(totalNum);
            }
        })
    }

    //展示页面方法
    function getOrders(no) {
        $.getJSON("doHistoryBuy.s",{"pageNo":no},function (res) {
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
                    tmp+='<div style="width: 940px;height: 90px;border: 1px #F1F1F1 solid;margin:10px 20px;clear: both">';
                    tmp+='<div style="float: left;margin-top: 35px"><input value="'+obj.product_code+'" type="checkbox"></div>';
                    tmp+='<div style="margin-top: 15px;width: 60px;height: 60px;float: left"><img width="60px" height="60px"  src="'+obj.prodect_img+'" ></div>';
                    tmp+='<div style="margin-top: 15px;width: 600px;height: 60px;float: left;line-height: 60px">'+obj.product_name+'</div>';
                    tmp+='<div style="margin-top: 15px;width: 160px;height: 60px;float: left;line-height: 60px">¥'+obj.price+'</div>';
                    tmp+='<div style="margin-top: 15px;width: 90px;height: 60px;float: left">';
                    tmp+='<a href="JavaScript:addByCar('+obj.product_code+');">加入购物车</a><br>';
                    tmp+='<a href="JavaScript:del('+obj.product_code+');"><br>删除</a>';
                    tmp+='</div></div>';
                }
                $("#historyProduct").html(tmp);

                //单击全选加入购物车时间
                $("#addAllBtn").click(function () {
                    var valueStr="";
                    $("#historyProduct input:checked").each(function () {
                        valueStr+=$(this).val()+"-";
                    });
                    addSelectByCar(valueStr);
                });
            }
        })
    }

    //单个删除方法
    function del(id) {
        //调用后台删除方法
        $.getJSON("delHistoryBuy.s",{"id":id},function (res) {
            if(res.code==200){
                //弹框显示
                $("#myModalLabel").html("删除");
                $("#myModal_del div.modal-body").html("删除成功！")
                $("#myModal_del").modal('show');
                //重新加载表格
                /*$("#historyProduct").bootstrapTable('refresh');*/
                getShopDatas();
                getOrders(1);
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
    
    //批量加购物车
    function addSelectByCar(obj1) {
        //通过选择复选框选择
        $.getJSON("addSelectBuyCar.s",{"obj1":obj1},function (res) {
            if(res.code==200){
                //弹框显示
                $("#myModalLabel").html("加入购物车");
                $("#myModal_del div.modal-body").html("选择项加入购物车成功！");
                $("#myModal_del").modal('show');
                getShopDatas();
            }
        })
    }

    //加载
    $(function () {
        //调用加载方法
        getOrders(1);

        //上一页
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

        //全选事件
        $("input[type='checkbox'][name='selectAll']").click(function(){
            $("input[type='checkbox']").prop("checked",$(this).prop("checked"));
        })

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
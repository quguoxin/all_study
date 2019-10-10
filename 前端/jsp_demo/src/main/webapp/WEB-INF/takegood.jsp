<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + request.getContextPath() + "/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <base href="<%= basePath %>"/>
    <meta charset="UTF-8">
    <title>收货地址管理</title>

    <style>
        #no3{
            /*border: 1px red solid;*/
            width: 400px;
            height: 30px;
            margin-top: 30px;
            margin-left: 570px;
        }
    </style>

</head>
<div>
<div>

     <div class="div2">收货地址管理<hr color="#008842"></div>
    <a href="toview.s?vn=address" style="background-color: #54A110;color: white">新增收货地址</a>
        您已创建1个收货地址，最多可创建20个
    </div>
    <div style="border:solid;color: gray" id="address_body">

    <%--<div>--%>
        <%--唐龙昌<input type="button" value="默认地址" style="background-color: #54A110;color: white">--%>
    <%--</div>--%>
    <%--<div >--%>
        <%--收货人：<span>唐龙昌</span>--%>
    <%--</div>--%>
    <%--<div >--%>
        <%--所在地区：<span>广东深圳市宝安区</span>--%>
    <%--</div>--%>
    <%--<div >--%>
        <%--地址：<span>盐田一村16号</span>--%>
    <%--</div>--%>
    <%--<div >--%>
        <%--手机：<span>150****0440</span>--%>
    <%--</div>--%>

    </div>


    <div id="no3">
        <%--<div style="margin-left: 295px;margin-bottom: 20px">--%>
        <%--<input type="button" value="编辑" id="change"></input>--%>
        <%--</div>--%>
        <button class="" id="prevBtn">上一页</button>&nbsp;
        <input type="text" value="2" id="cur_page" style="background-color: white;width: 30px">&nbsp;
        <button class="b1" id="nextBtn">下一页</button>&nbsp;&nbsp;
        <span id="total_page"></span>
        到第<input type="number" value="1"  id="gotopage" style="width: 50px">页&nbsp;<button   class="b2" id="gotoBtn">确定</button >

</div>
</div>
</body>
<script src="js/jquery-1.11.1.min.js"></script>
<script>
    $(function () {
        var totalPage = 0;
        var pageNo=1;

     function showorders(pageNo) {
            $.getJSON("takegood.s",{"pageNo": pageNo}, function (res) {

                if(res.code==200){
                    totalPage=res.data.totalPage;
                    $("#total_page").html("共"+totalPage+"页");
                    $("#cur_page").val(pageNo);
                    var list=res.data.data;
                    var tmp="";
                    for(var i=0;i<list.length;i++){
                        var obj=list[i];
                        tmp+=" <div>" + obj.name+"<input type=\"button\" value=\"默认地址\" style=\"background-color: #54A110;color: white\"></div>";
                        tmp+="<div > 收货人：<input type='text' id='takeperson' value="+obj.name+" readonly=\"true\" style=\"border: none\"></input></div>";
                        tmp+=" <div >所在地区：<input type='text' id='address' value="+obj.address+" readonly=\"true\" style=\"border: none\"></input></div>";
                        tmp+="<div >地址：<input size='30px' type='text' id='detail_address' value="+obj.detail_address+" readonly=\"true\" style=\"border: none\"></input></div>";
                        tmp+=" <div >手机：<input type='text' id='phone' value="+obj.phone.substr(0,3)+"****"+obj.phone.substr(7,4)+" readonly=\"true\" style=\"border: none\"></input></div>";
                        tmp+="<div style=\"margin-left: 295px;margin-bottom: 0px\">";
                        tmp+="<input type='button' name='editor' value='编辑' id='change'"+obj.id+"></input>";
                        tmp+="</div>";
                    }
                    $("#address_body").html(tmp);
                }
                $("input[name=editor]").each(function () {
                    $(this).click(function () {


                    if ($(this).val() == "编辑") {
                        $(this).parent().prev().children("input").attr("readonly", false).focus();
                        $(this).parent().prev().prev().children("input").attr("readonly", false).focus();
                        $(this).parent().prev().prev().prev().children("input").attr("readonly", false).focus();
                        $(this).parent().prev().prev().prev().prev().children("input").attr("readonly", false).focus();
                        $(this).val("保存");

                    }
                    else {


                        var name = $(this).parent().prev().prev().prev().prev().children("input").val();
                        var address = $(this).parent().prev().prev().prev().children("input").val();
                        var detail_address =  $(this).parent().prev().prev().children("input").val();
                        var phoneNumber= $(this).parent().prev().children("input").val();

                        $.getJSON("newAddress.s", {
                            "consigneeName": name,
                            "address": address,
                            "detail_address": detail_address,
                            "phoneNumber": phoneNumber

                        }, function (res) {
                            if (res.code == 200) {

                            } else {

                            }


                        })
                        $(this).val("编辑");

                    }
                })
                })
            })
        }

        showorders(1);

        $("#prevBtn").click(function () {
           pageNo--;
            if (pageNo <=1) {
                pageNo = 1;
            }
            showorders(pageNo);
        });

        $("#nextBtn").click(function () {
           pageNo++;
            if (pageNo >=totalPage) {
                pageNo = totalPage;
            }
            showorders(pageNo);
        });

        $("#gotopage").blur(function () {
            var num=$(this).val();
            if(num<=1){
                num=1;
            }else if(num>=totalPage){
                num=totalPage;
            }
            $(this).val(num);
        })

        $("#gotoBtn").click(function () {
            showorders($("#gotopage").val());
        })
    })
</script>
</html>
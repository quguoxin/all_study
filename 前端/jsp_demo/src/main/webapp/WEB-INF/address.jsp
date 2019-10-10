
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=UTF-8"
         isELIgnored="false" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>新地址</title>
    <link rel="stylesheet" href="css/style3.css" type="text/css" />
    <link rel="stylesheet" href="css/address.css" type="text/css" />
</head>
<body>
<form method="post" action="success.html" id="addressForm">
    <div id="all">
        <div id="use"><!--<img src="imgs/new_site.jpg" />-->
            <div id="use_a"></div>使用新地址
            <!--<span id="use_b"></span>-->
        </div>
        <div>
            <table cellpadding="0" cellspacing="0" border="0" style="margin-top: 5px;">
                <tr>
                    <td align="right" class="left">收货人姓名：</td>
                    <td style="padding-left: 5px;" width="540px">
                        <input id="user" type="text" size="34" name="consigneeName">
                        <div id="user_prompt" class="inputs"></div>
                    </td>

                </tr>
                <tr>
                    <td align="right" class="left">手机号码：</td>
                    <td style="padding-left: 5px;">
                        <input id="mobile" type="text" size="34" name="phoneNumber">
                        <div id="mobile_prompt"></div>
                    </td>
                </tr>
                <tr>
                    <td align="right" class="left">收货地址：</td>
                    <td style="padding-left: 5px;">
                        <select name="province" id="province"></select><!-- 省-->
                        <select name="city" id="city" style="margin-left: 10px;"></select><!-- 市-->
                        <select name="area" id="adress" style="margin-left: 10px;"></select><!-- 区-->
                        <div id="adress_prompt"></div><!-- 错误提示-->
                    </td>
                </tr>
                <tr>
                    <td align="right" class="left">详细地址：</td>
                    <td style="padding-left: 5px;">
                        <input id="adressAll" type="text" size="44" name="detail_address">
                        <div id="adressAll_prompt"></div>
                    </td>
                </tr>
                <tr>
                    <td align="right" class="left">固定电话：</td>
                    <td style="padding-left: 5px;"><input type="text" size="34" name="telephone"></td>
                </tr>
                <tr>
                    <td align="right" class="left">邮政编码：</td>
                    <td style="padding-left: 5px;"><input type="text" size="27" name="postalCode"></td>
                </tr>
                <tr style="border: 3px red  solid;">
                    <td></td>
                    <td style="padding-left: 5px;padding-top: 10px;">
                        <input id="home" class="button" type="button" value="家庭地址">
                        <input id="company" class="button"  type="button" value="公司地址" style="margin-left: 10px;">
                        <div id="homeOrCompany_prompt"></div>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td style="padding-left: 5px; padding-top: 10px;"><input id="submitBtn" class="sub" type="button" value="保存"></td>
                </tr>
            </table>
        </div>
    </div>
</form>

<script type="text/javascript" src="js/jquery-1.11.1.min.js" ></script>
<script>
    $(function(){
        /**
         * 省-市-区
         */
        //省
        $.getJSON("getProvinceCityArea.s","",function (res) {
            if(res.code==200){
                var list=res.data;
                var tmp='<option value="-1">-----请选择-----</option>';
                for(var i=0;i<list.length;i++){
                    var obj=list[i];
                    tmp+='<option value="'+obj.area_code+'">'+obj.area_name+'</option>';
                }
                $("#province").html(tmp);
            }
        })
        //市（点击省出现市--即一个改变事件）
        $("#province").change(function () {
            //获取查询的父类的area_code值
            var area_code = $(this).val();
            $.getJSON("getProvinceCityArea.s",{"p":"city","area_code":area_code},function (res) {
                if(res.code==200){
                    var list=res.data;
                    var tmp='<option value="-1">-----请选择-----</option>';
                    for(var i=0;i<list.length;i++){
                        var obj=list[i];
                        tmp+='<option value="'+obj.area_code+'">'+obj.area_name+'</option>';
                    }
                    $("#city").html(tmp);
                }
            })
        })
        //区（点击市出现区--即一个改变事件）
        $("#city").change(function () {
            //获取查询的父类的area_code值
            var area_code = $(this).val();
            $.getJSON("getProvinceCityArea.s",{"p":"area","area_code":area_code},function (res) {
                if(res.code==200){
                    var list=res.data;
                    var tmp='<option value="-1">-----请选择-----</option>';
                    for(var i=0;i<list.length;i++){
                        var obj=list[i];
                        tmp+='<option value="'+obj.area_code+'">'+obj.area_name+'</option>';
                    }
                    $("#adress").html(tmp);
                }
            })
        })

        //提交
        $("#submitBtn").click(function(){
            if(ckUser()&&ckMobile()&&b&&ckAdress()&&ckAdressAll()){
               $.getJSON("newAddress.s",$("#addressForm").serialize(),function (res) {
                        if(res.code==200){//请求成功
                            window.location="toview.s?vn=takegood";

                        }else{
                            // $("#length").html("输入符合要求");
                        }

                })
            }
        });
        //用户名
        $("#user").focus(function(){
            $("#user_prompt").removeClass("onError onCorrect").addClass("onShow").html("请输入收货人姓名！");
        });
        $("#user").blur(function(){
            ckUser();
        });
        function ckUser(){
            var user_regExp=/^[a-zA-Z\u4E00-\u9FA5]{3,15}$/gim;
            var userValue=$("#user").val();
            //非空
            if(userValue==null||userValue==""){
                $("#user_prompt").removeClass("onShow onCorrect").addClass("onError").html("用户名不能为空！");
                return;//代码中断
            }
            //格式
            if(!user_regExp.test($("#user").val())){
                $("#user_prompt").removeClass("onCorrect onShow").addClass("onError").html("格式错误！");
                return;
            }
            //验证通过提示
            $("#user_prompt").removeClass("onShow onError").addClass("onCorrect").html("输入正确！");
            return true;
        }

        //手机
        $("#mobile").focus(function(){
            $("#mobile_prompt").removeClass("onError onCorrect").addClass("onShow").html("请输入手机号！");
        });
        $("#mobile").blur(function(){
            ckMobile();
        });
        function ckMobile(){
            var mobileValue=$("#mobile").val();
            var mobile_regExp=/^1[0-9]{10}$/gim;
            //非空
            if(mobileValue==null||mobileValue==""){
                $("#mobile_prompt").removeClass("onShow onCorrect").addClass("onError").html("手机不能为空！");
                return;//代码中断
            }
            //格式
            //1.长度：11位数字
            if(!mobile_regExp.test(mobileValue)){
                $("#mobile_prompt").removeClass("onShow onCorrect").addClass("onError").html("手机号格式错误！");
                return;
            }
            //验证通过提示
            $("#mobile_prompt").removeClass("onShow onError").addClass("onCorrect").html("输入正确！");
            return true;
        }

        //地址
        $("#adress").focus(function(){
            $("#adress_prompt").removeClass("onError onCorrect").addClass("onShow").html("请选择地区！");
        });
        $("#adress").blur(function(){
            ckAdress();
        });
        function ckAdress(){
            var adressValue=$("#adress").val();
            //非空
            if(adressValue==null||adressValue==""||adressValue==-1){
                $("#adress_prompt").removeClass("onShow onCorrect").addClass("onError").html("地区不能为空！");
                return;//代码中断
            }
            //验证通过提示
            $("#adress_prompt").removeClass("onShow onError").addClass("onCorrect").html("输入正确！");
            return true;
        }

        //详细地址
        $("#adressAll").focus(function(){
            $("#adressAll_prompt").removeClass("onError onCorrect").addClass("onShow").html("请填写详细地址！");
        });
        $("#adressAll").blur(function(){
            ckAdressAll();
        });
        function ckAdressAll(){
            var adressAllValue=$("#adressAll").val();
            //非空
            if(adressAllValue==null||adressAllValue==""){
                $("#adressAll_prompt").removeClass("onShow onCorrect").addClass("onError").html("详细地址不能为空！");
                return;//代码中断
            }
            //验证通过提示
            $("#adressAll_prompt").removeClass("onShow onError").addClass("onCorrect").html("输入正确！");
            return true;
        }

        //地址选择
        var b=false;
        ckA();
        function ckA(){
            $("#homeOrCompany_prompt").removeClass("onShow onCorrect").addClass("onError").html("请选择地址类型！");
            $("#home").click(function(){
                $(this).addClass("border").next().removeClass("border");
                $("#homeOrCompany_prompt").removeClass("onError onCorrect").addClass("onCorrect").html("您已选择了家庭地址！");
                b=true;
            });
            $("#company").click(function(){
                $(this).addClass("border").prev().removeClass("border");
                $("#homeOrCompany_prompt").removeClass("onError onCorrect").addClass("onCorrect").html("您已选择了公司地址！");
                b=true;
            });

        }
    })
</script>
</body>
</html>
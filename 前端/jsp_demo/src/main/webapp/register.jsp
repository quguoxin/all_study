
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
    <title>注册</title>
    <link rel="stylesheet" href="css/register.css" />
    <link rel="stylesheet" href="css/style2.css" />
</head>

<body>
<form  method="post" action="#" id="registerForm">
    <table width="1347" border="0" cellspacing="0" cellpadding="0">
        <tr bgcolor="#DFDFDF">
            <td>
                <iframe class="top" src="front_top.jsp" width="100%" height="72px" frameborder="0" framespacing="0" scrolling="no"></iframe>
            </td>
        </tr>
        <tr>
            <td colspan="3" height="50" bgcolor="#F6F7F7" align="right">
                <font size="2">我已注册，现在就
                    <a href="login.jsp" target="_self">
                        <font color="#EE7511">登录</font>
                    </a>
                </font>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            </td>
        </tr>
        <tr>
            <td colspan="3" bgcolor="#F6F7F7">
                <table class="count" border="0" cellspacing="0" cellpadding="0" width="1200" bgcolor="#FEFEFE">
                    <tr>
                        <td width="560">
                            <table width="560" border="0" cellpadding="0" cellpadding="0" align="center">
                                <tr height="65">
                                    <td width="230" align="right">
                                        <font size="2">图形验证码</font>&nbsp;&nbsp;
                                    </td>
                                    <td width="240">
                                        <input id="yzm" type="text" name="verificationCode2" placeholder="  图形验证码" style="height: 40px;" size="27" />
                                        <div id="yzm_prompt"  class="inputs1"></div>
                                    </td>
                                    <td width="130">
                                        <img id="code_image" src="verificationCode.s">
                                        <a id="changeVerificationCode2" href="javascript:void(0)">换一张</a>
                                    </td>
                                </tr>
                                <tr height="65">
                                    <td width="230" align="right">
                                        <font size="2">手机号</font>&nbsp;&nbsp;
                                    </td>
                                    <td colspan="2">
                                        <input id="mobile" class="phone" name="username" type="text" placeholder="  请输入您的手机号" style="height: 40px;" size="47" />
                                        <div id="mobile_prompt" class="inputs2"></div>
                                    </td>
                                </tr>
                                <tr height="65">
                                    <td align="right">
                                        <font size="2">手机号验证码</font>&nbsp;&nbsp;
                                    </td>
                                    <td width="210">
                                        <input type="text" placeholder="  手机验证码" style="height: 40px;" size="27">
                                    </td>
                                    <td>
                                        <input type="submit" value="  获取验证码" style="height: 42px;width: 120px ;"  >
                                    </td>
                                </tr>
                                <tr height="65">
                                    <td width="230" align="right">
                                        <font size="2">设置密码</font>&nbsp;&nbsp;
                                    </td>
                                    <td colspan="2">
                                        <input id="pwd" class="password1" name="password" type="password" placeholder="  6-20位字母、符号或数字" style="height: 40px;" size="47" />
                                        <div id="pwd_prompt" class="inputs3"></div>
                                    </td>
                                </tr>
                                <tr height="65">
                                    <td width="230" align="right">
                                        <font size="2">确认密码</font>&nbsp;&nbsp;
                                    </td>
                                    <td colspan="2">
                                        <input id="rePwd" class="password2" name="repassword" type="password" placeholder="  再次输入密码" style="height: 40px;" size="47" />
                                        <div id="rePwd_prompt" class="inputs4"></div>
                                    </td>
                                </tr>
                                <tr height="65">
                                    <td width="230" align="right">
                                        <font size="2">邀请码</font>&nbsp;&nbsp;
                                    </td>
                                    <td colspan="2">
                                        <input class="password3" type="text" name="inviteCode" placeholder="  邀请码" style="height: 40px;" size="47" />
                                    </td>
                                </tr>
                                <tr height="65">
                                    <td width="230" align="right">
                                    </td>
                                    <td colspan="2">
                                        <input type="checkbox" value=""> &nbsp;我已阅读并同意《
                                        <a href="#">服务协议</a>》
                                    </td>
                                </tr>
                                <tr height="65">
                                    <td width="230" align="right">
                                    </td>
                                    <td colspan="2">
                                        <input id="submitBtn" type="button" style="background-image:url(imgs/register/reg_button.png) ; width: 300px ;height: 50px;"  />
                                    </td>
                                </tr>
                            </table>
                        </td>
                        <td align="center">
                            <img src="imgs/register/register.png">
                        </td>
                    </tr>
                </table>
            </td>
        </tr>

        <tr>
            <td colspan="3">
                <iframe src="front_bottom.jsp" width="100%" height="469px" frameborder="0" framespacing="0" scrolling="no"></iframe>
            </td>
        </tr>
    </table>
</form>

<script type="text/javascript" src="js/jquery-1.11.1.min.js" ></script>
<script>
    $(function(){

        //手机号码验证是否存在


        //变换验证码
        $("#changeVerificationCode2").click(function () {
            $("#code_image").prop("src","verificationCode.s?id="+Math.random());
        })
        //提交
        $("#submitBtn").click(function(){
            if(ckYzm()&&ckPwd()&&ckRePwd()&&ckMobile()){
                /*$("form").submit();*/
                ////////////////ajax////////////////////////
                $.getJSON("register.s",$("#registerForm").serialize(),function (res) {
                    if(res.code==200){
                        window.location="login.jsp"
                    }else {
                        $("#yzm_prompt").removeClass("onShow onCorrect").addClass("onError").html(res.msg);
                    }
                })
            }
        });
        //验证码
        $("#yzm").focus(function(){
            $("#yzm_prompt").removeClass("onError onCorrect").addClass("onShow").html("请输入验证码！");
        });
        $("#yzm").blur(function(){
            ckYzm();
        });

        function ckYzm(){
            var yzmValue=$("#yzm").val();
            //非空
            if(yzmValue==null||yzmValue==""){
                $("#yzm_prompt").removeClass("onShow onCorrect").addClass("onError").html("验证码不能为空！");
                return;//代码中断
            }
            //验证通过提示
            $("#yzm_prompt").removeClass("onShow onError").addClass("onCorrect").html("输入正确！");
            return true;
        }

        //手机号
        $("#mobile").focus(function(){
            $("#mobile_prompt").removeClass("onError onCorrect").addClass("onShow").html("请输入手机号！");
        });
        $("#mobile").blur(function(){
            ckMobile();
            /*$.ajax(
                {
                    url:"checkPhone.s",//请求地址
                    type:"post",//请求方式
                    data:{"phone":$("#mobile").val()},//发送数据
                    dataType:"json",//服务器响应的数据类型
                    beforeSend:function () {
                        console.log("我在发起异步请求检查手机号是否存在");
                    },
                    success:function (res) {//res就是接收后台异步返回的数据，可以自定义
                        //处理服务器响应的数据。格式{code:200,msg:'消息描述',data:Object}
                        //var obj = JSON.parse(res);
                        if(res.code==200){//请求成功
                            $("#mobile_prompt").removeClass("onShow onError").addClass("onCorrect").html(res.msg);
                        }else {
                            $("#mobile_prompt").removeClass("onShow onCorrect").addClass("onError").html(res.msg);
                        }
                    },
                    error:function () {
                        console.log("你完了，服务器发生错误！");
                    }

                }
            );
            $.getJSON("checkPhone.s",{"phone":$("#mobile").val()},function (res) {
                //处理服务器响应的数据。格式{code:200,msg:'消息描述',data:Object}
                if(res.code==200){//请求成功
                    $("#mobile_prompt").removeClass("onShow onError").addClass("onCorrect").html(res.msg);
                }else {
                    $("#mobile_prompt").removeClass("onShow onCorrect").addClass("onError").html(res.msg);
                }
            })*/

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
            //1.长度：11位数字  以1开头
            if(!mobile_regExp.test(mobileValue)){
                $("#mobile_prompt").removeClass("onShow onCorrect").addClass("onError").html("必须以1开头的11位数字！");
                return;
            }
            $.getJSON("checkPhone.s",{"phone":$("#mobile").val()},function (res) {
                //处理服务器响应的数据。格式{code:200,msg:'消息描述',data:Object}
                if(res.code==200){//请求成功
                    $("#mobile_prompt").removeClass("onShow onError").addClass("onCorrect").html(res.msg);
                }else {
                    $("#mobile_prompt").removeClass("onShow onCorrect").addClass("onError").html(res.msg);
                    return;
                }
            })
            //验证通过提示
            //$("#mobile_prompt").removeClass("onShow onError").addClass("onCorrect").html("输入正确！");
            return true;
        }

        //密码
        $("#pwd").focus(function(){
            $("#pwd_prompt").removeClass("onError onCorrect").addClass("onShow").html("请输入密码！");
        });
        $("#pwd").blur(function(){
            ckPwd();
        });
        function ckPwd(){
            var pwd_regExp=/^[A-Za-z0-9_]{6,20}$/gim;
            var pwdValue=$("#pwd").val();
            //非空
            if(pwdValue==null||pwdValue==""){
                $("#pwd_prompt").removeClass("onShow onCorrect").addClass("onError").html("密码不能为空！");
                return;//代码中断
            }
            //格式
            if(!pwd_regExp.test(pwdValue)){
                $("#pwd_prompt").removeClass("onCorrect onShow").addClass("onError").html("由字母、数字、_组成！");
                return;
            }
            //验证通过提示
            $("#pwd_prompt").removeClass("onShow onError").addClass("onCorrect").html("输入正确！");
            return true;
        }

        //确认密码
        $("#rePwd").focus(function(){
            $("#repwd_prompt").removeClass("onError onCorrect").addClass("onShow").html("请再次输入密码！");
        });
        $("#rePwd").blur(function(){
            ckRePwd();
        });
        function ckRePwd(){
            var rePwdValue=$("#rePwd").val().toLowerCase();
            //非空
            if(rePwdValue==null||rePwdValue==""){
                $("#rePwd_prompt").removeClass("onShow onCorrect").addClass("onError").html("密码不能为空！");
                return;//代码中断
            }
            //格式
            //1.与前面相同
            if($("#rePwd").val()!=$("#pwd").val()){
                $("#rePwd_prompt").removeClass("onShow onCorrect").addClass("onError").html("密码必须相同！");
                return;
            }

            //验证通过提示
            $("#rePwd_prompt").removeClass("onShow onError").addClass("onCorrect").html("输入正确！");
            return true;
        }
    })
</script>
</body>

</html>
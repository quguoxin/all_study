<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=UTF-8"
         isELIgnored="false" %>
<%@ page import="java.net.URLDecoder" %>
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
    <title>登录</title>
    <link rel="stylesheet" href="css/login.css" />
</head>

<body>

<%
    //取出cookie信息
    Cookie[] cookie=request.getCookies();//返回值为数组
    String loginName="";
    String loginPwd="";
    String msg="";
    if(cookie!=null) {
        //循环取出
        for (Cookie cookie1 : cookie) {
            //取出我们需要的信息
            if (cookie1.getName().equals("loginMsg")) {
                msg = URLDecoder.decode(cookie1.getValue(), "utf-8");
                break;//跳出循环
            }
        }
        String[] massage = msg.split("-");
        //判断是否为空
        if (massage.length == 2) {
            loginName = massage[0];
            loginPwd = massage[1];
        }
    }
%>

<form  id="loginForm" method="post" action="#">
    <div class="login">
        <div>
        <iframe src="front_top.jsp" width="100%" height="72px"></iframe>
        </div>
        <table width="1366" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td colspan="3" height="50"></td>
            </tr>
            <tr height="415px">
                <td colspan="3">
                    <table border="0" cellspacing="0" cellpadding="0">
                        <tr>
                            <td width="820" align="center" valign="top"><img src="imgs/login/Image 002.png"></td>
                            <td>
                                <div class="table">
                                    <table width="350" height="440" border="0" cellpadding="0" cellspacing="0">
                                        <tr>
                                            <td width="20"></td>
                                            <td width="187"><font size="4">欢迎登录</font></td>
                                            <td align="left">
                                                <font size="1.5">还没有账号？
                                                    <a href="register.jsp" >
                                                        <font color="green">立即注册</font>
                                                    </a>
                                                </font>
                                            </td>
                                        </tr>
                                        <tr height="29px"><td colspan="3"><div id="tiShi" style="width: 290px;height: 26px;color:red;margin-left: 20px;text-align: right;"></div></td></tr>
                                        <tr>
                                            <td width="20"></td>
                                            <td colspan="2" valign="center">
                                                <input class="user" name="username" type="text" placeholder="邮箱/账号/已验证手机" VALUE="<%=loginName%>" style="height: 40px" size="37px" >
                                            </td>
                                        </tr>
                                        <tr>
                                            <td width="20"></td>
                                            <td colspan="2" valign="center">
                                                <input class="password1" name="password" type="password" placeholder="密码" VALUE="<%=loginPwd%>" style="height: 40px"  size="37px">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td width="20"></td>
                                            <td colspan="2">
                                                <input class="password" name="password1" type="text" placeholder="验证码" style="height: 37px"  width="152px">
                                                <div class="yanzhengma"><img id="code_image" src="verificationCode.s">
                                                    <a id="changeVerificationCode" href="javascript:void(0)">换一张</a>
                                                </div>

                                            </td>
                                        </tr>
                                        <tr>
                                            <td width="20"></td>
                                            <td width="187">
                                                <input type="checkbox" name="timer" value="150000">&nbsp;&nbsp;
                                                <font size="2">保存150000秒</font>
                                            </td>
                                            <td align="left">
                                                <font size="2">忘记登录密码？</font>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td width="20"></td>
                                            <td colspan="2"><input id="btnSumbit" type="button" style="background-image: url('imgs/login/Image 006.png');width: 307px;height: 50px "/></td>
                                        </tr>
                                        <tr>
                                            <td width="20"></td>
                                            <td colspan="2">
                                                <font size="2" color="#868686">第三方登录</font>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td width="20"></td>
                                            <td colspan="2">
                                                <font size="2">
                                                    <img src="imgs/login/Image 007.png"></font>&nbsp&nbsp&nbsp
                                                <img src="imgs/login/Image 008.png"></font>&nbsp&nbsp&nbsp
                                                <img src="imgs/login/Image 009.png"></font>
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
        <div>
        <iframe src="front_bottom.jsp" width="100%" height="469px" frameborder="0" framespacing="0" scrolling="no"></iframe>
        </div>
    </div>
</form>
<script src="js/jquery-1.11.1.min.js"></script>
<script>
    $(function(){
        $("#changeVerificationCode").click(function () {
            $("#code_image").prop("src","verificationCode.s?id="+Math.random());
        })
        $("#btnSumbit").click(function () {
            $.getJSON("dologin.s",$("#loginForm").serialize(),function (res) {
                if(res.code==200){
                    window.location="toview.s?vn=main"
                }else {
                    $("#tiShi").html(res.msg)
                }
            })
        })
    })
</script>
</body>

</html>
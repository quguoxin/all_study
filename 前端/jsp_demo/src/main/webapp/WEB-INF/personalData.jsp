<%--
  User: Administrator
  Date: 2018/7/25
  Time: 14:59
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
    <title></title>
    <link rel="stylesheet" href="css/personalData.css">
</head>
<body>
<form>
    <div id="all">
        <div id="tit"><span>个人资料</span>
            <div id="br"></div>
        </div>
        <div id="content">
            <div id="left" class="float_zl">
                <dl>
                    <dd class="md" id="d0"><span>基本信息</span></dd>
                    <dd>头像</dd>
                    <dd id="d1">真实姓名</dd>
                    <dd>用户名</dd>
                    <dd>手机</dd>
                    <dd id="d2">邮箱</dd>
                    <dd class="md">选填信息</dd>
                    <dd>性别</dd>
                    <dd>生日</dd>
                </dl>
            </div>
            <div id="right" class="float_zl">

                <ul>


                    <li id="l1"><img src="imgs/personalData/Avatar.jpg" height="100" width="100"/></li>
                    <li id="l2"><input type="text" name="username" id="username" placeholder="输入你的真实姓名">
                        &nbsp;&nbsp; <img src="">&nbsp;&nbsp;<span id="length">长度不能超过10个汉字</span></li>
                    <li id="l3"><span id="phonename">${loginUser}</span></li>
                    <li id="l4"><span id="phone">150****4407</span><span id="xg">(修改绑定手机请在易果App上操作)</span>
                    </li>
                    <li id="l5"><img src="imgs/personalData/qrcode_app.jpg" height="120" width="120"/></li>
                    <li id="l6"><a href="#">未验证</a>&nbsp;&nbsp;&nbsp;<input type="button" name="yzyx" value="验证邮箱"
                                                                            id="yx"></li>
                    <li id="l7"><input type="radio" name="sex" value="man" >&nbsp;男&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="radio" name="sex" value="woman">&nbsp;女
                    </li>
                    <li id="l8"><select name="year" class="select" id="year" >
                        <option value="请选择">请选择</option>
                        <option value="1970">1970</option>
                        <option value="1980">1980</option>
                        <option value="1990">1990</option>
                    </select>年
                        <select name="month" class="select" id="month">
                            <option value="请选择">请选择</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                            <option value="7">7</option>
                            <option value="8">8</option>
                            <option value="9">9</option>
                            <option value="10">10</option>
                            <option value="11">11</option>
                            <option value="12">12</option>
                        </select>月
                        <select name="day" class="select" id="day">
                            <option value="请选择">请选择</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                            <option value="7">7</option>
                            <option value="8">8</option>
                            <option value="9">9</option>
                            <option value="10">10</option>
                            <option value="11">11</option>
                            <option value="12">12</option>
                            <option value="13">13</option>
                            <option value="14">14</option>
                            <option value="15">15</option>
                            <option value="16">16</option>
                            <option value="17">17</option>
                            <option value="18">18</option>
                            <option value="19">19</option>
                            <option value="20">20</option>
                            <option value="21">21</option>
                            <option value="22">22</option>
                            <option value="23">23</option>
                            <option value="24">24</option>
                            <option value="25">25</option>
                            <option value="26">26</option>
                            <option value="27">27</option>
                            <option value="28">28</option>
                            <option value="29">29</option>
                            <option value="30">30</option>

                        </select>日
                    </li>
                    <li id="l9"><input type="button" value="确   认" id="tj"></li>

                </ul>

            </div>
        </div>
    </div>
</form>
</body>
<script src="js/jquery-1.11.1.min.js"></script>
<script>
    $(function () {
        $("#username").blur(function () {

           var username= $(this).val();
          Chinasimple(username);
        })
        function Chinasimple(str){
            var strs=str.replace(/(^\s+)|(\s+$)/g, "");
            if (!strs.match(/^[\u4e00-\u9fa5]{1,10}$/)) {
                $("#length").html("输入不符合要求");
             }else {
                $("#length").html("输入符合要求");
            }
        }

        $("#tj").click(function () {
           var sex= $("input[name=sex]:checked").val();
            var username=$("#username").val();
            var phonename=$("#phonename").html();
            var year=$("#year").val();
            var month=$("#month").val();
            var day=$("#day").val();
            $.getJSON("userinfos.s",{"username":username,"phonename":phonename,"sex":sex,"year":year},function (res) {
                if(res.code==200){//请求成功
                    window.location="toview.s?vn=personalData";

                }else{
                    // $("#length").html("输入符合要求");
                }
            })
        })


    })

</script>
</html>
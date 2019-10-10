
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=UTF-8"
         isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <base href="<%= basePath %>"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1">
    <link rel="stylesheet" type="text/css" href="assets/css/bootstrap-clearmin.min.css">
    <link rel="stylesheet" type="text/css" href="assets/css/roboto.css">
    <link rel="stylesheet" type="text/css" href="assets/css/material-design.css">
    <link rel="stylesheet" type="text/css" href="assets/css/small-n-flat.css">
    <link rel="stylesheet" type="text/css" href="assets/css/font-awesome.min.css">
    <title>主页</title>
</head>
<body class="cm-no-transition cm-1-navbar">
<div id="cm-menu">
    <nav class="cm-navbar cm-navbar-primary">
        <div class="cm-flex"><div class="cm-logo"></div></div>
        <div class="btn btn-primary md-menu-white" data-toggle="cm-menu"></div>
    </nav>
    <div id="cm-menu-content">
        <div id="cm-menu-items-wrapper">
            <div id="cm-menu-scroller">
                <ul class="cm-menu-items">
                    <li class="active"><a href="index.html" class="sf-house">Home</a></li>
                    <li><a href="view/toView.action?vn=insurance" target="change" class="sf-dashboard">保单管理</a></li>
                    <li><a href="components-text.html" class="sf-brick">用户管理</a></li>
                    <li class="cm-submenu">
                        <a class="sf-window-layout">菜单管理 <span class="caret"></span></a>
                        <ul>
                            <li><a href="layouts-breadcrumb1.html">1st nav breadcrumb</a></li>
                            <li><a href="layouts-breadcrumb2.html">2nd nav breadcrumb</a></li>
                            <li><a href="layouts-tabs.html">2nd nav tabs</a></li>
                        </ul>
                    </li>
                    <li class="cm-submenu">
                        <a class="sf-cat">访问日志 <span class="caret"></span></a>
                        <ul>
                            <li><a href="ico-sf.html">Small-n-flat</a></li>
                            <li><a href="ico-md.html">Material Design</a></li>
                            <li><a href="ico-fa.html">Font Awesome</a></li>
                        </ul>
                    </li>
                    <li><a href="notepad.html" class="sf-notepad">发送短信</a></li>
                    <li><a href="login.html" class="sf-lock-open">发送日志</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>
<header id="cm-header">
    <nav class="cm-navbar cm-navbar-primary">
        <div class="btn btn-primary md-menu-white hidden-md hidden-lg" data-toggle="cm-menu"></div>
        <div class="cm-flex"><h1>后台/保单管理</h1></div>
    </nav>
</header>
<div id="global">
    <div class="container-fluid">
        <div class="panel panel-default">
            <div class="panel-body">
                <%--<h2 style="margin:0">Hello World !</h2>--%>


                <iframe name="change" src="view/toView.action?vn=insurance" width="100%" height="800px" frameborder="0" framespacing="0" scrolling="no"></iframe>


            </div>
        </div>
    </div>
    <footer class="cm-footer"><span class="pull-right">2018-8888 &copy; ACME 新哥集团.</span></footer>
</div>
<script src="assets/js/lib/jquery-2.1.3.min.js"></script>
<script src="assets/js/jquery.mousewheel.min.js"></script>
<script src="assets/js/jquery.cookie.min.js"></script>
<script src="assets/js/fastclick.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/clearmin.min.js"></script>
</body>
</html>
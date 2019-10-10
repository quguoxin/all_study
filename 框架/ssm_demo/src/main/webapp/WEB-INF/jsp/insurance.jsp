
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
    <meta http-equiv="x-ua-compatible" content="IE=edge">
    <meta name="viewport" content="width-device-width,initial-scale=1">
    <!--上述3个meta标签必须放在最前面，任何其他内容都必须跟随其后！-->
    <title>保险查询</title>

    <!--bootstrap-->
    <link href="bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <!--bootstrap-table css库-->
    <link href="bootstrap-3.3.7-dist/bootstrap-table/bootstrap-table.css" rel="stylesheet">
    <!--HTML5 shim 和 Respond.js是为了让IE8支持HTML5元素和媒体查询功能-->
    <!--警告：通过file://协议（就是这样讲html页面拖拽到浏览器中）访问页面时Respond.js不起作用-->
    <!--[if lt IE 9]-->
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <!--[end if]-->
</head>
<body>
<div>
    <div>
            <form class="form-inline" role="form">
                <div class="form-group">
                    <label  for="userName">被保险人姓名：</label>
                    <input type="text" class="form-control" id="userName"  name="userName" placeholder="请输入被保险人姓名">
                </div>
                <div class="form-group" style="margin-left: 200px">
                    <label  for="papersNo">被保险人证件号：&nbsp;&nbsp;&nbsp;&nbsp;</label>
                    <input type="text" class="form-control" id="papersNo" name="papersNo"  placeholder="请输入名称">
                </div>
                <div class="form-group" style="margin-top: 40px">
                    <label  for="userJobNum">企业员工工号：</label>
                    <input type="text" class="form-control" id="userJobNum" name="userJobNum" placeholder="请输入名称">
                </div>
                <div class="form-group" style="margin-left: 200px;margin-top: 40px">
                    <label>被保险人证件类型：</label>
                    <select class="form-control" name="papersType" id="papersType">
                        <option value="">请选择</option>
                        <option value="身份证">身份证</option>
                        <option value="学生证">学生证</option>
                        <option value="单身狗证">单身狗证</option>
                    </select>
                </div><br>
                <button type="reset" class="btn btn-default" style="margin-left: 300px;background-color: #F0F0F0;margin-top: 40px">重置</button>
                <button type="button" id="searchBtn" class="btn btn-default" style="margin-left: 50px;background-color: #EDD22C;margin-top: 40px">提交</button>
            </form>
    </div>
    <div style="margin-top: 30px"><table id="insuranceListTable"></table></div>
</div>


<!-- jQuery(Bootstrap的所有JavaScript插件都依赖jQuery，所以必须放在前面)-->
<script src="js/jquery-1.11.1.min.js"></script>
<!-- 加载Bootstrap的所有JavaScript插件，可根据需要只加载单个插件-->
<script src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<!--bootstrap-table插件-->
<script src="bootstrap-3.3.7-dist/bootstrap-table/bootstrap-table.js"></script>
<script src="bootstrap-3.3.7-dist/bootstrap-table/bootstrap-table-zh-CN.js"></script>
<script>
    function show() {
        //初始化参数
        var params = {
            url:"insurance/getInsuranceList.action",//请求后台的路径，获取表格数据的url
            cache: false, // 设置为 false 禁用 AJAX 数据缓存， 默认为true
            striped: true,  //表格显示条纹，默认为false，各行变色
            pagination: true, // 在表格底部显示分页组件，默认false
            pageList: [5, 10, 20, 50], // 设置页面可以显示的数据条数
            pageSize: 2, // 页面数据条数
            pageNumber: 1, // 首页页码
            sidePagination: 'server', // 设置为服务器端分页
            // queryParams: function (params) { // 请求服务器数据时发送的参数，可以在这里添加额外的查询参数，返回false则终止请求
            //     return {
            //         limit: params.limit, // 每页要显示的数据条数
            //         offset: params.offset, // 每页显示数据的开始行号
            //         sort: params.sort, // 要排序的字段
            //         sortOrder: params.order, // 排序规则
            //         dataId: $("#dataId").val() // 额外添加的参数
            //     }
            // },
            columns: [
                // {
                //     checkbox: true, // 显示一个勾选框
                //     align: 'center' // 居中显示
                // },
                {
                    field: 'userJobNum', // 返回json数据中的name
                    title: '员工工号', // 表格表头显示文字
                    align: 'center', // 左右居中
                    valign: 'middle' // 上下居中
                }, {
                    field: 'userName',
                    title: '姓名',
                    align: 'center',
                    valign: 'middle'
                },{
                    field: 'papersType',
                    title: '证件类型',
                    align: 'center',
                    valign: 'middle'
                },{
                    field: 'papersNo',
                    title: '证件号码',
                    align: 'center',
                    valign: 'middle'
                }
            ],
            queryParams:function (params) {
                return{
                    limit: params.limit, // 每页要显示的数据条数
                    offset: params.offset, // 每页显示数据的开始行号
                    userName: $("#userName").val() ,
                    userJobNum: $("#userJobNum").val(),
                    papersNo: $("#papersNo").val(),
                    papersType: $("#papersType").val()
                }
            }
        };
        //初始化表格
        $("#insuranceListTable").bootstrapTable(params);
    }
    $(function () {
        show();
        $("#searchBtn").click(function () {
            $("#insuranceListTable").bootstrapTable("refresh",{
                userName: $("#userName").val() ,
                userJobNum: $("#userJobNum").val(),
                papersNo: $("#papersNo").val(),
                papersType: $("#papersType").val()
            })
        })
    })


</script>
</body>
</html>
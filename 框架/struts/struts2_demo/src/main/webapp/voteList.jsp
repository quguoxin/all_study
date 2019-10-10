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
    <title>default page</title>

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
<h3><a href="addvote.jsp">发布投票</a></h3>
<table id="votelistTable"></table>

<!-- jQuery(Bootstrap的所有JavaScript插件都依赖jQuery，所以必须放在前面)-->
<script src="js/jquery-1.11.1.min.js"></script>
<!-- 加载Bootstrap的所有JavaScript插件，可根据需要只加载单个插件-->
<script src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<!--bootstrap-table插件-->
<script src="bootstrap-3.3.7-dist/bootstrap-table/bootstrap-table.js"></script>
<script src="bootstrap-3.3.7-dist/bootstrap-table/bootstrap-table-zh-CN.js"></script>
<script>
    $(function () {
        //初始化参数
        var options = {
            url:"votelist2.action",//请求后台的路径，获取表格数据的url
            cache: false, // 设置为 false 禁用 AJAX 数据缓存， 默认为true
            striped: true,  //表格显示条纹，默认为false，各行变色
            pagination: true, // 在表格底部显示分页组件，默认false
            pageList: [5, 10, 20, 50], // 设置页面可以显示的数据条数
            pageSize: 5, // 页面数据条数
            pageNumber: 1, // 首页页码
            sidePagination: 'server', // 设置为服务器端分页
            // queryParams: function (params) { // 请求服务器数据时发送的参数，可以在这里添加额外的查询参数，返回false则终止请求
            //     return {
            //         pageSize: params.limit, // 每页要显示的数据条数
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
                    field: 'id', // 返回json数据中的name
                    title: '编号', // 表格表头显示文字
                    align: 'center', // 左右居中
                    valign: 'middle' // 上下居中
                }, {
                    field: 'title',
                    title: '标题',
                    align: 'center',
                    valign: 'middle'
                },{
                    title: '操作',
                    align: 'center',
                    valign: 'middle',
                    formatter:function (value,row,index) {
                        var str='<a id="aaa" href="voteshow.action?choiceid='+row.id+'">进行投票</a>&nbsp;|&nbsp;' +
                            '<a id="bbb" href="tongji.jsp?choiceid='+row.id+'">投票结果</a>';
                        return str;

                    }
                }
            ]
        };
        //初始化表格
        $("#votelistTable").bootstrapTable(options);
    })

    /*function getID(obj) {
            console.log(obj);
    }*/

</script>
</body>
</html>
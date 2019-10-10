<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/27
  Time: 9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=UTF-8"
         isELIgnored="false" %>

<script>
    $(function () {

        $.ajax({});
        //初始化参数
        var options = {
            url:"getYouBi.s",//请求后台的路径，获取表格数据的url
            cache: false, // 设置为 false 禁用 AJAX 数据缓存， 默认为true
            striped: true,  //表格显示条纹，默认为false
            pagination: true, // 在表格底部显示分页组件，默认false
            pageList: [5, 10, 20, 50], // 设置页面可以显示的数据条数
            pageSize: 10, // 页面数据条数
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
                    field: 'create_date',
                    title: '日期',
                    align: 'center',
                    valign: 'middle'
                },{
                    field: 'num',
                    title: '收支',
                    align: 'center',
                    valign: 'middle'
                },{
                    field: 'remark',
                    title: '来源',
                    align: 'center',
                    valign: 'middle'
                },
                // {
                //     field: '',
                //     title: '详情',
                //     align: 'center',
                //     valign: 'middle'
                // },
                // {
                //     field: '',
                //     title: '账户悠币余额',
                //     align: 'center',
                //     valign: 'middle'
                // },
            ]
                };
        //初始化表格
        $("#mytable").bootstrapTable(options);
    })
</script>
</body>
</html>
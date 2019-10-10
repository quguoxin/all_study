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
    <title>default page</title>

</head>
<body>
<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->

<div id="main" style="width: 600px;height:400px;"></div>
<a href="voteList.jsp">继续投票</a>

<!-- 引入 echarts.js -->
<script src="js/echarts.common.min.js"></script>
<script src="js/myJsUtil.js"></script>
<script src="js/jquery-1.11.1.min.js"></script>

<script>
    $(function () {
        var cid=getQueryString("choiceid");
        $.getJSON("votetongji.action",{"cid":cid},function (res) {
            if(res.code==200){
                var contentArray=res.data.contentArray;
                var numArray=res.data.numArray;
                // 基于准备好的dom，初始化echarts实例
                var myChart = echarts.init(document.getElementById('main'));
                // 指定图表的配置项和数据
                var option = {
                    title: {
                        text: '投票结果统计'
                    },
                    tooltip: {},
                    legend: {
                        data: ['数量']
                    },
                    xAxis: {
                        data: contentArray
                    },
                    yAxis: {},
                    series: [{
                        name: '票数',
                        type: 'bar',
                        data: numArray
                    }]
                }
                // 使用刚指定的配置项和数据显示图表。
                myChart.setOption(option);
            }
        })
    })

</script>
</body>
</html>
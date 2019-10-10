<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/27
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
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
    <link href="css/youbi.css" rel="stylesheet">
</head>
<body>

<div class="youbi_all">
    <div class="youbi_all_1">
        <div class="myYoubi">我的悠币</div>
        <hr color="green">
        <div class="myYoubi_top">当前可用悠币：
            <span style="color: red" id="cur_youbiBalance">130.00</span>个
            <span style="width: 150px;height: 30px;background-color: green;color: white">兑换商品</span>
            <a  style="color: red">如何获得由币</a>
        </div>
        <div class="mingxi">获取明细</div>
        <hr>
        <div class="youbi_record">
            <select>
                <option value="0">全部</option>
                <option value="1">支出悠币</option>
                <option value="2">获取悠币</option>
            </select>
            <select>
                <option value="0">全部记录</option>
                <option value="1">近一个月记录</option>
                <option value="2">三个月内记录</option>
            </select>
        </div>

        <div class="youbi_Alltable">

            <div class="youbidaohang">
                <table width="930px" style="text-align: center">
                    <tr style="background-color: #F5F6F6;height:40px">
                        <td width="90px">序号</td>
                        <td width="200px">日期</td>
                        <td width="120px">收支</td>
                        <td width="120px">来源</td>
                        <td width="120px">详情</td>
                        <td>账户悠币余额</td>
                    </tr>
                </table>

            </div>
            <div id="youbilist">

            </div>

        </div>
    </div>
    <div>
        <div class="youbi_bottom">
            <input type="button" value="上一页" size="2px" id="prvBtn"/>
            <input type="text" value="1" size="1px" id="cur_Page"/>
            <input type="button" value="下一页" size="2px" id="nextBtn"/>&nbsp;&nbsp;&nbsp;&nbsp;
            <span id="total_Page"></span>&nbsp;&nbsp;&nbsp;&nbsp; 到第
            <input type="text" value="1" size="1px" id="gotoPage"/>页
            <input type="button" value="确定" id="gotoBtn"/>

        </div>
    </div>
</div>
</div>
<script src="js/jquery-1.11.1.min.js"></script>
<script>
    $(function () {
        var totalPage = 0;
        var pageNo = 1;
        var order_statu = 0;
        $("#order_statu").change(function () {
            order_statu = $(this).val();
            getYoubi(1);
        })


        function getYoubi(no) {
            $.getJSON("getYoubi.s", {"pageNo": no}, function (res) {
                if (res.code == 200) {
                    totalPage = res.data.totalPage;
                    $("#total_Page").html("共" + totalPage + "页");
                    pageNo = res.data.pageNo;
                    $("#cur_Page").val(pageNo);
                    var list = res.data.data;
                    var yb_balance=res.data.yb_balance;
                    var num=0;
                    var tmp = '';
                    for (var i = 0; i < list.length; i++) {

                        var obj = list[i];
                         num+=obj.num;

                        tmp += '<table width="930px" style="text-align: center">';
                        tmp += '<tr>';
                        tmp += '<td width="90px">'+obj.id+'</td>';
                        tmp += '<td width="200px">'+obj.create_date+'</td>';
                        tmp += '<td width="120px">'+obj.num+'</td>';
                        tmp += '<td width="120px">'+obj.remark+'</td>';
                        tmp += '<td width="120px"></td>';
                        tmp += '<td>'+(yb_balance+num)+'</td>';
                        tmp += '</tr>';
                        tmp += '</table>';
                        $("#cur_youbiBalance").html(yb_balance+num);
                    }

                    $("#youbilist").html(tmp);

                }
            })
        }

        getYoubi(1);
        $("#prvBtn").click(function () {
            pageNo--;
            if (pageNo <= 1) {//防止超出下限
                pageNo = 1;
            }
            getYoubi(pageNo);
        });
        $("#nextBtn").click(function () {
            pageNo++;
            if (pageNo >= totalPage) {//防止超出上限
                pageNo = totalPage;
            }
            getYoubi(pageNo);
        });
        $("#gotoPage").blur(function () {
            var num = $(this).val();
            if (num <= 1) {//防止超出下限
                num = 1;
            } else if (num >= totalPage) {//防止超出上限
                num = totalPage;
            }
            $(this).val(num);
        });

        $("#gotoBtn").click(function () {
            getYoubi($("#gotoPage").val());
        });
    });

</script>
</body>
</html>

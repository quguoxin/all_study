<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<form id="all" name="all">

标题&nbsp;&nbsp;&nbsp;&nbsp;
<input style="height: 20px" id="titles" size="40" type="text" name="title"><br><br>
<input type="radio" name="optionType" value="1">单选&nbsp;&nbsp;
<input type="radio" name="optionType" value="2">多选<br><br>
<div>
    <table id="tables">

    </table>
    <input type="button" id="add" value="添加选项"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="" id="fabu">发布</a>
</div>
</form>
</body>

<script src="js/jquery-1.11.1.min.js"></script>
<script>

    //显示页面方法
    /*function show() {
        $.getJSON("showoption.action","",function(res) {
            if(res.code==200){
                var list = res.data;
                var tmp='';
                for(var i=0;i<list.length;i++){
                    var obj=list[i];
                    $("#title").val(obj.title);
                    tmp+='<tr>';
                    tmp+='<td>选项'+(i+1)+'</td>';
                    tmp+='<td><input type="text" name="option2" value="'+obj.option+'"></td>';
                    tmp+='<td><a href="JavaScript:del('+obj.id+');">删除</a></td>';
                    tmp+='</tr>';
                }
                $("#tables").html(tmp);
            }
        })
    }*/

    $(function () {
        //增加
        $("#add").click(function(){
            var newTr=$('<tr style="height: 40px">\n' +
                '            <td>选项&nbsp;&nbsp;&nbsp;&nbsp;</td>\n' +
                '            <td><input style="height: 20px" size="40" type="text" name="countArray" ></td>\n' +
                '            <td width="60px" align="right"><input type="button" value="删除"></td>\n' +
                '        </tr>')
            $("table").after(newTr);
            del();
        })

        del();
        function del() {
            $(".del").click(function () {
                $(this).parent().parent().remove();
            })
        }

        //发布
        $("#fabu").click(function () {
            $.getJSON("voteadd.action",$("#all").serialize(),function (res) {
                if(res.code==200){
                }
            })
        })
    })
</script>
</html>
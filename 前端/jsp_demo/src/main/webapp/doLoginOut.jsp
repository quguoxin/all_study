
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=UTF-8"
         isELIgnored="false" %>
<%@ page import="com.qgx.www.util.DateUtil" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<%
    //先用Map集合保存一次的注销信息
    Map<String,Object> map=new HashMap<String, Object>();
    map.put("loginDate",new Date());
    map.put("loginName",session.getAttribute("loginUser"));
    map.put("loginNumber",1);
    map.put("doType","注销");
    //用list集合记录多次注销的信息
    List<Map>tongJiList=null;
    if(application.getAttribute("tongji")==null){//判断是不是首次操作
        tongJiList=new ArrayList<Map>();//是则创建集合
    }else {//不是则获取原先集合并做添加
        tongJiList=(List<Map>) application.getAttribute("tongji");
    }
    tongJiList.add(map);
    //记录用户注销信息，用application全局变量
    application.setAttribute("tongji",tongJiList);
    //清除所有保存在会话中的信息
    session.removeAttribute("loginUser");//按key删除
    session.invalidate();//注销所有session信息
    response.sendRedirect("login_demo.jsp");
%>



<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=UTF-8"
         isELIgnored="false" %>
<%@ page import="com.qgx.www.service.UserinfoService" %>
<%@ page import="com.qgx.www.service.impl.UserinfoServiceImpl" %>
<%@ page import="com.qgx.www.entity.Userinfo" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%
    //设置编码get/post
    request.setCharacterEncoding("UTF-8");
    //接收参数
    String username=request.getParameter("username");
    String password=request.getParameter("password");
    String repassword=request.getParameter("repassword");
    String sex=request.getParameter("sex");
    String[] a=request.getParameterValues("love");
    String love="";
    for(String b:a){
        if(love.equals("")){
            love=love+b;
        }
        love=love+"、"+b;
    }

    String email=request.getParameter("email");
    if(!password.equals(repassword)){
        //密码输入错误返回注册页面
        response.sendRedirect("register.jsp");
    }else{
        Userinfo userinfo=new Userinfo(username,sex,password,email,love);
        //调用后台java类处理请求（只能调用业务类serverce包）
        UserinfoService userinfoService=new UserinfoServiceImpl();
        boolean isok=userinfoService.register(userinfo);
        //根据结果跳转
        if(isok){
            //注册成功
            //转发
            response.sendRedirect("login_demo.jsp");
        }else {
            //注册失败，返回注册
            response.sendRedirect("register.jsp");
        }
    }
%>

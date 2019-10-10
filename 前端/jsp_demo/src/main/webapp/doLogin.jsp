
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=UTF-8"
         isELIgnored="false" %>
<%@ page import="com.qgx.www.service.UserinfoService" %>
<%@ page import="com.qgx.www.service.impl.UserinfoServiceImpl" %>
<%@ page import="com.qgx.www.entity.Userinfo" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="com.qgx.www.util.DateUtil" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
    //接收cookie的保存时间
    String timer=request.getParameter("timer");
    //调用后台java类处理请求（只能调用业务类serverce包）
    UserinfoService userinfoService=new UserinfoServiceImpl();
    boolean isok=userinfoService.login(username,password);
    //根据结果跳转
    if(isok){
        //登录成功
        ////////////////////////////////处理cookie///////////////////////////////////////////
        Cookie cookie=new Cookie("loginMsg", URLEncoder.encode(username+"-"+password,"utf-8"));//定义Cookie
        cookie.setMaxAge(timer==null?-1:Integer.parseInt(timer));//利用三元运算符判断timer是否为空即是否勾选页面
        response.addCookie(cookie);
        ///////////////////////////////处理操作日志///////////////////////////////////////////
        //先用Map集合保存一次的登录信息
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("loginDate",new Date());
        map.put("loginName",username);
        map.put("loginNumber",1);
        map.put("doType","登录");
        //用list集合记录多次登录的信息
        List<Map>tongJiList=null;
        if(application.getAttribute("tongji")==null){//判断是不是首次登录
            tongJiList=new ArrayList<Map>();//是则创建集合
        }else {//不是则获取原先集合并做添加
            tongJiList=(List<Map>) application.getAttribute("tongji");
        }
        tongJiList.add(map);
        //记录用户登录信息，用application全局变量
        application.setAttribute("tongji",tongJiList);
        ///////////////////////////////处理登录//////////////////////////////////////////////
        session.setAttribute("loginUser",username);
        //查询所有用户信息
        List<Userinfo>list=userinfoService.findAll();
        //设置作用域
        session.setAttribute("userlist",list);
        //手动设置session最大的生命周期
        //session.setMaxInactiveInterval(1800000);
        //重定向
        //response.sendRedirect("WEB-INF/main_mydemo.jsp");
        //转发
        request.getRequestDispatcher("WEB-INF/main.jsp").forward(request,response);
    }else {
        //登录失败，返回登录
        response.sendRedirect("login_demo.jsp");
    }
%>
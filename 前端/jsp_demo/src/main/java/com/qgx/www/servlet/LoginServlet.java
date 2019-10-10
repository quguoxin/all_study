package com.qgx.www.servlet;

import com.alibaba.fastjson.JSON;
import com.qgx.www.bean.ResponseBody;
import com.qgx.www.entity.Userinfo;
import com.qgx.www.listener.OnlineListener;
import com.qgx.www.service.UserinfoService;
import com.qgx.www.service.impl.UserinfoServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.*;

public class LoginServlet extends HttpServlet{
    private String encoding;
    private UserinfoService userinfoService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req.setCharacterEncoding(encoding);
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding(encoding);
        //创建作用域对象
        HttpSession session=req.getSession();
        ServletContext application=req.getServletContext();
        //////////////////////ajax技术/////////////////////////
        PrintWriter printWriter=resp.getWriter();
        ResponseBody responseBody=new ResponseBody();
        //接收参数
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        //传电话号码
        session.setAttribute("phone",username);
        //将session加入HttpSessionBindingListener监听
        OnlineListener onlineListener=new OnlineListener(username);
        onlineListener.setApplication(application);
        session.setAttribute("session_listener",onlineListener);
        //接收cookie的保存时间
        String timer=req.getParameter("timer");
        //调用后台java类处理请求（只能调用业务类serverce包）
        //UserinfoService userinfoService=new UserinfoServiceImpl();
        //获取验证码
        String verificationCode1= (String) req.getParameter("password1");
        String verificationCode2= (String) session.getAttribute("verificationCode");
        //比较
        if(!verificationCode1.equals(verificationCode2)){
           /* resp.sendRedirect("login.jsp");
            session.setAttribute("error","验证码错误");*/
            //////////////////////利用ajax技术判断验证码//////////////////////////
            responseBody.setCode(-1);
            responseBody.setMsg("验证码不正确呀");
            printWriter.write(JSON.toJSONString(responseBody));
            return;
        }

        boolean isok=userinfoService.login(username,password);
        //根据结果跳转
        if(isok){
            //登录成功
            ////////////////////////////////处理cookie///////////////////////////////////////////
            Cookie cookie=new Cookie("loginMsg", URLEncoder.encode(username+"-"+password,"utf-8"));//定义Cookie
            cookie.setMaxAge(timer==null?-1:Integer.parseInt(timer));//利用三元运算符判断timer是否为空即是否勾选页面
            resp.addCookie(cookie);
            ///////////////////////////////处理操作日志///////////////////////////////////////////
            //先用Map集合保存一次的登录信息
            Map<String,Object> map=new HashMap<String, Object>();
            map.put("loginDate",new Date());
            map.put("loginName",username);
            map.put("loginNumber",1);
            map.put("doType","登录");
            //用list集合记录多次登录的信息
            List<Map> tongJiList=null;
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
            //session.setAttribute("date",new Date());
            //手动设置session最大的生命周期
            //session.setMaxInactiveInterval(1800000);
            //重定向
            //response.sendRedirect("WEB-INF/main_mydemo.jsp");
            //转发
            //req.getRequestDispatcher("WEB-INF/main.jsp").forward(req,resp);
            ///////////////////利用ajax技术////////////////////
            //成功
            responseBody.setCode(200);
            responseBody.setMsg("登录成功");
        }else {
            //登录失败，返回登录
            //resp.sendRedirect("login.jsp");
            ////////////////////ajax技术///////////////////////////
            responseBody.setCode(-1);
            responseBody.setMsg("用户名或密码不正确");
        }
        printWriter.write(JSON.toJSONString(responseBody));
    }

    @Override
    public void destroy() {
        //System.out.println("destory");
    }

    @Override
    public void init() throws ServletException {
        //System.out.println("init");
        encoding=super.getInitParameter("encoding");//获取编码
        userinfoService=new UserinfoServiceImpl();//新建对象
    }
}

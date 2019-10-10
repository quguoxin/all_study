package com.qgx.www.servlet;


import com.alibaba.fastjson.JSON;
import com.qgx.www.bean.ResponseBody;
import com.qgx.www.entity.Userinfo;
import com.qgx.www.service.UserinfoService;
import com.qgx.www.service.impl.UserinfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/register.s",initParams ={@WebInitParam(name="encoding",value = "utf-8")} )
public class RegisterServlet extends HttpServlet {
    private UserinfoService userinfoService;
    private Userinfo userinfo;
    private String encoding;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding(encoding);
        HttpSession session=req.getSession();
        //////////////////////ajax技术/////////////////////////
        PrintWriter printWriter=resp.getWriter();
        ResponseBody responseBody=new ResponseBody();
        //接收参数
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String repassword=req.getParameter("repassword");
        String inviteCode=req.getParameter("inviteCode");
        //获取验证码
        String verificationCode3= (String) req.getParameter("verificationCode2");
        String verificationCode4= (String) session.getAttribute("verificationCode");
        //比较
        if(!verificationCode3.equals(verificationCode4)){
            /*resp.sendRedirect("register.jsp");
            session.setAttribute("error2","验证码错误");*/
            //////////////////////利用ajax技术判断验证码//////////////////////////
            responseBody.setCode(-1);
            responseBody.setMsg("验证码不正确呀");
            printWriter.write(JSON.toJSONString(responseBody));
            return;
        }

        if(!password.equals(repassword)){
            //密码输入错误返回注册页面
            resp.sendRedirect("register.jsp");
        }else{
            userinfo=new Userinfo(username,password,inviteCode);
            boolean isok=userinfoService.register(userinfo);
            //根据结果跳转
            if(isok){
                //注册成功
                //转发
                //resp.sendRedirect("login.jsp");
                ///////////////////利用ajax技术////////////////////
                //成功
                responseBody.setCode(200);
                responseBody.setMsg("注册成功");
            }else {
                //注册失败，返回注册
                //resp.sendRedirect("register.jsp");
                ////////////////////ajax技术///////////////////////////
                responseBody.setCode(-1);
                responseBody.setMsg("注册失败");
            }
            printWriter.write(JSON.toJSONString(responseBody));
        }
    }

    @Override
    public void destroy() {

    }

    @Override
    public void init() throws ServletException {
        encoding=super.getInitParameter("encoding");//获取编码
        userinfo=new Userinfo();
        userinfoService=new UserinfoServiceImpl();//新建对象
    }
}

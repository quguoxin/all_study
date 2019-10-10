package com.qgx.www.servlet;

import com.alibaba.fastjson.JSON;
import com.qgx.www.bean.ResponseBody;
import com.qgx.www.service.UserinfoService;
import com.qgx.www.service.impl.UserinfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/checkPhone.s")
public class CheckPhoneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收页面ajax请求
        String phone =req.getParameter("phone");
        //调用业务
        UserinfoService userinfoService=new UserinfoServiceImpl();
        Boolean ok= userinfoService.checkPhone(phone);
        //处理服务器响应的数据。格式{code:200,msg:'消息描述',data:Object}
        ResponseBody responseBody=new ResponseBody();
       // responseBody.setCode(200);//请求成功
        if(ok){//已经存在
            responseBody.setCode(201);//请求成功
            responseBody.setMsg("手机号，已经被注册");
        }else {
            responseBody.setCode(200);//请求成功
            responseBody.setMsg("手机号可以注册");
        }
        //将后台数据响应给页面只需要返回数据，不跳页面
        PrintWriter printWriter=resp.getWriter();
        printWriter.write(JSON.toJSONString(responseBody));
    }
}

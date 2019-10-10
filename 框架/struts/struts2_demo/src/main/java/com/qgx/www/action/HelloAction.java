package com.qgx.www.action;

import com.alibaba.fastjson.JSON;
import com.qgx.www.bean.LoginBean;
import com.qgx.www.bean.ResponseBody;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;


import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * 接收页面请求
 */
public class HelloAction implements SessionAware{
    private String sayText;//存储在值栈，类似request作用域
    private LoginBean loginBean;
    private Map<String,Object> session;



    public String test(){
        System.out.println("说："+sayText);
        sayText="Hello,"+sayText;
        return "index";//这里的是自定义的逻辑名称，跳转到index.jsp页面，在struts.xm中对应
    }


    public String dologin(){
        System.out.println("我在接收异步请求，实现登录");
        //调用业务
        ResponseBody responseBody=new ResponseBody();
        System.out.println(loginBean.getPassword());
        if(loginBean.getUsername().equals("admin")&&loginBean.getPassword().equals("123")){
            responseBody.setCode(200);
            responseBody.setMsg("登录成功");
            //存储会话信息
            session.put("username",loginBean.getUsername());

        }else {
            responseBody.setCode(-1);
            responseBody.setMsg("账号或密码错误");
        }
        //响应输出
        HttpServletResponse response= ServletActionContext.getResponse();
        try {

            PrintWriter printWriter=response.getWriter();
            printWriter.write(JSON.toJSONString(responseBody));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    ////////////////////////////get or  set ////////////////////////////////////////////
    //页面临时调用时使用
    public String getSayText() {
        return sayText;
    }

    //传入参数时使用
    public void setSayText(String sayText) {
        this.sayText = sayText;
    }

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session=map;
    }
}

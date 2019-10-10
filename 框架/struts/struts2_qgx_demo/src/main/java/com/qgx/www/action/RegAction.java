package com.qgx.www.action;

import com.qgx.www.myframework.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("我在做注册请求");
        //业务。。。。。。。。。
        return "fail";
    }
}

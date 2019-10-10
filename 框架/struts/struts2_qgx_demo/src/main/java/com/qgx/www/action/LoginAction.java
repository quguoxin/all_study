package com.qgx.www.action;

import com.qgx.www.myframework.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("我在做登录请求");
        //业务。。。。。。。。。
        return Action.SUCCESS;
    }
}

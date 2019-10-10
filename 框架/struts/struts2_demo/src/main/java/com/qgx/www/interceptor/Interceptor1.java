package com.qgx.www.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class Interceptor1 extends AbstractInterceptor{
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        System.out.println("[前置处理]拦截器1--"+this.getClass().getName());
        //将控制权转移到下一个拦截器或action
        String result = actionInvocation.invoke();
        System.out.println("[后置处理]拦截器1--"+this.getClass().getName());
        return result;
    }
}

package com.qgx.www.aop.advice;

import com.qgx.www.util.DateUtil;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;
@Component
public class GreetingBeforeAndAfterAdvice implements MethodBeforeAdvice,AfterReturningAdvice {
    /**
     * 后置加强
     * @param returnValue 返回值
     * @param method 方法对象
     * @param args  参数数组
     * @param target 目标对象（被代理对象）
     * @throws Throwable
     */
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println(target.getClass().getName()+"-"+method.getName()+",after_参数"+Arrays.toString(args)+",返回值_"+returnValue+DateUtil.format(new Date()));
    }

    /**
     *前置加强
     * @param method 方法对象
     * @param args 参数数组
     * @param target 目标对象（被代理对象）
     * @throws Throwable
     */
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println(target.getClass().getName()+"-"+method.getName() + ",before_参数" + Arrays.toString(args) +DateUtil.format(new Date()));
    }
}

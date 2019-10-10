package com.qgx.www.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试拦截器
 */
@Controller
@RequestMapping("/interceptor")
public class TestInterceptorAction {

    @RequestMapping(value = "/interceptorTest")
    public ModelAndView testInterceptor(){
        System.out.println("-----执行控制器："+this.getClass().getName()+"-interceptorTest");
        Map<String,String> map = new HashMap<String, String>();
        map.put("qgx","新哥在测试拦截器");
        ModelAndView modelAndView= new ModelAndView("main",map);
        return modelAndView;
    }
}

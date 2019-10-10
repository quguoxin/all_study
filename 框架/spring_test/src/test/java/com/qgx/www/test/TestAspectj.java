package com.qgx.www.test;

import com.qgx.www.service.UserInfoService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAspectj {
    @Test
    public void testAspety(){
        //解析配置
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");
        UserInfoService userInfoService=(UserInfoService) applicationContext.getBean("userInfoServiceImpl");
        System.out.println(userInfoService.getUserInfo(1234));
    }
}

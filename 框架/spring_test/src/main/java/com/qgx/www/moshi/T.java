package com.qgx.www.moshi;

import com.qgx.www.ioc.UserInfo;
import com.qgx.www.moshi.Singleton;
import com.qgx.www.moshi.abstractfactory.FactoryA;
import com.qgx.www.moshi.abstractfactory.FactoryB;
import com.qgx.www.moshi.abstractfactory.Food;
import com.qgx.www.moshi.abstractfactory.Produce;
import com.qgx.www.moshi.proxy.King;
import com.qgx.www.moshi.proxy.Taijian;
import com.qgx.www.service.UserInfoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");
        UserInfo userInfo1=(UserInfo) applicationContext.getBean("userinfo1");
        UserInfo userInfo2=(UserInfo) applicationContext.getBean("userinfo2");
        UserInfo userInfo3=(UserInfo) applicationContext.getBean("userinfo3");
        //System.out.println(userInfo3);

        //调用业务层的注解对象必须遵照规则：将业务层类名首字母小写
        UserInfoService userInfoService=(UserInfoService) applicationContext.getBean("userInfoServiceImpl");
        UserInfo userInfo4=userInfoService.getUserInfo(8866);
        //System.out.println(userInfo4);

        Singleton singleton2=Singleton.getInstance();
        System.out.println(singleton2);


        //Produce produce=new FactoryB();
        //Food food=produce.getFood();

        /*King king=new King();
        Taijian taijian=new Taijian(king);
        taijian.getGirl();*/
    }
}

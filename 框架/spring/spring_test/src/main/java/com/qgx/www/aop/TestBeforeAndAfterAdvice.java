package com.qgx.www.aop;

import com.qgx.www.aop.advice.GreetingBeforeAndAfterAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBeforeAndAfterAdvice {
    public static void main(String[] args) {
        //测试声明方式
        /*ProxyFactory proxyFactory=new ProxyFactory();//创建一个代理工厂
        proxyFactory.setTarget(new GreetingImpl());//设置要代理的对象
        proxyFactory.addAdvice(new GreetingBeforeAndAfterAdvice());//添加自定义前置后置增强
        Greeting proxyObj=(Greeting) proxyFactory.getProxy();//生产代理对象
        proxyObj.sayHello("龚胜伟");*/

        //测试声明方式
        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("spring.xml");
        Greeting proxyObj=(Greeting) applicationContext.getBean("proxyObj");
        proxyObj.sayHello("龚胜伟");
    }
}

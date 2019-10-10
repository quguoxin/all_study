package com.qgx.www.aop;

import org.springframework.stereotype.Component;

@Component
public class GreetingImpl implements Greeting{
    @Override
    public String sayHello(String name) {
        return name;
    }
}

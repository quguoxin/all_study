package com.qgx.www.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import java.util.HashMap;
import java.util.Map;


public class OnlineListener implements HttpSessionBindingListener{
    public static Map<String,String> online_Map=new HashMap<String, String>();
    private String username;
    private ServletContext application;
    public ServletContext getApplication() {
        return application;
    }

    public void setApplication(ServletContext application) {
        this.application = application;
    }

    public OnlineListener() {
    }

    public OnlineListener(String username) {
        this.username = username;
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("触发-valueBound");
        System.out.println("【"+this.username+"】上线");
        //记录在线人数
        online_Map.put(username,username);
        //发送请求
        application.setAttribute("online_num",online_Map.size());//人数
        application.setAttribute("online_user",online_Map);//用户名
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("触发-valueUnbound");
        System.out.println("【"+this.username+"】下线");
        //删除在线人数
        online_Map.remove(username);
        //再次发送请求
        application.setAttribute("online_num",online_Map.size());//人数
        application.setAttribute("online_user",online_Map);//用户名
    }
}

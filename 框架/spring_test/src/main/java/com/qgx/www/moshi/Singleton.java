package com.qgx.www.moshi;

/**
 * 单例懒汉
 */
public class Singleton {
    public static Singleton singleton =null;
    //无参构造
    public Singleton() {
    }
    public static Singleton getInstance(){
        //在第一次访问时判断是否创建对象，以后将不再进入
        if(singleton==null){
            synchronized (Singleton.class){
                //保证进入的多个线程，第一个线程创建对象。其他线程直接跳过
                if(singleton==null){
                    singleton=new Singleton();
                }
            }
        }
        return singleton;
    }

}

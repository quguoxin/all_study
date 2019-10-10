package com.qgx.www.moshi;

/**
 * 饿汉单例
 */
public class Singleton2 {
    private static Singleton2 singleton2=new Singleton2();
    public Singleton2() {
    }
    public static Singleton2 getInstance(){
        return singleton2;
    }
}

package com.qgx.www.myframework;

/**
 * 利用反射机制，根据类的类型获取到类的实例
 */
public class ActionManager {
    public static Action createAcrion(String className){
        try {
            Class cla=Class.forName(className);
            Action action=(Action) cla.newInstance();//实例化
            return action;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

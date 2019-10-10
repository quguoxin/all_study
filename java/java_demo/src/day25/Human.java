package day25;

import util.ReflectUtil;

public class Human  {
    private String name;
    private Dream dream;

    public void show(String name,Dream dream){
        System.out.println("我的名字是："+name);
        dream.work();
    }

}

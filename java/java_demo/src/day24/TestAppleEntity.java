package day24;

import java.lang.reflect.Field;

public class TestAppleEntity {
    public static void main(String[] args) {
        try {
            Class cla=Class.forName("day24.AppleEntity");
            Field[] fields=cla.getDeclaredFields(); // 提取所有属性
            for(Field f:fields){  //循环输出
                if(f.getName().equals("name")){
                    if(f.isAnnotationPresent(AppleName.class)){  // 判断自定义注解和读取出来的注解类型是相同类型，提取
                        AppleName appleName=f.getAnnotation(AppleName.class);
                        System.out.println("苹果名字："+appleName.name());
                    }
                }

                if(f.getName().equals("color")){
                    if(f.isAnnotationPresent(ColorName.class)){
                        ColorName colorName=f.getAnnotation(ColorName.class);
                        System.out.println("苹果颜色："+colorName.color());
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

package day24.t2;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

public class TestStudent {
    public static void main(String[] args) {
        try {
            Class cla=Class.forName("day24.t2.Student");
            //获取类注解
            // 判断自定义注解和读取出来的注解类型是相同类型
            if(cla.isAnnotationPresent(Table.class)){
                //提取
                Table table=(Table) cla.getAnnotation(Table.class);
                System.out.println("类的注解是："+table.tableName());
            }

            //获取属性注解
            // 提取所有属性
            Field[] fields=cla.getDeclaredFields();
            for(Field f:fields){
                //填入注解的属性名
                if(f.getName().equals("studentNo")){
                    // 判断自定义注解和读取出来的注解类型是相同类型
                    if(f.isAnnotationPresent(Column.class)){
                        //提取
                        Column column=f.getAnnotation(Column.class);
                        System.out.println("名字："+column.name()+"，是否为空："+column.isNull());
                    }
                }

                if(f.getName().equals("studentName")){
                    if(f.isAnnotationPresent(Column.class)){
                        Column column=f.getAnnotation(Column.class);
                        System.out.println("名字："+column.name()+"，长度为："+column.size());
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

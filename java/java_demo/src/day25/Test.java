package day25;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) {
        try {
            Class cla=Class.forName("com.longchang.www.JdbcUtil");
            System.out.println("********属性*********");
            Field[] fields=cla.getDeclaredFields();
            for(Field field:fields){
                System.out.println(field);
            }

            System.out.println("\n************方法***********");
            Method[] methods=cla.getDeclaredMethods();
            for(Method method:methods){
                System.out.println(method);
            }

            System.out.println("\n***********构造器*************");
            Constructor[] constructors= cla.getDeclaredConstructors();
            for(Constructor constructor:constructors){
                System.out.println(constructor);
            }

            System.out.println("\n**********父类*************");
            System.out.println(cla.getSuperclass());

            System.out.println("\n**********所属的包*************");
            System.out.println(cla.getPackage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

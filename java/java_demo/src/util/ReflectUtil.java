package util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectUtil {
    /**
     * 通过放射动态执行普通方法
     * @param className   类的完全路劲
     * @param methodName   方法名
     * @param paramTypes  参数的类类型
     * @param paramValues  参数值
     * @return  执行结果
     */
    public static Object executeMethoByMethodName(String className,String methodName,Class[] paramTypes,Object[] paramValues){
        try {
            Class cla=Class.forName(className);
            Method method=cla.getDeclaredMethod(methodName,paramTypes); //show
            //开放访问权限
            method.setAccessible(true);
            //执行show()方法
            //invoke(反射的实例化对象)
            Object obj=cla.getDeclaredConstructor().newInstance();
            Object res=method.invoke(obj,paramValues);
            return res;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     *    通过放射动态执行普通方法
     * @param instance  实例对象
     * @param className  类的完全路劲
     * @param methodName  方法名
     * @param paramTypes  参数的类类型
     * @param paramValues  参数值
     * @return   执行结果
     */
    public static Object executeMethoByMethodName(Object instance, String className,String methodName,Class[] paramTypes,Object[] paramValues){
        try {
            Class cla=Class.forName(className);
            Method method=cla.getDeclaredMethod(methodName,paramTypes); //show
            //开放访问权限
            method.setAccessible(true);
            //执行show()方法
            //invoke(反射的实例化对象)
            Object res=method.invoke(instance,paramValues);
            return res;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *        通过类路劲获取类的实例
     * @param className    类的完全路劲
     * @param paramTypes   参数的类类型
     * @param paramValues  参数值
     * @return   执行结果
     */
    public static Object getInstance(String className, Class[] paramTypes, Object[] paramValues) {
        try {
            Class cla = Class.forName(className);
            Constructor constructor = cla.getDeclaredConstructor(paramTypes);
            return constructor.newInstance(paramValues);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

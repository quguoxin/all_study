package day25;

import util.ReflectUtil;

import java.lang.reflect.Constructor;
import java.util.Scanner;

public class TestHuman {
    public static void main(String[] args) {
        Object obj=null;
        String dream;
        System.out.println("***梦想列表***");
        System.out.println("1.科学家\n2.医生");
        System.out.println("请选择：");
        Scanner input=new Scanner(System.in);
        int number=input.nextInt();

        //选择错误后继续循环选择 直到选择正确
        while (number!=1&&number!=2){
            System.out.println("您的梦想有待开发，请重新选择！");
            System.out.println("请选择：");
            number=input.nextInt();
        }

        //选择正确后的筛选
        if(number==1){
            dream="Scientist";
        }else {
            dream="Doctor";
        }

        //创建Dreamd对象
        try {
            Class cla=Class.forName("day25."+dream);
            //Constructor obj1=cla.getDeclaredConstructor();
            obj= cla.getDeclaredConstructor().newInstance();//实例化
        } catch (Exception e) {
            e.printStackTrace();
        }

        //通过反射动态执行普通方法show()
        String className="day25.Human";
        String methodName="show";
        Class[] paramTypes={String.class,Dream.class};
        Object[] paramValues={"瞿老爷",obj};
        ReflectUtil.executeMethoByMethodName(className,methodName,paramTypes,paramValues);
    }
}

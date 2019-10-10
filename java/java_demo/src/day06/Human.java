package day06;

public class Human {
    double weigth;
    double height;
    String sex;
    int age;
    String name;

    public void eat(){
        System.out.println(name+"，年龄"+age+"性别："+sex+"，身高："+height+"，体重："+weigth+",吃饭吃的很多");
    }

    public void sleep(){
        System.out.println(name+"，年龄"+age+"性别："+sex+"，身高："+height+"，体重："+weigth+",很能睡");
    }

    public void snore(){
        System.out.println(name+"，年龄"+age+"性别："+sex+"，身高："+height+"，体重："+weigth+",睡觉打呼噜");
    }

}

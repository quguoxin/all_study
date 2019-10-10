package day10.t4;

public class TestKids1 {
    public static void main(String[] args) {
        Kid1 testKids1=new Kid1();

        System.out.println("年龄："+testKids1.printAge(25)+ " 性别："+testKids1.manOrWorman(1)+
                           " 工作："+testKids1.employeed(0));
    }
}

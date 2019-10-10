package day01;
import java.util.Scanner;
public class HomeWork1 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        double c=380;
        double d=1000;
        double e=0.8;
        System.out.println("******************************");
        System.out.println("装备                  单价");
        System.out.println("黄金战衣 "+"           ¥"+c);
        System.out.println("地狱咆哮的尖刀"+"      ¥"+d);
        System.out.print("请输入够买黄金战衣的数量：");
        int a=input.nextInt();
        System.out.print("请输入够买地狱咆哮尖刀的数量：");
        int b=input.nextInt();
        System.out.println("您够买黄金战衣："+a+"个");
        System.out.println("您购买地狱咆哮尖刀："+b+"个");
        System.out.println("折扣："+e);
        System.out.println("实际消费："+(a*c+b*d)*e);

    }
}

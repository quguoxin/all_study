package day01;
import java.util.Scanner;
public class HomeWork4 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int a=245;
        int b=570;
        int c=320;
        System.out.println("购买物品                    单价");
        System.out.println("黄金战衣                    ￥"+a);
        System.out.println("死亡之弩                    ￥"+b);
        System.out.println("冰杖                        ￥"+c);
        System.out.println("请输入折扣：");
        double  g=input.nextDouble();
        System.out.println("黄金战衣折扣价低于100吗？"+(a*g<100));
        System.out.println("黄金战衣折扣价低于100吗？"+(b*g<100));
        System.out.println("黄金战衣折扣价低于100吗？"+(c*g<100));

    }
}

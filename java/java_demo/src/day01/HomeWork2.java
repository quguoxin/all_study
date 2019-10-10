package day01;

public class HomeWork2 {
    public static void main(String[] args) {
        int a = 2;
        int b = 1;
        int c = 1;
        double d = 245;
        double e = 570;
        double f = 320;
        double g = 0.8;
        double h = 1500;
        System.out.println("* * * * * * * *消费单* * * * * * * * * *");
        System.out.println("购买物品      单价      个数           金额");
        System.out.println("黄金战衣      ￥" + d+"     "+a+"          "+a*d);
        System.out.println("死亡之弩      ￥" + e+"     "+b+"          "+b*e);
        System.out.println("水杖          ￥" + f+"     "+c+"          "+c*f);
        System.out.println("折扣：         "+g*10+"折");
        System.out.println("消费总金额:          ￥"+(a*d+b*e+c*f)*g);
        System.out.println("实际交费:            ￥"+h);
        System.out.println("找钱:                ￥" +(h-(a*d+b*e+c*f)*g));
        System.out.println("本次购物所获积分:      "+(int)((a*d+b*e+c*f)*g*3/100));
    }
}

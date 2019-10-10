package day02;
import java.util.Scanner;
public class Entering {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入会员号：");
        int vipNum = input.nextInt();

        if (vipNum <= 9999 && vipNum >= 1000) {
            System.out.println("请输入会员生日（日/月）：");
            String birthday = input.next();
            System.out.println("请输入积分：");
            int integral = input.nextInt();
            System.out.println("已录入会员信息是：");
            System.out.println(vipNum + "\t" + birthday + "\t" + integral);
        } else {
            System.out.println("录入失败！！！");
        }
    }
}
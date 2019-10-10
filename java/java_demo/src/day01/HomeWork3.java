package day01;
import java.util.Scanner;
public class HomeWork3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入四位会员号：");
        int g = input.nextInt();
        int a = g/1000;
        int b = (g % 1000)/100;
        int c = (g%100)/10;
        int d = g%10;

        System.out.println("会员卡号" + g + "各位之和：  " + (a+b+c+d));
        System.out.println("是幸运客户吗？  " + ((a + b + c + d) > 20));
    }
}
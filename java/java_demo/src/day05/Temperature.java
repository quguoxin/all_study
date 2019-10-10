package day05;

import java.util.Scanner;

public class Temperature {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("请输入华氏温度：");
        double fahrenheit=input.nextDouble();
        double celsius=(fahrenheit-32)*5/9;
        System.out.print("当前的华氏温度为："+celsius);
    }
}

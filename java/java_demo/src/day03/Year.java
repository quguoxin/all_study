package day03;
import java.util.Scanner;
public class Year {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("请输入一个年份");
        int time=input.nextInt();
        if((time%4==0&&time%100!=0)||time%400==0){
            System.out.println(time+"是闰年");
        }else{
            System.out.println(time+"是平年");
        }
    }
}

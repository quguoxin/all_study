package day04;
import java.util.Scanner;
public class JudgeNumber {
    public static void main(String[] args) {
        int sum1=0;
        int sum2=0;
        Scanner input=new Scanner(System.in);
        System.out.print("请输入数字：");
        int number=input.nextInt();
        while(number!=0){
            if(number>0){
                sum1++;
            }else {
                sum2++;
            }
            System.out.print("请再次输入数字：");
            number=input.nextInt();
        }
        System.out.println("游戏结束\n所有的正数个数是："+sum1+"\n"+"所有的负数的个数是："+sum2);
    }
}

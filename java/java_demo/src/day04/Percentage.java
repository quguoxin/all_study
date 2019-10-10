package day04;
import java.util.Scanner;
public class Percentage {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int sum1=0;
        int sum2=0;
        /*int i=1;
        do{
            System.out.print("请输入第"+i+"位顾客的年龄：");
            int age=input.nextInt();
            if(age>=30){
                sum1++;
            }else{
                sum2++;
            }
            i++;
        }while (i<=10);
        System.out.println("30岁以下的比例是："+sum2*10+"%\n30岁以上的比例是："+sum1*10+"%");*/

        /*int i=1;
        while (i<=10){
            System.out.print("请输入第"+i+"位顾客的年龄：");
            int age=input.nextInt();
            if(age>=30){
                sum1++;
            }else{
                sum2++;
            }
            i++;
        }
        System.out.println("30岁以下的比例是："+sum2*10+"%\n30岁以上的比例是："+sum1*10+"%");*/

        for(int i=1;i<=10;i++){
            System.out.print("请输入第"+i+"位顾客的年龄：");
            int age=input.nextInt();
            if(age>=30){
                sum1++;
            }else{
                sum2++;
            }
        }
        System.out.println("30岁以下的比例是："+sum2*10+"%\n30岁以上的比例是："+sum1*10+"%");
    }
}

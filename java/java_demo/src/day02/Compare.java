package day02;
import java.util.Scanner;
public class Compare {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("请输入第一个数：");
        int num1=input.nextInt();
        System.out.print("请输入第二个数：");
        int num2=input.nextInt();
        System.out.print("请输入第三个数：");
        int num3=input.nextInt();
        /*if(num1>=num2&&num2>=num3){
            System.out.println(num3+"<"+num2+"<"+num1);
        }else if(num1>=num3&&num3>=num2){
            System.out.println(num2+"<"+num3+"<"+num1);
        }else if(num2>=num1&&num1>num3){
            System.out.println(num3+"<"+num1+"<"+num2);
        }else if(num2>=num3&&num3>=num1){
            System.out.println(num1+"<"+num3+"<"+num2);
        }else if(num3>=num1&&num1>=num2){
            System.out.println(num2+"<"+num1+"<"+num3);
        }else{
            System.out.println(num1+"<"+num2+"<"+num3);
        }*/
        int a=0;
        if(num1>=num2){
            a=num2;
            num2=num1;
            num1=a;
        }
        if(num1>=num3){
            a=num3;
            num3=num1;
            num1=a;
        }
        if(num2>=num3){
            a=num3;
            num3=num2;
            num2=a;
        }

    }
}

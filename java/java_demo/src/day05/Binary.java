package day05;

import java.util.Scanner;

public class Binary {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("请输入一个十进制的数：");
        int number=input.nextInt();

        /*int i=0;
        int[] two=new int[100];
        do{
            two[i]=number%2;
            number=number/2;
            if(number==1){
                two[i+1]=1;
                break;
            }
            i++;
        }while (number!=1);

        System.out.print("二进制是：");
        for(int j=i+1;j>=0;j--){
            System.out.print(two[j]);
        }*/


        int number1=number;//为防止求完数组长度以后number的值会变，单独拿出来为后面给数组赋值用

        int length=1;
        while (number!=1){                        //此次循环求数组长度
            number=number/2;
            length++;
        }
        System.out.println("数组长度是："+length);

        int i=0;
        int[] two=new int[length];
        while (number1!=1){                         //此次循环给数组赋值
            two[i]=number1%2;
            number1=number1/2;
            i++;
        }

        two[length-1]=1;          //数组最后一个值为1，单独赋值


        System.out.print("二进制是：");//逆向输出数组
        for(int j=length-1;j>=0;j--){
            System.out.print(two[j]);
        }

        //牛逼方法！！！！！！！！！！！！！！！！！
        /*String str="";
        while (number!=1){
            str=number%2+str;
            number=number/2;
        }
        str="1"+str;
        System.out.println(str);*/

    }
}

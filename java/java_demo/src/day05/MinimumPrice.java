package day05;

import java.util.Scanner;
public class MinimumPrice {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        double[] money=new double[4];
        double min=0;
        double tmp=0;
        System.out.println("请输入4家店的价格");
        for(int i=0;i<4;i++){
            System.out.print("请输入第"+(i+1)+"店的价格：");
            money[i]=input.nextDouble();
            if(i==0){
                min=money[i];
            }

            if(min>money[i]){
                min=money[i];
            }
        }
        System.out.println("最低价格是"+min);
    }
}

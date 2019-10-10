package day04;
import java.util.Scanner;
public class PerfectNumber {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("请输入你要选择的范围(例如“8+88+888+n个8=？”即输入n的值）：");
        int n=input.nextInt();
        /*long eight=8L;
        long sum1=0L;
        long sum2=0L;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){//得到8+80+800+8000....即得到8 88 888 8888...
                for(int k=2;k<=j;k++){//得到80 800 8000...给到上一层循环进行累加
                    eight=eight*10;
                }
                sum1+=eight;
                eight=8;
            }
            sum2+=sum1;
            sum1=0;
        }
        System.out.println(sum2);*/


        String danGeShu="";
        long total=0L;
          for(int i=1;i<=n;i++){
              for(int j=1;j<=i;j++){
                  danGeShu+="8";
              }
              System.out.println(danGeShu);
              total+=Long.parseLong(danGeShu);//调用
              danGeShu="";
          }
        System.out.println(total);
    }
}

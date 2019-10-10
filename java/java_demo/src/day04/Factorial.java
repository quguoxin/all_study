package day04;
import java.util.Scanner;
public class Factorial {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("请输入你要选择的范围(例如1！+2！+...n!即输入n的值）：");
        int n=input.nextInt();
        /*long product=1L;
        long sum=0L;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                product=product*j;
            }
            sum+=product;
            product=1;
            System.out.print(i+"!");
            if(i==n){
                System.out.print("=");
            }else{
                System.out.print("+");
            }
        }
        System.out.println(sum);*/

        long total=1l;
        long sum=0l;
        for(int i=1;i<=n;i++){
            total=total*i;
            sum+=total;
        }
        System.out.println(sum);
    }
}

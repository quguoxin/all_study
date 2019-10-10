package day04;
import java.util.Scanner;
public class Divisor {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("请输入你要选择的范围(例如1/1！+1/2！+...1/n!即输入n的值）：");
        int n=input.nextInt();
        int product=1;
        double sum=0.0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                product=product*j;
            }
            sum=sum+1/(double)(product);
            product=1;
            System.out.print("1/"+i+"!");
            if(i==n){
                System.out.print("=");
            }else{
                System.out.print("+");
            }
        }
        System.out.println(sum);
    }
}
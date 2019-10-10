package day03;
import java.util.Scanner;
public class PrimeNumber {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("请输入一个数：");
        int number=input.nextInt();
        if(number%2==0){
            System.out.print(number+"是偶数        ");
            if(number==2){
                System.out.println("是质数");
            }else{
                System.out.println("不是质数");
            }
        }else{
            System.out.print(number+"是奇数     ");
            if(number>1){
                for(int i=2;i<number;i++){
                    if(number%i==0){
                        System.out.println("不是质数");
                        break;
                    }else {
                        if(i==number-1){
                            System.out.println("是质数");
                            break;
                        }
                        continue;
                    }
                }
            }else{
                System.out.println("不是质数");
            }
        }
    }
}

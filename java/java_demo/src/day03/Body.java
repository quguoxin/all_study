package day03;
import java.util.Scanner;
public class Body {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("请输入您的性别：");
        String sex=input.next();
        if(sex.equals("男")||sex.equals("女")){

            System.out.println("请输入您的身高：");
            double height=input.nextDouble();
            System.out.println("请输入您的体重：");
            double weight=input.nextDouble();
            double subtract=weight-(height-100);
            if(sex.equals("男")){
                if(subtract<-3){
                    System.out.println("偏瘦");
                }else if(subtract>=-3&&subtract<=3){
                    System.out.println("标准体质");
                }else{
                    System.out.println("偏胖");
                }
            }else{
                if (subtract<-3){
                    System.out.println("偏瘦");
                }else if(subtract>=-3&&subtract<=3){
                    System.out.println("标准体质");
                }else{
                    System.out.println("偏胖");
                }
            }
        }else {
            System.out.println("你是男是女？");
        }

    }
}

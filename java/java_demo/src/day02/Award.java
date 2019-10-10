package day02;

import java.util.Scanner;

public class Award {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("请输入会员号：");
        int vipNum=input.nextInt();
        int random=(int)(10*Math.random());
        if(vipNum>99){
            if(vipNum%1000/100==random){
                System.out.println(vipNum+"是幸运用户，获精美MP3一个！");
            }else {
                System.out.println(vipNum+"谢谢您的支持！！！");
            }
        }else {
            System.out.println("您输入的会员号有误！");
        }
    }
}

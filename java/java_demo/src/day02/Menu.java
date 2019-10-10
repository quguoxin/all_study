package day02;
import java.util.Scanner;
public class Menu {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("* * * * * * * * * * * * * *");
        System.out.println("电影售票系统");
        System.out.println("1.登录");
        System.out.println("2.注册");
        System.out.println("3.退出");
        System.out.println("* * * * * * * * * * * * * *");
        System.out.print("请输入序号：");
        int number=input.nextInt();
        if(number==1){
            System.out.println(">>>>>>你的用户名>>>>>>>");
            System.out.println("1.购票");
            System.out.println("2.购买零食");
            System.out.println("3.充值会员卡");
            System.out.println("4.积分兑换");
            System.out.print("请选择序号：");
            number=input.nextInt();
            if(number==1){
                System.out.println(">>>>>>>购票");
                System.out.println("1.选择座位");
                System.out.println("2.返回");
                System.out.print("请选择序号：");
                number=input.nextInt();
                if(number==1){
                    System.out.println("座位选择成功！");
                }else if(number==2){
                    System.out.println("返回成功");
                }else{
                    System.out.println("您的输入有误！");
                }
            }else if(number==2){
                System.out.println(">>>>>>>购买零食");
                System.out.println("1.选择薯条");
                System.out.println("2.选择薯片");
                System.out.println("3.返回");
                System.out.print("请选择序号：");
                number=input.nextInt();
                if(number==1){
                    System.out.println("购买薯条成功！");
                }else if(number==2){
                    System.out.println("购买薯条成功！");
                }else if(number==3){
                    System.out.println("返回成功！");
                }else{
                    System.out.println("您的输入有误");
                }
            }else if(number==3){
                System.out.println(">>>>>>>充值会员卡");
                System.out.println("1.请输入充值金额");
                System.out.println("2.返回");
                System.out.print("请选择序号：");
                number=input.nextInt();
                if(number==1){
                    number=input.nextInt();
                    System.out.println("充值成功！");
                }else if(number==2){
                    System.out.println("返回成功！");
                }else{
                    System.out.println("您的输入有误！");
                }
            }else{
                System.out.println(">>>>>>>积分兑换");
                System.out.println("1.请输入兑换金额");
                System.out.println("2.返回");
                System.out.print("请选择序号：");
                number=input.nextInt();
                if(number==1){
                    System.out.print("金额：");
                    number=input.nextInt();
                    System.out.println("兑换成功！");
                }else if(number==2){
                    System.out.println("返回成功！");
                }else{
                    System.out.println("您的输入有误！！");
                }
            }
        }else if(number==2){
            System.out.println("恭喜你注册成功！");
        }else{
            System.out.println("退出成功！");
        }
    }
}

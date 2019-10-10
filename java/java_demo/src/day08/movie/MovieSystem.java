package day08.movie;
import java.util.Arrays;
import java.util.Scanner;
import java.time.DateTimeException;
public class MovieSystem {
    private Scanner input=new Scanner(System.in);
    private double sum1=0;//卡余额
    private double sum2=0;//积分
    private int number;
    private int number1;
    private int ticket[][] = {
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
    };
    /////////////一级菜单////////////
    public void oneMenu(){
        System.out.println("* * * * * * * * * * * * * *");
        System.out.println("电影售票系统");
        System.out.println("1.登录");
        System.out.println("2.注册");
        System.out.println("3.退出");
        System.out.println("* * * * * * * * * * * * * *");
        System.out.print("请输入序号：");
        number=input.nextInt();
        switch (number){
            case 1:
                twoMenu();
            break;
            case 2:
                System.out.println("注册成功！");
                oneMenu();
            break;
            case 3:
                System.out.println("退出成功，祝您观影愉快！");
            break;
            default:
                System.out.println("您的输入有误");
                oneMenu();
            break;
        }
    }
    ///////////二级菜单//////////////////
    public void twoMenu(){
        System.out.println(">>>>>>你的用户名xxx");
        System.out.println("1.购票");
        System.out.println("2.购买零食");
        System.out.println("3.充值会员卡");
        System.out.println("4.积分兑换");
        System.out.println("0.返回");
        System.out.print("请选择序号：");
        number=input.nextInt();
        switch (number){
            case 0:
                oneMenu();
            break;
            case 1:
                if(sum1>30){
                    buyTicket();
                }else {
                    System.out.println("您的余额不足，请先充值！");
                    rechargeMembership();
                }
                break;
            case 2:
                buySnacks();
                break;
            case 3:
                rechargeMembership();
                break;
            case 4:
                creditsExchange();
                break;
            default:
                System.out.println("您的输入有误！");
                twoMenu();
                break;
        }
    }
    ////////////三级菜单/////////////////

    /**
     * 购票
     */
    public void buyTicket(){
        System.out.println(">>>>>>>购票");
        System.out.println("1.选择座位");
        System.out.println("2.返回");
        System.out.print("请选择序号：");
        number=input.nextInt();
        switch (number){
            case 1:
                chooseSeat();
                break;
            case 2:
                twoMenu();
            break;
            default:
                System.out.println("您的输入有误，请重新选择");
                buyTicket();
            break;
        }
    }

    /**
     * 购买零食
     */
    public void buySnacks(){
        System.out.println(">>>>>>>购买零食");
        System.out.println("1.选择薯条¥10");
        System.out.println("2.选择薯片¥10");
        System.out.println("3.返回");
        System.out.print("请选择序号：");
        number=input.nextInt();
        switch (number){
            case 1:
                if(sum1>10){
                   System.out.println("薯片购买成功");
                   sum1=sum1-10;
                   sum2=sum2+10;
                   buySnacks();
                }else {
                    System.out.println("您的余额不足，请先充值！");
                    rechargeMembership();
                }
                break;
            case 2:
                if(sum1>10){
                    System.out.println("薯条购买成功");
                    sum1=sum1-10;
                    sum2+=10;
                    buySnacks();
                }else {
                    System.out.println("您的余额不足，请先充值！");
                    rechargeMembership();
                }
                break;
            case 3:
                twoMenu();
                break;
            default:
                System.out.println("您的输入有误！");
                buySnacks();
                break;
        }
    }

    /**
     * 充值会员
     */
    public void rechargeMembership(){
        System.out.println(">>>>>>>充值会员卡");
        System.out.println("1.请输入充值金额");
        System.out.println("2.返回");
        System.out.print("请选择序号：");
        number=input.nextInt();
        switch (number){
            case 1:
                System.out.print("金额：");
                number=input.nextInt();
                sum1=sum1+number;
                System.out.println("充值成功，您成功充值了："+number+"当前余额："+sum1);
                rechargeMembership();
                break;
            case 2:
                twoMenu();
                break;
            default:
                System.out.println("您的输入有误！");
                rechargeMembership();
                break;
        }
    }
    /**
     * 积分兑换
     */
    public void creditsExchange(){
        System.out.println(">>>>>>>积分兑换,当前积分："+sum2);
        System.out.println("1.请输入兑换积分数：");
        System.out.println("2.返回");
        System.out.print("请选择序号：");
        number=input.nextInt();
        switch (number){
            case 1:
                System.out.print("兑换积分数：");
                number=input.nextInt();
                if(number%10==0){
                    System.out.println("成功兑换"+number/10+"¥");
                    sum2=sum2-number;
                    creditsExchange();
                }else {
                    System.out.println("每10积分才能兑换哦！");
                    creditsExchange();
                }
                break;
            case 2:
                twoMenu();
                break;
            default:
                System.out.println("您的输入有误！");
                creditsExchange();
                break;
        }
    }

    ////////////////////选座/////////////////////////
    public void chooseSeat(){
        System.out.println("         1  2  3  4  5  6 ");
        for (int i = 0; i < 10; i++) {
            System.out.println("第" + (i + 1) + "排\t" + Arrays.toString(ticket[i]));
        }
        System.out.println("上图中‘1’代表无座，‘0’代表有座！");
        System.out.print("请输入您要选择的排数：");
        number=input.nextInt();
        System.out.print("请输入您要选择的列数：");
        number1=input.nextInt();
        while (ticket[number-1][number1-1] == 1) {
            System.out.println("您的选择有误，请重新选择有座区域哦!!!");
            System.out.print("请输入您要选择的排数：");
            number=input.nextInt();
            System.out.print("请输入您要选择的列数：");
            number1=input.nextInt();
        }
        sum1=sum1-30;
        sum2=sum2+30;
        ticket[number-1][number1-1]=1;
        System.out.println("已为您出票！");
        System.out.println("********************\n万达影城\n复仇者联盟3\n日期：2018/5/17\n座位号：" + number  + "排" + number1  + "号\n票价：30¥\n********************");
        buyTicket();
    }
}

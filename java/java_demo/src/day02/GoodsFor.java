package day02;
import java.util.Scanner;
public class GoodsFor{
    public static void main(String[]args){
        Scanner input=new Scanner(System.in);
        System.out.print("请输入消费金额：");
        int money= input.nextInt();
        System.out.println("是否参加优惠活动：");
        System.out.println("0：不换购");
        System.out.println("1：满50元，加2元换购百事可乐1瓶");
        System.out.println("2：满100元，加3元换购500ml可乐一瓶");
        System.out.println("3：满100元，加10元换购5公斤面粉");
        System.out.println("4：满200元，加10元换购1个苏泊尔炒菜锅");
        System.out.println("5：满200元，加20元换购欧莱雅爽肤水一瓶");
        System.out.println("请选择：");
        int number= input.nextInt();
        switch (number){
            case 0:
                System.out.println("谢谢参与！");
            break;
            case 1:
                if(money>=50){
                    System.out.println("本次消费总金额："+(money+2));
                    System.out.println("成功换购：百事可乐1瓶");
                }else {
                    System.out.println("购物满50元才能兑换此商品哦！");
                }
            break;
            case 2:
                if(money>=100){
                    System.out.println("本次消费总金额："+(money+3));
                    System.out.println("成功换购：换购500ml可乐一瓶");
                }else {
                    System.out.println("购物满100元才能兑换此商品哦！");
                }
            break;
            case 3:
                if(money>=100){
                    System.out.println("本次消费总金额："+(money+10));
                    System.out.println("成功换购：5公斤面粉");
                }else {
                    System.out.println("购物满100元才能兑换此商品哦！");
                }
            break;
            case 4:
                if(money>=200){
                    System.out.println("本次消费总金额："+(money+10));
                    System.out.println("成功换购：1个苏泊尔炒菜锅");
                }else {
                    System.out.println("购物满200元才能兑换此商品哦！");
                }
            break;
            case 5:
                if(money>=200){
                    System.out.println("本次消费总金额："+(money+20));
                    System.out.println("成功换购：欧莱雅爽肤水一瓶");
                }else {
                    System.out.println("购物满200元才能兑换此商品哦！");
                }
            break;
            default:
                System.out.println("您的输入有误！");
            break;
        }

    }
}

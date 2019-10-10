package day04;

import java.util.Scanner;
public class MojieSystem {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("**********魔界饰品分发系统******************");
        System.out.println("\t\t\t1.账号信息管理");
        System.out.println("\t\t\t2.购物结算");
        System.out.println("\t\t\t3.装备返点");
        System.out.println("\t\t\t4.注销");
        System.out.println("*******************************************");
        System.out.print("请选择，输入数字：");
        int number=input.nextInt();
        while(number<1||number>4){
            System.out.print("输入错误，请重新输入数字：");
            number=input.nextInt();
        }
        switch(number){
            case 1:
                System.out.println("********账号信息管理**********");
            break;
            case 2:
                System.out.println("********购物结算**************");
            break;
            case 3:
                System.out.println("********装备返点**************");
            break;
            default:
                System.out.println("********注销******************");
            break;
        }

        /*int number;
        do{
            number=input.nextInt();
            switch (number){
                case 1:
                    System.out.println("********账号信息管理**********");
                    break;
                case 2:
                    System.out.println("********购物结算**************");
                    break;
                case 3:
                    System.out.println("********装备返点**************");
                    break;
                case 4:
                    System.out.println("********注销******************");
                break;
                default:
                    System.out.println("输入错误请重新输入：");
                break;
            }
        }while (number<1||number>4);*/
    }
}

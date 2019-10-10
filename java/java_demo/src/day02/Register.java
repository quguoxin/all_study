package day02;
import java.util.Scanner;
public class Register {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("           魔界饰品分发系统");
        System.out.println("                    1.登录系统");
        System.out.println("                    2.退出");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.print("请选择，输入数字：");
        int number=input.nextInt();
        switch (number) {
            case 1:
                System.out.println("******登录系统*********");
                System.out.println("1.会员信息管理");
                System.out.println("2.购物结算");
                System.out.println("3.装备返点");
                System.out.println("4.福利");
                System.out.println("5.注销");
                System.out.println("**********************");
                System.out.print("请选择，输入数字：");
                number = input.nextInt();
                switch (number) {
                    case 1:
                        System.out.println("********会员信息管理********");
                        System.out.println("1.显示所有会员信息");
                        System.out.println("2.添加会员信息");
                        System.out.println("3.修改会员信息");
                        System.out.println("4.查询会员信息");
                        System.out.println("***************************");
                        System.out.print("请选择，输入数字：");
                        number = input.nextInt();
                        switch (number) {
                            case 1:
                                System.out.println("张三  男    20岁   tel：15090814407");
                                break;
                            case 2:
                                System.out.println("添加会员信息成功！");
                                break;
                            case 3:
                                System.out.println("修改会员信息成功！");
                                break;
                            case 4:
                                System.out.println("此功能待开发，敬请关注！");
                                break;
                            default:
                                System.out.println("您的输入有误！");
                                break;
                        }
                        break;
                    case 2:
                        System.out.println("结算成功！");
                        break;
                    case 3:
                        System.out.println("装备返点成功！");
                        break;
                    case 4:
                        System.out.println("*******福利*********");
                        System.out.println("1.幸运大放送");
                        System.out.println("2.幸运抽奖");
                        System.out.println("3.生日问候");
                        System.out.println("********************");
                        System.out.print("请选择，请输入数字：");
                        number = input.nextInt();
                        switch (number) {
                            case 1:
                                System.out.println("欢迎来到幸运大放送！");
                                break;
                            case 2:
                                System.out.println("恭喜你获得精美礼品一份！");
                                break;
                            case 3:
                                System.out.println("恭喜你获得精美礼品一份！");
                                break;
                            default:
                                System.out.println("您的输入有误！");
                                break;
                        }
                        break;
                    case 5:
                        System.out.println("注销成功！");
                        break;
                    default:
                        System.out.println("您的输入有误！");
                    break;
                }
            break;
            case 2:
                System.out.println("退出成功！");
            break;
            default:
                System.out.println("您的输入有误！");
            break;
        }
    }
}

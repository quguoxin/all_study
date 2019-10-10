package day15.Bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginSystem {
    Scanner input=new Scanner(System.in);
    int index;
    int number;
    String str;
    /*String userName;
    String userPassage;
    String userIdCard;*/
    List<BankAccount>list=new ArrayList<BankAccount>();
    //登录菜单
    public void bankMenu(){
        //给集合赋值
        list.add(new BankAccount("000000","0a123456","张零","421002199212054510"));
        list.add(new BankAccount("111111","1a123456","张一","421002199212054511"));
        list.add(new BankAccount("222222","2a123456","张二","421002199212054512"));
        list.add(new BankAccount("333333","3a123456","张三","421002199212054513"));
        list.add(new BankAccount("444444","4a123456","张四","421002199212054514"));
        list.add(new BankAccount("555555","5a123456","张五","421002199212054515"));
        list.add(new BankAccount("666666","6a123456","张六","421002199212054516"));
        list.add(new BankAccount("777777","7a123456","张七","421002199212054517"));
        list.add(new BankAccount("888888","8a123456","张八","421002199212054518"));
        list.add(new BankAccount("999999","9a123456","张九","421002199212054519"));
        System.out.println("*********银行系统************");
        System.out.println("1.登录");
        System.out.println("2.退出");
        System.out.println("请选择序号：");
        number=input.nextInt();
        switch (number){
            case 1:
                checkLogin();
                break;
            case 2:
                System.out.println("退出成功");
                break;
            default:
                System.out.println("您的输入有误，请重新输入！");
                bankMenu();
                break;
        }

    }

    //登录验证
    public void checkLogin(){
        System.out.println(">>>>>>登录");
        System.out.println("请输入您的登录号：");
        str=input.next();
        //验证登录名
        boolean isok=false;
        for(int i=0;i<list.size();i++){
            if(str.equals(list.get(i).getCardNumber())){
                index=i;
                isok=true;
                break;
            }
        }
        if(!isok){
            System.out.println("您还没有注册，请重新输入！");
            checkLogin();
        }
        //验证密码
        do{
            isok=true;
            System.out.println("请输入您的密码：");
            str=input.next();
            if(!(str.equals(list.get(index).getCardPassage()))){
                System.out.println("您的密码输入错误，请重新输入！");
                isok=false;
            }
        }while (!isok);
        System.out.println("登录成功！");
        personalCenter();
    }

    //个人信息
    public void personalCenter(){
        System.out.println(">>>>>个人中心，用户： "+list.get(index).getCardName());
        System.out.println("1.查看个人信息");
        System.out.println("2.修改个人信息");
        System.out.println("3.退出");
        System.out.println("请选择序号：");
        number=input.nextInt();
        switch (number){
            case 1:
                System.out.println("登录卡号："+list.get(index).getCardNumber()
                                  +"\n登录密码："+list.get(index).getCardPassage()
                                   +"\n持卡人姓名："+list.get(index).getCardName()
                                 +"\n身份证号："+list.get(index).getIdCard());
                personalCenter();
                break;
            case 2:
                reviseMassage();
                break;
            case 3:
                System.out.println("退出成功！");
                System.exit(0);
                break;
            default:
                System.out.println("您的输入有误，请重新输入");
                personalCenter();
                break;
        }
    }

    //修改信息
    public void reviseMassage(){
        System.out.println(">>>>>>修改信息");
        System.out.println("1.修改姓名");
        System.out.println("2.修改密码");
        System.out.println("3.修改身份证");
        System.out.println("4.返回");
        System.out.println("请选择：");
        number=input.nextInt();
        switch (number){
            case 1:
                System.out.println("请输入您的新名称：");
                str=input.next();
                //list.get(index).setCardName(str);
                list.set(index,new BankAccount(list.get(index).getCardNumber(),list.get(index).getCardPassage(),str,list.get(index).getIdCard()));
                System.out.println("姓名修改成功！");
                reviseMassage();
                break;
            case 2:
                System.out.println("请输入您的新密码：");
                str=input.next();
                //list.get(index).setCardPassage(str);
                list.set(index,new BankAccount(list.get(index).getCardNumber(),str,list.get(index).getCardName(),list.get(index).getIdCard()));
                System.out.println("密码修改成功！");
                reviseMassage();
                break;
            case 3:
                System.out.println("请输入您的新身份证：");
                str=input.next();
                //list.get(index).setIdCard(str);
                list.set(index,new BankAccount(list.get(index).getCardNumber(),list.get(index).getCardPassage(),list.get(index).getCardName(),str));
                System.out.println("身份证修改成功！");
                reviseMassage();
                break;
            case 4:
                personalCenter();
                break;
            default:
                System.out.println("您的输入有误！");
                reviseMassage();
                break;
        }
        /*System.out.println("请输入您的新名称：");
        str=input.next();
        System.out.println("请输入您的新密码：");
        String str1=input.next();
        System.out.println("请输入您的新身份证：");
        String str2=input.next();
        list.set(index,new BankAccount(list.get(index).getCardNumber(),str,str1,str2));
        System.out.println("修改成功！");
        personalCenter();*/
    }

    public static void main(String[] args) {
        LoginSystem loginSystem=new LoginSystem();
        loginSystem.bankMenu();

    }
}

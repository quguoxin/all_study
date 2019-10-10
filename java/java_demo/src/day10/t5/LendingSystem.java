package day10.t5;

import java.util.Date;
import java.util.Scanner;

public class LendingSystem {
    PersonalCenter personalCenter=new PersonalCenter();
    BookCnter bookCnter=new BookCnter();

    /////////借阅系统/////////////
    Scanner input=new Scanner(System.in);
    private int number;
    private int number1;
    private String[] userName = new String[100];//数组储存  长为可以储存的账号个数
    private String[] password = new String[100];
    private String userNames;//键盘接收
    private String passwords;
    private String user;
    BookCnter[] bookCnters=new BookCnter[]{//图书列表
            new BookCnter(1001, "Java教程", 10, 5),
            new BookCnter(1002, "Python", 10, 5),
            new BookCnter(1003, "PHP教程", 10, 5),
    };

    PersonalCenter[] personalCenters=new PersonalCenter[20];



    //进入页面
    public void welcome(){
        /*PersonalCenter personalCenter=new PersonalCenter();
        BookCnter bookCnter=new BookCnter();*/


        System.out.println("********欢迎光临拥抱互联图书馆*********");
        System.out.println("1.登录");
        System.out.println("2.注册");
        System.out.println("3.退出");
        System.out.print("请输入序号：");
        number=input.nextInt();
        switch (number){
            case 1:
               login();
                break;
            case 2:
                register();
                break;
            case 3:
                System.out.println("退出成功，欢迎下次光临！");
                System.exit(0);
                break;
            default:
                System.out.println("您的输入有误，请重新输入！");
                welcome();
                break;
        }

    }

    //登录判断
    public void login() {
        System.out.println("****登录*****");
        System.out.print("请输入用户名（手机号）：");
        userNames = input.next();
        for (int i = 0; i < userName.length; i++) {
            if(userName[i]==null) {
                System.out.println("您还没有注册，请注册！");
                welcome();
                break;
            }else if(userName[i].equals(userNames)){
                System.out.print("请输入密码：");
                passwords = input.next();
                if (password[i].equals(passwords)) {
                    System.out.println("登录成功！");
                     user=userName[i];
                    oneMenu();
                    break;
                }else {
                    System.out.println("密码错误！请重新输入");
                    login();
                }
            }else {
                continue;
            }
        }
    }

    //注册
    public void register(){
        System.out.println("****注册*****");
        System.out.print("请输入用户名(手机号)：");
        userNames = input.next();
        for (int i = 0; i < userName.length; i++) {
            if (userName[i] == null) {
                userName[i] = userNames;
                System.out.print("请输入密码：");
                passwords = input.next();
                password[i] =passwords;
                System.out.println("注册成功！请登录");
                welcome();
                break;
            } else if (userName[i].equals(userNames)) {
                System.out.println("用户名已经存在请登录！");
                welcome();
                break;
            } else {
                continue;
            }
        }
    }

    //一级菜单
    public void oneMenu(){
        System.out.println("用户："+user);
        System.out.println("拥抱互联图书借阅系统");
        System.out.println("1.借阅图书");
        System.out.println("2.个人中心");
        System.out.println("3.注销账号");
        System.out.print("请选择：");
        number=input.nextInt();
        switch (number){
            case 1:
                lookBookCnter();
                break;
            case 2:
                lookPersonalCenter();
                break;
            case 3:
                welcome();
                break;
            default:
                System.out.println("您的输入有误，请重新输入！");
                oneMenu();
                break;
        }
    }
    //借阅菜单
    public void lookBookCnter(){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>");
        bookCnter.showBookCnter(bookCnters);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("1.借书");
        System.out.println("2.返回");
        System.out.print("请选择：");
        number=input.nextInt();
        switch (number){
            case 1:
                 borrow();
                break;
            case 2:
                oneMenu();
                break;
            default:
                System.out.println("您的输入有误，请重新输入");
                lookBookCnter();
                break;
        }
    }

    //借borrow
    public  void  borrow(){
        System.out.print("请输入编号：");
        number1=input.nextInt();
        //判断书库里面是否有此书
        for(int i1=0;i1<bookCnters.length;i1++){
            if(number1==bookCnters[i1].getBookNumber()){//有此类书
                boolean j=true;
                do{//库存不够循环输入借阅数目
                    System.out.print("请输入借阅的数目：");
                    number=input.nextInt();
                    if(number<=bookCnters[i1].getRepertory()){//满足库存
                        for(int i2=0;i2<personalCenters.length;i2++){//用来找是否借过
                            if(personalCenters[i2]==null){//为空则没借过
                                personalCenters[i2]=new PersonalCenter(bookCnters[i1].getBookNumber(),bookCnters[i1].getBookName(),number,bookCnters[i1].getRent(), bookCnters[i1].getRent()*number*2,new Date());
                                bookCnters[i1].setRepertory(bookCnters[i1].getRepertory()-number);
                                break;
                            }else if(personalCenters[i2].getBookNumber()==number1){//借过
                                personalCenters[i2].setRepertory(personalCenters[i2].getRepertory()+number);//借书数目
                                bookCnters[i1].setRepertory(bookCnters[i1].getRepertory()-number);//库存减少
                            }else{
                                continue;
                            }
                        }
                        System.out.println("借书成功!");
                       lookBookCnter();
                        j=false;
                    }else {
                        System.out.println("库存不够，请重新输入");
                    }
                }while (j);
            }
        }
        //无此类书
        System.out.println("书库里没有您想要的书哦！请重新输入");
        borrow();

    }


    //个人中心菜单
    public void lookPersonalCenter(){

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>");
        personalCenter.showPersonalCenter(personalCenters);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("1.还书");
        System.out.println("2.返回");
        System.out.print("请选择：");
        number=input.nextInt();
        switch (number){
            case 1:
                repay();
                break;
            case 2:
                oneMenu();
                break;
            default:
                System.out.println("您的输入有误，请重新输入");
                lookPersonalCenter();
                break;
        }
    }

    //还书
    public void repay(){
        System.out.print("请输入编号：");
        number1=input.nextInt();
        //判断借出列表里面是否有此书
        for(int i1=0;i1<personalCenters.length;i1++){
            if(number1==personalCenters[i1].getBookNumber()){//有此类书
                boolean j=true;
                do{//还书数目错误循环，输入还书数目
                    System.out.print("请输入还书的数目：");
                    number=input.nextInt();
                    if(number<=personalCenters[i1].getRepertory()){//满足借书数目
                        for(int i2=0;i2<bookCnters.length;i2++){
                            personalCenters[i1].setRepertory(personalCenters[i1].getRepertory()-number);//借书减少
                            bookCnters[i2].setRepertory(bookCnters[i2].getRepertory()+number);
                            break;
                        }
                        System.out.println("还书成功！");
                        lookPersonalCenter();
                        j=false;
                    }else {
                        System.out.println("超出借阅数目，请重新输入");
                    }
                }while (j);
            }
        }
        //无此类书
            System.out.println("书库里没有您想要的书哦！请重新输入");
            repay();


    }
}

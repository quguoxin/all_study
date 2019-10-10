package day09;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ComputerLeasing {
    private DateUtil dateUti;
    private Scanner input=new Scanner(System.in);
    private int number;
    private Computer computer;
    private RepayComputer repayComputer;
    private int day;//时间

    public void start() throws ParseException {
        System.out.println("********欢迎光临***********");
        repayComputer =new RepayComputer(0,0,0,"2018-05-15 12:33:33",0,0,0,0);
        computer=new Computer("Lenovo","Apple","Acer",100,200,100,10,10,10);
        //求时间day
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date time=simpleDateFormat.parse(repayComputer.getDate());
        dateUti =new DateUtil();
        day=dateUti.timeInterval(time,new Date());
        oneMenu();
    }


    ///////////////一级菜单//////////////////
    public void oneMenu(){
        System.out.println("电脑租赁系统");
        System.out.println("1.查看电脑列表");
        System.out.println("2.查看个人租赁信息");
        System.out.println("3.退出");
        System.out.print("请输入编号：");
        number=input.nextInt();
        switch (number){
            case 1:
                computerList();
                break;
            case 2:
                personalInformation();
                break;
            case 3:
                System.out.println("退出成功，欢迎下次使用！");
                break;
            default:
                System.out.println("您的输入有误，请重新输入");
                oneMenu();
                break;
        }
    }
    /////////////租赁电脑列表///////////////
    public void computerList(){
        System.out.println("可以租赁的电脑列表>>");
        System.out.println("设备编号\t名称\t\t价格(每日费用)\t库存数量");
        System.out.println("1\t\t"+computer.getName1()+"\t\t"+computer.getPrice1()+"\t\t\t"+computer.getAmount1());
        System.out.println("2\t\t"+computer.getName2()+"\t\t"+computer.getPrice2()+"\t\t\t"+computer.getAmount2());
        System.out.println("3\t\t"+computer.getName3()+"\t\t"+computer.getPrice3()+"\t\t\t"+computer.getAmount3());
        System.out.println("请选择租赁设备（输入0返回上一层）：");
        System.out.println("请输入编号：");
        number=input.nextInt();
        switch (number){
            case 0:
                oneMenu();
                break;
            case 1:
                System.out.println("请输入借出数量：");
                number=input.nextInt();
                if(number<=computer.getAmount1()){
                    repayComputer.setNumber1(repayComputer.getNumber1()+number);//借出数目
                    computer.setAmount1(computer.getAmount1()-number);//库存
                    repayComputer.setSubtotal1(repayComputer.getSubtotal1()+number*computer.getPrice1()*day);//小计
                    computerList();
                }else {
                    System.out.println("已经借完啦！");
                    computerList();
                }
                break;
            case 2:
                System.out.println("请输入借出数量：");
                number=input.nextInt();
                if(number<=computer.getAmount2()) {
                    repayComputer.setNumber2(repayComputer.getNumber2() + number);
                    computer.setAmount2(computer.getAmount2() - number);
                    repayComputer.setSubtotal2(repayComputer.getSubtotal2() + number * computer.getPrice2() * day);
                    computerList();
                }else {
                    System.out.println("已经借完啦！");
                    computerList();
                }
                break;
            case 3:
                System.out.println("请输入借出数量：");
                number=input.nextInt();
                if(number<=computer.getAmount3()) {
                    repayComputer.setNumber3(repayComputer.getNumber3() + number);
                    computer.setAmount3(computer.getAmount3() - number);
                    repayComputer.setSubtotal3(repayComputer.getSubtotal3() + number * computer.getPrice3() * day);
                    computerList();
                }else {
                    System.out.println("已经借完啦！");
                    computerList();
                }
                break;
            default:
                System.out.println("您的输入有误！请重新输入");
                computerList();
                break;
        }
    }
    ///////////////个人租赁信息//////////////////
    public void personalInformation(){
        repayComputer.setTotal(repayComputer.getSubtotal1()+repayComputer.getSubtotal2()+repayComputer.getSubtotal3());//总计
        System.out.println("个人租赁信息>>");
        System.out.println("设备编号\t名称\t\t价格(每日费用)\t借出数量\t\t借出时间\t\t\t\t小计费用");
        System.out.println("1.\t\t"+computer.getName1()+"\t"+computer.getPrice1()+"\t\t\t\t"+repayComputer.getNumber1()+"\t"+repayComputer.getDate()+"\t\t"+repayComputer.getSubtotal1());
        System.out.println("2.\t\t"+computer.getName2()+"\t"+computer.getPrice2()+"\t\t\t\t"+repayComputer.getNumber2()+"\t"+repayComputer.getDate()+"\t\t"+repayComputer.getSubtotal2());
        System.out.println("3.\t\t"+computer.getName3()+"\t"+computer.getPrice3()+"\t\t\t\t"+repayComputer.getNumber3()+"\t"+repayComputer.getDate()+"\t\t"+repayComputer.getSubtotal3());
        System.out.println("总计费用："+repayComputer.getTotal());
        System.out.println("请选择以上序号进行归还（输入0返回上一层）：");
        System.out.println("请输入编号：");
        number =input.nextInt();
        switch (number){
            case 0:
                oneMenu();
                break;
            case 1:
                System.out.println("请输入归还数量：");
                number=input.nextInt();
                if(number<=repayComputer.getNumber1()){
                   repayComputer.setNumber1(repayComputer.getNumber1()-number);
                   computer.setAmount1(computer.getAmount1()+number);
                    repayComputer.setSubtotal1(repayComputer.getSubtotal1()-number*computer.getPrice1()*day);
                    personalInformation();
                }else {
                    System.out.println("您归还数量已经超过借的，请重新输入");
                    personalInformation();
                }
                break;
            case 2:
                System.out.println("请输入归还数量：");
                number=input.nextInt();
                if(number<=repayComputer.getNumber2()){
                    repayComputer.setNumber2(repayComputer.getNumber2()-number);
                    computer.setAmount2(computer.getAmount2()+number);
                    repayComputer.setSubtotal2(repayComputer.getSubtotal2()-number*computer.getPrice2()*day);
                    personalInformation();
                }else {
                    System.out.println("您归还数量已经超过借的，请重新输入");
                    personalInformation();
                }
                break;
            case 3:
                System.out.println("请输入归还数量：");
                number=input.nextInt();
                if(number<=repayComputer.getNumber3()){
                    repayComputer.setNumber3(repayComputer.getNumber3()-number);
                    computer.setAmount3(computer.getAmount3()+number);
                    repayComputer.setSubtotal3(repayComputer.getSubtotal3()+number*computer.getPrice3()*day);
                    personalInformation();
                }else {
                    System.out.println("您归还数量已经超过借的，请重新输入");
                    personalInformation();
                }
                break;
            default:
                System.out.println("您的输入有误！请重新输入");
                personalInformation();
                break;
        }
    }
}

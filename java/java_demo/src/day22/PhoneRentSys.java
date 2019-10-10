package day22;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * 手机租赁系统类
 */
public class PhoneRentSys extends PhoneDao{


    //进去页面菜单
    public  void  oneMenu(){
        System.out.println("手机租赁管理系统");
        System.out.println("1.登录");
        System.out.println("2.退出");
        Scanner input =new Scanner(System.in);
        System.out.println("请选择：");
        int number=input.nextInt();
        switch (number){
            case 1:
                login();
                break;
            case 2:
                System.out.println("退出成功，欢迎下次光临！");
                System.exit(0);
                break;
            default:
                System.out.println("您的输入有误，请重新输入！");
                oneMenu();
                break;
        }

    }

    //登录判断
    public  void login(){
        Scanner input =new Scanner(System.in);
        System.out.println(">>>>>登录");
        System.out.println("请输入您的账号：");
        String id=input.next();
        System.out.println("请输入您的密码：");
        String password=input.next();
        if(id.equals("admin")&&password.equals("123")){
            twoMenu();
        }else {
            System.out.println("请您重新输入正确的账号密码！");
            login();
        }
    }

    //二级菜单
    public void twoMenu(){
        Scanner input =new Scanner(System.in);
        System.out.println("手机租赁管理系统");
        System.out.println("1.录入手机信息");
        System.out.println("2.修改手机信息");
        System.out.println("3.查询手机信息");
        System.out.println("4.删除手机信息");
        System.out.println("5.注销");
        System.out.println("请选择：");
        int number=input.nextInt();
        switch (number){
            case 1:
                addPhone();
                break;
            case 2:
                updatePhone();
                break;
            case 3:
                readPhone();
                break;
            case 4:
                deletePhone();
                break;
            case 5:
                System.out.println("注销成功！");
                System.exit(0);
                break;
            default:
                System.out.println("您的输入有误，请重新输入");
                twoMenu();
                break;
        }
    }

    //三级菜单  退出or返回
    public void threeMenu(){
        Scanner input =new Scanner(System.in);
        System.out.println("*****1.返回  ————  2.退出*****");
        System.out.println("请选择：");
        int number =input.nextInt();
        switch (number){
            case 1:
                twoMenu();
                break;
            case 2:
                System.out.println("退出成功！");
                System.exit(0);
                break;
            default:
                System.out.println("输入有误，请重新输入！");
                break;
        }
    }

    //增
    public void addPhone (){
        Scanner input=new Scanner(System.in);
        System.out.println("请输入录入的手机型号");
        String model=input.next();
        System.out.println("请输入录入手机的价格");
        double price=input.nextDouble();
        System.out.println("请输入手机的日租价格");
        double dayPrice=input.nextDouble();
        System.out.println("请输入库存数");
        int store=input.nextInt();
        if(judge(model)){
            System.out.println("型号已经存在，请重新输入");
            addPhone();
        }else {
            PhoneInf phoneInf=new PhoneInf(model,price,dayPrice,store);
            int number=super.add(phoneInf);
            if(number==1){
                System.out.println("增加成功！");
                threeMenu();
            }else {
                System.out.println("添加失败，请重新操作");
                threeMenu();
            }
        }
    }

    //修改
    public void updatePhone(){
        Scanner input=new Scanner(System.in);
        System.out.println("请输入您要修改的手机型号：");
        String model=input.next();
        System.out.println("请输入手机的新价格");
        double price=input.nextDouble();
        System.out.println("请输入手机的新日租价格");
        double dayPrice=input.nextDouble();
        System.out.println("请输入新库存数");
        int store=input.nextInt();
        if(judge(model)){
            PhoneInf phoneInf=new PhoneInf(model,price,dayPrice,store);
            int number =super.update(phoneInf);
            if(number==1){
                System.out.println("修改成功！");
                threeMenu();
            }else {
                System.out.println("修改失败，请重新输入");
                threeMenu();
            }
        }else {
            System.out.println("没有此类型号，重新输入");
            updatePhone();
        }

    }

    //查询
    public void readPhone(){
        Scanner input=new Scanner(System.in);
        System.out.println("请输入查询的手机型号：");
        String model=input.next();
        if(judge(model)){
            List list=super.read(model);
            Iterator<PhoneInf> it=list.iterator();
            while(it.hasNext()){
                PhoneInf phoneInf = it.next();
                System.out.println(phoneInf.toString());
            }
            threeMenu();
        }else {
            System.out.println("没有此类型号手机！请重新输入");
            readPhone();
        }

    }

    //删除
    public void deletePhone(){
        Scanner input=new Scanner(System.in);
        System.out.println("请输入需要删除的手机型号:");
        String model=input.next();
        if(judge(model)){
            int number=super.delete(model);
            if(number==1){
                System.out.println("删除成功！");
                threeMenu();
            }else {
                System.out.println("删除失败失败，请重新操作");
                threeMenu();
            }
        }else {
            System.out.println("没有此类手机！请重新输入");
            deletePhone();
        }


    }

    //判断表内数据是否存在或重复
    public Boolean judge(String model){
        ResultSet resultSet=null;
        try {
            Connection connection=getCon();
            String sql="SELECT * FROM `phone` WHERE `model`=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,model);
            resultSet= preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            //e.printStackTrace();
        }finally {
            super.closeAll(resultSet,preparedStatement,connection);
        }
        return false;
    }

}

package day21;

import java.sql.*;
import java.util.Scanner;

public class LCBank extends JdbcUtil implements BankService{
    //一级菜单，登录操作
    public void onemenu(){
        System.out.println("*********登录*********");
        Scanner input=new Scanner(System.in);
        System.out.println("请输入银行卡号：");
        String cardno=input.next();
        System.out.println("请输入密码：");
        String pwd=input.next();
        Boolean isok= login(cardno,pwd);
        if(isok){
            System.out.println("登录成功！");
            twomenu(cardno);
        }else{
            System.out.println("登录错误！请重新登录");
            onemenu();
        }
    }

    //二级菜单
    public void twomenu(String cardno){
        double money;
        int isok;
        System.out.println("1.存钱");
        System.out.println("2.取钱");
        System.out.println("3.转账");
        System.out.println("4.查询余额");
        System.out.println("5.退出");
        Scanner input=new Scanner(System.in);
        System.out.println("请选择业务：");
        int number =input.nextInt();
        switch (number){
            case 1:
                System.out.println("请输入您的存款金额：");
                money=input.nextDouble();
                isok=saveMoney(cardno,money);
                if(isok==1){
                    System.out.println("存款成功！存款金额："+money);
                    twomenu(cardno);
                }else {
                    System.out.println("存款失败，请重新操作！");
                    twomenu(cardno);
                }
                break;
            case 2:
                System.out.println("请输入您的取款金额：");
                money=input.nextDouble();
                isok=giveMoney(cardno,money);
                if(isok==1){
                    System.out.println("取款成功！取款金额："+money);
                    twomenu(cardno);
                }else {
                    System.out.println("取款失败，请重新操作！");
                    twomenu(cardno);
                }
                break;
            case 3:
                System.out.println("请输入对方银行卡号：");
                String to=input.next();
                System.out.println("请输入转账金额：");
                money=input.nextDouble();
                isok=transferMoney(cardno,to,money);
                if(isok==1){
                    System.out.println("转账成功！转账金额："+money);
                    twomenu(cardno);
                }else {
                    System.out.println("转账失败，请重新操作！");
                    twomenu(cardno);
                }
                break;
            case 4:
                showBalance(cardno);
                twomenu(cardno);
                break;
            case 5:
                System.out.println("退出成功！");
                System.exit(0);
            default:
                System.out.println("您的输入有误，请重新操作");
                twomenu(cardno);
                break;
        }
    }


    //登录
    @Override
    public boolean login(String cardno, String pwd) {
        /*ResultSet resultSet=null;
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        connection=super.getCon();
        try {
            String sqlString="SELECT * FROM `account` WHERE `cardno`=?  AND `pwd`=?";
            preparedStatement=connection.prepareStatement(sqlString);
            preparedStatement.setString(1,cardno);
            preparedStatement.setString(2,pwd);
            resultSet=preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            //e.printStackTrace();
        }finally {
            closeAll(resultSet,preparedStatement,connection);
        }
        return false;*/
        Object[] params={cardno,pwd};
        String sql="SELECT * FROM `account` WHERE `cardno`=?  AND `pwd`=?";
        ResultSet resultSet= super.commonQuery(sql,params);
        try {
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            super.closeAll(resultSet,null,null);
        }
        return false;
    }

    //1.存钱
    @Override
    public int saveMoney(String cardno, double money) {
        /*ResultSet resultSet=null;
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        int num=0;
        connection=getCon();
        try {
            //获取余额
            String sqlString="SELECT * FROM `account` WHERE `cardno`=?";
            preparedStatement=connection.prepareStatement(sqlString);
            preparedStatement.setString(1,cardno);
            resultSet=preparedStatement.executeQuery();
            resultSet.next();
            double balance=resultSet.getDouble("balance");
            //在余额的基础上增加余额
            sqlString="UPDATE `account` SET `balance`=? WHERE `cardno`=?";
            preparedStatement=connection.prepareStatement(sqlString);
            preparedStatement.setDouble(1,balance+money);
            preparedStatement.setString(2,cardno);
            num=preparedStatement.executeUpdate();
            if(num!=1){
                return 0;
            }
        } catch (SQLException e) {
            //e.printStackTrace();
        }finally {
            closeAll(resultSet,preparedStatement,connection);
        }
        return 1;*/
        String sql="UPDATE `account` SET `balance`=balance+? WHERE `cardno`=?";
        Object[] params={money,cardno};
        return super.commonUpdate(sql,params);
    }

    //2.取钱
    @Override
    public int giveMoney(String cardno, double money) {
       /* ResultSet resultSet=null;
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        int num=0;
        connection=getCon();
        try {
            //获取余额
            String sqlString="SELECT * FROM `account` WHERE `cardno`=?";
            preparedStatement=connection.prepareStatement(sqlString);
            preparedStatement.setString(1,cardno);
            resultSet=preparedStatement.executeQuery();
            resultSet.next();
            double balance=resultSet.getDouble("balance");
            if(balance<money){
                System.out.println("您的余额为："+balance+",请重新输入取款金额");
                twomenu(cardno);
            }
            //在余额的基础上减少余额
            sqlString="UPDATE `account` SET `balance`=? WHERE `cardno`=?";
            preparedStatement=connection.prepareStatement(sqlString);
            preparedStatement.setDouble(1,balance-money);
            preparedStatement.setString(2,cardno);
            num=preparedStatement.executeUpdate();
            if(num!=1){
                return 0;
            }
        } catch (SQLException e) {
            //e.printStackTrace();
        }finally {
            closeAll(resultSet,preparedStatement,connection);
        }
        return 1;*/
       String sql="UPDATE `account` SET `balance`=balance-? WHERE `cardno`=?";
       Object[] params={money,cardno};
       return super.commonUpdate(sql,params);
    }

    //3.转账
    @Override
    public int transferMoney(String cardno, String to, double money) {
        /*ResultSet resultSet=null;
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        int num1=0;
        int num2=0;
        connection=getCon();
        try {
            //获取余额A
            String sqlString="SELECT * FROM `account` WHERE `cardno`=?";
            preparedStatement=connection.prepareStatement(sqlString);
            preparedStatement.setString(1,cardno);
            resultSet=preparedStatement.executeQuery();
            resultSet.next();
            double balance1=resultSet.getDouble("balance");
            if(balance1<money){
                System.out.println("您的余额为："+balance1+",请重新输入转账金额");
                twomenu(cardno);
            }
            //获取余额B
            sqlString="SELECT * FROM `account` WHERE `cardno`=?";
            preparedStatement=connection.prepareStatement(sqlString);
            preparedStatement.setString(1,to);
            resultSet=preparedStatement.executeQuery();
            if(!resultSet.next()){
                System.out.println("卡号输入错误，请重新操作");
                twomenu(cardno);
            }
            double balance2=resultSet.getDouble("balance");
            //在A余额的基础上减少余额
            sqlString="UPDATE `account` SET `balance`=? WHERE `cardno`=?";
            preparedStatement=connection.prepareStatement(sqlString);
            preparedStatement.setDouble(1,balance1-money);
            preparedStatement.setString(2,cardno);
            num1=preparedStatement.executeUpdate();
            if(num1!=1){
                return 0;
            }
            //在B余额的基础上增加余额
            sqlString="UPDATE `account` SET `balance`=? WHERE `cardno`=?";
            preparedStatement=connection.prepareStatement(sqlString);
            preparedStatement.setDouble(1,balance2+money);
            preparedStatement.setString(2,to);
            num2=preparedStatement.executeUpdate();
            if(num2!=1){
                return 0;
            }
        } catch (SQLException e) {
            //e.printStackTrace();
        }finally {
            closeAll(resultSet,preparedStatement,connection);
        }
        return 1;*/
        int num1=giveMoney(cardno,money);
        int num2=saveMoney(to,money);
        if(num1==1&&num2==1){
            return 1;
        }
        return -1;
    }

    //4.查询余额
    @Override
    public void showBalance(String cardno) {
       /* ResultSet resultSet=null;
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        connection=getCon();
        try {
            String sqlString="SELECT * FROM `account` WHERE `cardno`=?";
            preparedStatement=connection.prepareStatement(sqlString);
            preparedStatement.setString(1,cardno);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                double balance=resultSet.getDouble("balance");
                System.out.println("您的余额为："+balance);
            }
        } catch (SQLException e) {
           // e.printStackTrace();
        }finally {
            closeAll(resultSet,preparedStatement,connection);
        }*/
        String sql="SELECT * FROM `account` WHERE `cardno`=?";
        Object[] params={cardno};
        ResultSet resultSet=super.commonQuery(sql,params);
        try {
            if(resultSet.next()){
                double balance=resultSet.getDouble("balance");
                System.out.println("您的余额为："+balance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //启动方法
    public static void main(String[] args) {
        LCBank lcBank=new LCBank();
        lcBank.onemenu();
    }
}

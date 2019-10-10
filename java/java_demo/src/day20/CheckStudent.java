package day20;

import java.sql.*;
import java.util.Scanner;

public class CheckStudent {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //创建连接对象
            //协议://主机:端口号/数据库名
            String url="jdbc:mysql://localhost:3306/demooo";
            String user="root";
            String password="1234";
            Connection connection = DriverManager.getConnection(url,user,password);
            //创建sql对象
            Statement statement=connection.createStatement();
            System.out.println("请选择您要输入的类型：");
            System.out.println("a：准考证号");
            System.out.println("b：身份证号");
            Scanner input=new Scanner(System.in);
            String ab=input.next();
            String sqlString="";
            switch (ab){
                case "a":
                    System.out.println("请输入准考证：");
                    String examCard=input.next();
                    sqlString=sqlString+"SELECT * FROM `examstudent` WHERE `ExamCard`="+examCard;
                    break;
                case "b":
                    System.out.println("请输入身份证：");
                    String idCard=input.next();
                    sqlString=sqlString+"SELECT * FROM `examstudent` WHERE `IdCard`="+idCard;
                    break;
                default:
                    System.out.println("输入有误！请重新启动");
                    break;
            }
            ResultSet resultSet=statement.executeQuery(sqlString);
            //读取结果集中的数据
            while (resultSet.next()){
                int flowId=resultSet.getInt("FlowId");
                int type=resultSet.getInt("Type");
                String idCard=resultSet.getString("IdCard");
                String examCard=resultSet.getString("ExamCard");
                String studentName=resultSet.getString("StudentName");
                String location=resultSet.getString("Location");
                int grade=resultSet.getInt("Grade");
                System.out.println(flowId+"-"+type+"-"+idCard+"-"+examCard+"-"+studentName+"-"+location+"-"+grade);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

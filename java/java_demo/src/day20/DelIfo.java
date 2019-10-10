package day20;

import java.sql.*;
import java.util.Scanner;

public class DelIfo {
    public static void main(String[] args) {
        ResultSet resultSet=null;
        String sqlString;
        String examCard;
        Scanner input=new Scanner(System.in);
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

            boolean isok=false;
            System.out.println("请输入学生的考号：");
            do {
                examCard=input.next();
                sqlString="SELECT * FROM `examstudent` WHERE `ExamCard`='"+examCard+"'";
                resultSet=statement.executeQuery(sqlString);
                isok=resultSet.next();
                if(!isok){
                    System.out.println("输入有误请重新输入");
                }
            }while (!isok);

            sqlString="DELETE  FROM `examstudent` WHERE `ExamCard`='"+examCard+"'";
            int num=statement.executeUpdate(sqlString);

            sqlString="SELECT * FROM `examstudent` WHERE `ExamCard`='"+examCard+"'";
            resultSet=statement.executeQuery(sqlString);
            if(!resultSet.next()){
                System.out.println("删除成功！");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

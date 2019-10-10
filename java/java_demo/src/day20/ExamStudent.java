package day20;

import java.sql.*;
import java.util.Scanner;

public class ExamStudent {
    public static void main(String[] args) {
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
            //创建表
            String sqlString="CREATE TABLE IF NOT EXISTS  examstudent(\n" +
                    "FlowId INT AUTO_INCREMENT PRIMARY KEY COMMENT '流水号',\n" +
                    "`Type` INT COMMENT '四级/六级',\n" +
                    "IdCard VARCHAR(18) UNIQUE COMMENT '身份证号码',\n" +
                    "ExamCard VARCHAR(15) UNIQUE COMMENT '准考证号码',\n" +
                    "StudentName VARCHAR(20) COMMENT '学生姓名',\n" +
                    "Location VARCHAR(20) COMMENT '区域',\n" +
                    "Grade INT COMMENT '成绩'\n" +
                    ")COMMENT '英语等级考试表' ENGINE = INNODB CHARSET =utf8";
            int num=statement.executeUpdate(sqlString);
            //添加数据
            String sqlString1="INSERT INTO `examstudent` (`Type`,`IdCard`,`ExamCard`,`StudentName`,`Location`,`Grade`) \n" +
                    "VALUES (4,'412824195263214584','200523164754000','张锋','郑州',85),\n" +
                    "(4,'222224195263214584','200523164754001','孙鹏','大连',56),\n" +
                    "(6,'342824195263214584','200523164754002','刘明','沈阳',72),\n" +
                    "(6,'100824195263214584','200523164754003','赵虎','哈尔滨',95),\n" +
                    "(4,'454524195263214584','200523164754004','杨丽','北京',64),\n" +
                    "(4,'854524195263214584','200523164754005','王小红','太原',60)";
            int num1=statement.executeUpdate(sqlString1);
            //插入新同学信息
            System.out.println("请输入考生的详细信息：");
            System.out.println("Type(4/6级)：");
            int type=input.nextInt();
            System.out.println("IdCard(身份证)：");
            String idCard=input.next();
            System.out.println("ExamCard(准考证)：");
            String examCard=input.next();
            System.out.println("StudentName(姓名)：");
            String studentName=input.next();
            System.out.println("Location(区域)：");
            String location=input.next();
            System.out.println("Grade(成绩)：");
            int grade=input.nextInt();
            String sqlString2="INSERT INTO `examstudent` (`Type`,`IdCard`,`ExamCard`,`StudentName`,`Location`,`Grade`) \n" +
                    "VALUES ("+type+",'"+idCard+"','"+examCard+"','"+studentName+"','"+location+"',"+grade+")";
            int num2=statement.executeUpdate(sqlString2);

            String sqlString3="SELECT * FROM `examstudent` WHERE `IdCard`="+idCard;
            ResultSet resultSet=statement.executeQuery(sqlString3);
            if(resultSet.next()){
               System.out.println("信息录入成功！");
            }else {
                System.out.println("录入失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

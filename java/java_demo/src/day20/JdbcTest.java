package day20;

import day16.Student;

import java.sql.*;
import java.util.Scanner;

public class JdbcTest {
    //建立连接
    public Connection getCon(){
        Connection connection=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //创建连接对象
            //协议://主机:端口号/数据库名
            String url="jdbc:mysql://localhost:3306/demooo";
            String user="root";
            String password="1234";
            connection = DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    //释放
    public  void closeAll(ResultSet resultSet, Statement statement,Connection connection){
        try {
            if(resultSet!=null){
                resultSet.close();
            }
            if(statement!=null){
                statement.close();
            }
            if(connection!=null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //增加
    public int add(Connection connection){
        Scanner input=new Scanner(System.in);
        Statement statement=null;
        int num=0;
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
        try {
            statement=connection.createStatement();
            String sqlString2="INSERT INTO `examstudent` (`Type`,`IdCard`,`ExamCard`,`StudentName`,`Location`,`Grade`) \n" +
                    "VALUES ("+type+",'"+idCard+"','"+examCard+"','"+studentName+"','"+location+"',"+grade+")";
            num=statement.executeUpdate(sqlString2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }
    //删
    public int delete(Connection connection){
        ResultSet resultSet=null;
        Statement statement=null;
        Scanner input=new Scanner(System.in);
        String sqlString;
        String examCard;
        int num=0;
        boolean isok=false;
        try {
            statement=connection.createStatement();
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
            num=statement.executeUpdate(sqlString);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }
    //查
    public void findAll(Connection connection){
        Statement statement;
        try {
            //创建sql对象
            statement=connection.createStatement();
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
                    findAll(connection);
                    break;
            }
            ResultSet resultSet=statement.executeQuery(sqlString);
            if(resultSet.next()==true){
                //读取结果集中的数据
                //while (resultSet.next()){
                    int flowId=resultSet.getInt("FlowId");
                    int type=resultSet.getInt("Type");
                    String idCard=resultSet.getString("IdCard");
                    String examCard=resultSet.getString("ExamCard");
                    String studentName=resultSet.getString("StudentName");
                    String location=resultSet.getString("Location");
                    int grade=resultSet.getInt("Grade");
                    System.out.println(flowId+"-"+type+"-"+idCard+"-"+examCard+"-"+studentName+"-"+location+"-"+grade);
                //}
            }else {
                System.out.println("查无此人");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        int num;
        Scanner input =new Scanner(System.in);
        JdbcTest jdbcTest=new JdbcTest();
        Connection connection=jdbcTest.getCon();
        System.out.println("1.增加学生信息");
        System.out.println("2.删除学生信息");
        System.out.println("3.查询学生信息");
        System.out.println("请输入：");
        int number=input.nextInt();
        switch (number){
            case 1:
                num=jdbcTest.add(connection);
                if(num>0){
                    System.out.println("增加成功");
                }
                break;
            case 2:
               num=jdbcTest.delete(connection);
                if(num>0){
                    System.out.println("删除成功");

                }
                break;
            case 3:
                jdbcTest.findAll(connection);
                break;
            default:
                System.out.println("您的输入有误!");
                break;
        }
        jdbcTest.closeAll(null,null,connection);

    }
}

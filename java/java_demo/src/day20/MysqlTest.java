package day20;


import java.sql.*;

public class MysqlTest {
    public static void main(String[] args) {
        try {
            //在代码中加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
            //创建连接对象
            //协议://主机:端口号/数据库名
            String url="jdbc:mysql://localhost:3306/shop";
            String user="root";
            String password="1234";
            Connection connection = DriverManager.getConnection(url,user,password);
            //System.out.println( connection); //输出连接成功的地址

            //创建执行sql的对象
            Statement statement=connection.createStatement();
            //发送sql语句
            //增 删 改用executeUpdate() 方法
            //增 String sqlString="INSERT INTO `bank` (`name`,`cash`) VALUES('C',250.00)";
            //删 String sqlString="DELETE FROM `bank` WHERE `id`=3";
            //改
            String sqlString="UPDATE `bank` SET `cash`=520.00 WHERE `id`=3";
            int num=statement.executeUpdate(sqlString);
            //System.out.println("影响行数："+num);


            // 查询用executeQuery
            String sqlString1="SELECT * FROM `bank`";
            ResultSet resultSet=statement.executeQuery(sqlString1);
            //读取结果集中的数据
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                int cash=resultSet.getInt("cash");
                System.out.println(id+"--"+name+"--"+cash);
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

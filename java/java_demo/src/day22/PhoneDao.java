package day22;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据库的增删改查类
 */
public class PhoneDao {
    public  ResultSet resultSet=null;
    public  Connection connection=null;
    public  PreparedStatement preparedStatement=null;
    //开连接
    public Connection getCon(){
        Connection connection=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/demooo";
            String user="root";
            String password="1234";
            connection=DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException e) {
            //e.printStackTrace();
        } catch (SQLException e) {
            //e.printStackTrace();
        }
        return  connection;
    }

    //关连接
    public void closeAll(ResultSet resultSet, Statement statement,Connection connection){
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
            //e.printStackTrace();
        }
    }


    //增
    public int add(PhoneInf phoneInf){
        try {
            connection=getCon();
            String sql="INSERT INTO `phone` (`model`,`price`,`dayPrice`,`store`) " +
                    "VALUES (?,?,?,?)";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,phoneInf.getModel());
            preparedStatement.setDouble(2,phoneInf.getPrice());
            preparedStatement.setDouble(3,phoneInf.getDayPrice());
            preparedStatement.setInt(4,phoneInf.getStore());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            //e.printStackTrace();
        }finally {
            closeAll(null,preparedStatement,connection);
        }
        return -1;
    }

    //改
    public int update(PhoneInf phoneInf){
        try {
            connection=getCon();
            String sql="UPDATE `phone` SET `price`=?, `dayPrice`=?,  " +
                       " `store`=? WHERE `model`=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setDouble(1,phoneInf.getPrice());
            preparedStatement.setDouble(2,phoneInf.getDayPrice());
            preparedStatement.setInt(3,phoneInf.getStore());
            preparedStatement.setString(4,phoneInf.getModel());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            //e.printStackTrace();
        }finally {
            closeAll(null,preparedStatement,connection);
        }
        return  -1;
    }

    //删
    public int delete(String model){
        try {
            connection=getCon();
            String sql="DELETE FROM `phone` WHERE `model`=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,model);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
           // e.printStackTrace();
        }finally {
            closeAll(null,preparedStatement,connection);
        }
        return -1;
    }

    //查询
    public List<PhoneInf> read(String model){
        List<PhoneInf> list=new ArrayList<PhoneInf>();
        try {
            connection=getCon();
            String sql="SELECT * FROM `phone` WHERE `model`=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,model);
            resultSet= preparedStatement.executeQuery();
            if(resultSet.next()){
                String model1=resultSet.getString("model");
                double price=resultSet.getDouble("price");
                double dayPrice=resultSet.getDouble("dayPrice");
                int store=resultSet.getInt("store");
                PhoneInf phoneInf=new PhoneInf(model1,price,dayPrice,store);
                list.add(phoneInf);
            }
            return list;
        } catch (SQLException e) {
           // e.printStackTrace();
        }finally {
            closeAll(resultSet,preparedStatement,connection);
        }
        return null;
    }
}

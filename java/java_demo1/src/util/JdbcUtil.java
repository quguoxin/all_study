package util;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.*;

public class JdbcUtil {
    public  ResultSet resultSet=null;
    public  Connection connection=null;
    public  PreparedStatement preparedStatement=null;
    public static BasicDataSource dataSource=null;

    static {
        //创建数据源
        dataSource =new BasicDataSource();
        //设置属性值
        //常规四项
        String url="jdbc:oracle:thin:@localhost:1521:orcl";
        String user="quguoxin";
        String password="1234";
        String driverClass = "oracle.jdbc.driver.OracleDriver";

        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClass);

        //附加：初始数量，最大数量，闲置数量，等待时间（ms）
        dataSource.setInitialSize(5);
        dataSource.setMaxActive(20);
        dataSource.setMaxIdle(2);
        dataSource.setMaxWait(30000);
    }

    /**
     * 开连接2
     * @return
     */
    public Connection getCon2(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 开连接1
     * String url="jdbc:mysql://localhost:3306/demooo";String user="root";String password="1234";
     * @return
     */
    public Connection getCon1(){
        Connection connection=null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //创建连接对象
            //协议://主机:端口号/数据库名
            String url="jdbc:oracle:thin:@localhost:1521:orcl";
            String user="quguoxin";
            String password="1234";
            connection = DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException e) {
            //e.printStackTrace();
        } catch (SQLException e) {
            //e.printStackTrace();
        }
        return connection;
    }

    /**
     * 选择开了连接的种类
     * @return
     */
    public Connection getCon(){
        return getCon2();
    }

    /**
     * 关连接
     * @param resultSet
     * @param statement
     * @param connection
     */
    public  void closeAll(ResultSet resultSet, Statement statement, Connection connection){
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

    /**
     * 通用增删改
     * @param sql
     * @param params 数组中的数据要和sql中的占位符一一对应
     * @return
     */
    public int commonUpdate(String sql,Object[] params){
        try {
            //获取连接对象
            connection=getCon();
            //编写sql语句 执行语句
            preparedStatement=connection.prepareStatement(sql);
            for(int i=0;i<params.length;i++){
                preparedStatement.setObject(i+1,params[i]);
            }
            //处理结果
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(resultSet,preparedStatement,connection);
        }
        return -1;
    }

    /**
     * 通用查询  谁调用谁释放资源
     * @param sql
     * @param params 数组中的数据要和sql中的占位符一一对应
     * @return
     */
    public ResultSet commonQuery(String sql,Object[] params){
        try {
            //获取连接
            connection=getCon();
            //执行sql语句
            preparedStatement=connection.prepareStatement(sql);
            //给语句参数赋值
            for(int i=0;i<params.length;i++){
                preparedStatement.setObject(i+1,params[i]);
            }
            //处理结果 返回ResultSet结果集
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}

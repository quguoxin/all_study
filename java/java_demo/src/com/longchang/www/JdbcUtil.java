package com.longchang.www;

import java.sql.*;

/**
 * 通用的jdbc连接工具
 */
public class JdbcUtil {
    public ResultSet resultSet = null;
    public Connection connection = null;
    public PreparedStatement ps = null;

    //开连接
    public Connection getCon() {
        Connection connection = null;
        try {
            //在代码中加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
            //创建连接对象Connection
            //协议://主机:端口号/数据库名
            String url = "jdbc:mysql://localhost:3306/demo";
            String user = "root";
            String password = "1234";
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    //释放资源的
    public void closeAll(ResultSet resultSet, Statement statement, Connection connection) {
        //结果集 ，statement,connection关闭顺序是先开的后关
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通用的增删改
     *
     * @param sql
     * @param params 数组中的数据必须要和sql中的占位符一一对应
     * @return
     */
    public int commonUpdate(String sql, Object[] params) {
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            //获取连接对象
            connection = getCon();
            //编写sql
            // 执行sql
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
            //处理结果
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            closeAll(resultSet, ps, connection);
        }
        return -1;
    }

    /**
     * 通用查询,谁调用谁释放资源
     * @param sql
     * @param params 数组中的数据必须要和sql中的占位符一一对应
     * @return
     */
    public ResultSet commonQuery(String sql, Object[] params) {
        try {
            //获取连接对象
            connection = getCon();
            // 执行sql
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
            //处理结果
            return ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}

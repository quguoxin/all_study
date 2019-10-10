package com.qgx.www.my_test;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Check {
    public static void main(String[] args) {
        //创建数据源
        BasicDataSource dataSource =new BasicDataSource();
        //设置属性值
        //常规四项
        String url="127.0.0.1:1521:orcl";
        /*String url = "jdbc:mysql://localhost:3306/yiguo";*/
        String user="C##comtop";
        String password="comtop";
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
        Connection connection=null;
        try {
            //获取连接
            connection = dataSource.getConnection();
            //sql
            String sql="select * from S where SD='生物制药'";
            QueryRunner qu = new QueryRunner();
            List<S> list = new ArrayList<S>();
            list = qu.query(connection, sql, new BeanListHandler<S>(S.class));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            DbUtils.closeQuietly(connection);
        }

    }
}

package com.qgx.www.util;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tony on 2018/7/13.
 */
public class DBUtils {
    //工具类；
    public final static String DRIVERCLASS = "com.mysql.jdbc.Driver";
    //public final static String URL = "jdbc:mysql://localhost:3306/yb?useUnicode=true&characterEncoding=utf8";
    public final static String URL = "jdbc:mysql://localhost:3306/struts2";
    public final static String USERNAME = "root";
    public final static String PWD = "1234";


    //1.创建一个数据源对象datasource
    public  static BasicDataSource dataSource = null;

    static {
        dataSource = new BasicDataSource();
        //2.设置基本的连接属性:驱动字符串,url,用户名,密码
        dataSource.setDriverClassName(DRIVERCLASS);
        dataSource.setUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PWD);
        //3.设置创建的连接池配置:最大活动数量,
        dataSource.setInitialSize(20);  //初始化数
        dataSource.setMaxIdle(10);     //最大闲置数量,
        dataSource.setMaxWait(10000); //等待时间:毫秒
    }

    //得到连接；
    public static Connection getConnection(){
        try {
            return  dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    //数据库的操作实际上只有两件事情：
    // 1，查询 （查询一条；select one, select list）；
    // 2，更新 （add,delete,update）；


    //1，查询 （查询一条数据）
    public  <T> T getOne(Class<T> clazz, String sql, Object ... params){
        T obj = null;
        QueryRunner qu = new QueryRunner();
        Connection con =  null;
        try {
            con = getConnection();
            obj = qu.query(con, sql, new BeanHandler<T>(clazz), params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            DbUtils.closeQuietly(con);
        }
        return obj;
    }

    //查询统计数量
    public int getCount(String sql, Object ... params){
        int obj = 0;
        QueryRunner qu = new QueryRunner();
        Connection con =  null;
        try {
            con = getConnection();
            obj =Integer.parseInt(qu.query(con, sql, new ScalarHandler("totalCount"), params).toString());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            DbUtils.closeQuietly(con);
        }
        return obj;
    }
    //第一行某列的数据并转成实际对象
    public  <T> T getColumnValue(String columnName, String sql, Object ... params){
        T obj = null;
        QueryRunner qu = new QueryRunner();
        Connection con =  null;
        try {
            con = getConnection();
            obj = qu.query(con, sql, new ScalarHandler<T>(columnName), params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            DbUtils.closeQuietly(con);
        }
        return obj;
    }
	
	//查询多条数据
    public  <T>List<T> getAll(Class<T> clazz, String sql, Object ... params){
        List<T> list = new ArrayList<>();
        QueryRunner qu = new QueryRunner();
        Connection con =  null;
        try {
            con = getConnection();
            list = qu.query(con, sql, new BeanListHandler<>(clazz), params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            DbUtils.closeQuietly(con);
        }
        return list;
    }


    //2.更新（insert ,update,delete）
    public  int update(String sql, Object ... params){
        QueryRunner qr = new QueryRunner();
        Connection con =  null;
        int n = 0;
        try {
            con = getConnection();
            n = qr.update(con, sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            DbUtils.closeQuietly(con);
        }
        return n;
    }


}

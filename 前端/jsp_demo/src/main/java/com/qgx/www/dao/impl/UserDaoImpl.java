package com.qgx.www.dao.impl;

import com.qgx.www.dao.UserDao;
import com.qgx.www.entity.Userinfo;
import com.qgx.www.util.JdbcUtil;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends JdbcUtil implements UserDao{
    //增加
    @Override
    public int add(Userinfo userinfo) {
        Connection connection=super.getCon2();
        String sql="INSERT INTO userinfo(username,PASSWORD,phone,inviteCode) VALUES (?,?,?,?)";
        QueryRunner queryRunner=new QueryRunner();
        Object[] params={userinfo.getUsername(),userinfo.getPassword(),userinfo.getUsername(),userinfo.getInviteCode()};
        try {
            int n = queryRunner.update(connection,sql,params);
            return n;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    //查询
    @Override
    public Userinfo findByUsernameAndPassword(String username, String password) {

        Connection connection=super.getCon2();
        String sql="select * from userinfo where phone=? and password=?";
        QueryRunner queryRunner=new QueryRunner();
        try {
            Userinfo userinfo= queryRunner.query(connection,sql,new BeanHandler<Userinfo>(Userinfo.class),username,password);
            return userinfo;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }

    @Override
    public List<Userinfo> findAll() {
        Connection connection=super.getCon2();
        String sql="select * from userinfo";
        QueryRunner queryRunner=new QueryRunner();
        List<Userinfo> list=new ArrayList<Userinfo>();
        try {
             list=queryRunner.query(connection,sql,new BeanListHandler<Userinfo>(Userinfo.class));
             return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Userinfo> getNumByPhone(String phone) {
        Connection connection=super.getCon2();
        String sql="SELECT * FROM userinfo WHERE phone=?";
        QueryRunner queryRunner=new QueryRunner();
        try {
            List<Userinfo> list= queryRunner.query(connection,sql,new BeanListHandler<Userinfo>(Userinfo.class),phone);
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Userinfo findUserinfoDetail(String phone) {
        Connection connection=super.getCon2();
        String sql="SELECT * FROM userinfo WHERE phone=?";
        QueryRunner queryRunner=new QueryRunner();
        try {
            Userinfo userinfo= queryRunner.query(connection,sql,new BeanHandler<Userinfo>(Userinfo.class),phone);
            int a=0;
            return userinfo;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int updateRmbBlance(String phone, double money) {
        Connection connection=super.getCon2();
        String sql="UPDATE userinfo SET rmb_balance=? WHERE phone=?;";
        QueryRunner queryRunner=new QueryRunner();
        try {
            int n = queryRunner.update(connection,sql,money,phone);
            return n;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    //查询all
}

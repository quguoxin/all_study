package com.qgx.www.dao.impl;

import com.qgx.www.dao.UserInfoDao;
import com.qgx.www.util.DBUtils;

import java.sql.Connection;

public class UserInfoDaoImpl extends DBUtils implements UserInfoDao {
    public int update(String username,String sex,int age,String phone){
        Connection connection = super.getConnection();
        String sql="UPDATE userinfo SET username=?,sex=?,age=? WHERE phone=?";
        int a=0;

        return super.update(sql,username,sex,age,phone);
    }
}

package com.qgx.www.service.impl;

import com.qgx.www.dao.UserDao;
import com.qgx.www.dao.UserInfoDao;
import com.qgx.www.dao.impl.UserDaoImpl;
import com.qgx.www.dao.impl.UserInfoDaoImpl;
import com.qgx.www.entity.Userinfo;
import com.qgx.www.service.UserinfoService;

import java.util.ArrayList;
import java.util.List;

public class UserinfoServiceImpl implements UserinfoService {
    //登录
    @Override
    public boolean login(String username, String password) {
        UserDaoImpl userDaoImpl=new UserDaoImpl();
        Userinfo userinfo= userDaoImpl.findByUsernameAndPassword(username,password);
        if(userinfo!=null){
            return true;
        }
        return false;
    }

    //注册
    @Override
    public boolean register(Userinfo userinfo) {
        UserDao userDao=new UserDaoImpl();
        int a= userDao.add(userinfo);
        if(a==1){
            return true;
        }
        return false;
    }

    @Override
    public Userinfo findUserinfoDetail(String phone) {
        UserDao userDao=new UserDaoImpl();
        return userDao.findUserinfoDetail(phone);
    }

    @Override
    public List<Userinfo> findAll() {
        UserDao userDao=new UserDaoImpl();
        return userDao.findAll();
    }

    @Override
    public boolean checkPhone(String phone) {
        UserDao userDao=new UserDaoImpl();
        List<Userinfo>list=userDao.getNumByPhone(phone);
        if(list.size()==0){
            return false;
        }
        return true;
    }

    @Override
    public int updateRmbBlance(String phone, double money) {
        UserDao userDao=new UserDaoImpl();
        return userDao.updateRmbBlance(phone,money);
    }

    @Override
    public int update(String username, String sex, int age, String phone) {
        UserInfoDao userInfoDao=new UserInfoDaoImpl();
        return userInfoDao.update(username,sex,age,phone);
    }
}

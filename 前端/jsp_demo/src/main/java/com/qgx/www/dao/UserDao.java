package com.qgx.www.dao;

import com.qgx.www.entity.Userinfo;

import java.util.List;

public interface UserDao {
    //增
    public int add(Userinfo userinfo);
    //查
    //public Userinfo findById(int id);
    public Userinfo findByUsernameAndPassword(String username,String password);
    public List<Userinfo> findAll();

    //验证手机号：是否存在，查询手机号
    public List<Userinfo> getNumByPhone(String phone);

    //查询用户详情
    public Userinfo findUserinfoDetail(String phone);

    //修改用户余额
    public int updateRmbBlance(String phone,double money);
}

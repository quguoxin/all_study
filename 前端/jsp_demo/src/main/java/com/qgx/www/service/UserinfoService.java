package com.qgx.www.service;

import com.qgx.www.entity.Userinfo;

import java.util.List;

public interface UserinfoService {
    //验证登录
    public boolean login(String username,String password);
    //注册
    public boolean register(Userinfo userinfo);
    //查询用户详情
    public Userinfo findUserinfoDetail(String phone);
    //查询所有用户
    public List<Userinfo>  findAll();

    public boolean checkPhone(String phone);

    //修改用户余额
    public int updateRmbBlance(String phone, double money);

    //zl
    public int update(String username,String sex,int age,String phone);

}

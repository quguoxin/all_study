package com.qgx.www.dao.impl;

import com.qgx.www.dao.UserInfoDao;
import com.qgx.www.ioc.UserInfo;
import org.springframework.stereotype.Repository;

@Repository //类似于在spring配置文中做了bean配置  代表的是数据访问层且被spring管理
public class UserInfoDaoImpl implements UserInfoDao {
    @Override
    public UserInfo getUserInfo(int id) {
        return new UserInfo(id,"刘德华","男");
    }
}

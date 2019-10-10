package com.qgx.www.service.impl;

import com.qgx.www.dao.UserInfoDao;
import com.qgx.www.ioc.UserInfo;
import com.qgx.www.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //代表是业务层 且被spring管理
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired // 等价于为接口对象提供了set插槽，进行对象的注入
    private UserInfoDao userInfoDao;

    @Override
    public UserInfo getUserInfo(int id) {
        System.out.println("111");
        return userInfoDao.getUserInfo(id);
    }

    @Override
    public int save(UserInfo userInfo) {
        return 10;
    }
}

package com.qgx.www.service;

import com.qgx.www.ioc.UserInfo;

public interface UserInfoService {
    public UserInfo getUserInfo(int id);

    public int save(UserInfo userInfo);
}
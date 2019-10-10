package com.qgx.www.dao;

import com.qgx.www.entity.Userinfo;
import com.qgx.www.entity.YouBi;


import java.util.List;

public interface YouBiDao {
    //分页
    public List<YouBi> findListByPage(int pageNo, int pageSize);
    //数量
    int findCount();

    //获取余额
    public Userinfo findYbBalance(String phone);
}

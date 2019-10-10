package com.qgx.www.service;

import com.qgx.www.entity.Userinfo;
import com.qgx.www.entity.YouBi;


import java.util.List;

public interface YouBiService {
    public List<YouBi> findListByPage(int pageNo, int pageSize);
    int findCount();
//获取悠币余额
    public Userinfo findYbBalance(String phone);
}

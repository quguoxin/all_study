package com.qgx.www.dao;

import com.qgx.www.entity.Address;

import java.util.List;

public interface TakeGoodDao {
    public List<Address> findPageNo(int pageNo, int pageSize, String phone);
    public int findCount(String phone);
}

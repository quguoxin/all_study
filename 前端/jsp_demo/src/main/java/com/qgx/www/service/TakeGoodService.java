package com.qgx.www.service;

import com.qgx.www.entity.Address;


import java.util.List;

public interface TakeGoodService {
    public List<Address> findPageNo(int pageNo, int pageSize, String phone);
    public int findCount(String phone);
}

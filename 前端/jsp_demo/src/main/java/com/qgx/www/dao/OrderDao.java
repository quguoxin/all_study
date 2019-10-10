package com.qgx.www.dao;

import com.qgx.www.entity.Orders;

import java.util.List;

public interface OrderDao {
    public List<Orders> findOrdersListByPageNo(int pageNo,int pageSize,String phone,String order_statu);

    int findCount(String phone,String order_statu);
}

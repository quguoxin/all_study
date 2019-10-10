package com.qgx.www.service;

import com.qgx.www.entity.Orders;

import java.util.List;

public interface OrdersService {
    public List<Orders> findOrdersListByPageNo(int pageNo, int pageSize, String phone,String order_statu);

    public int findCount(String phone,String order_statu);
}

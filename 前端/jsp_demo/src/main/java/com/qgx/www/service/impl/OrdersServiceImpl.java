package com.qgx.www.service.impl;

import com.qgx.www.dao.OrderDao;
import com.qgx.www.dao.impl.OrderDaoImpl;
import com.qgx.www.entity.Orders;
import com.qgx.www.service.OrdersService;

import java.util.List;

public class OrdersServiceImpl implements OrdersService {
    @Override
    public List<Orders> findOrdersListByPageNo(int pageNo, int pageSize, String phone,String order_statu) {
        OrderDao orderDao=new OrderDaoImpl();
        return orderDao.findOrdersListByPageNo(pageNo,pageSize,phone,order_statu);
    }

    @Override
    public int findCount(String phone,String order_statu) {
        OrderDao orderDao=new OrderDaoImpl();
        return  orderDao.findCount(phone,order_statu);
    }
}

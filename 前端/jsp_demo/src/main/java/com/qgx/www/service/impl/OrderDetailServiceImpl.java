package com.qgx.www.service.impl;

import com.qgx.www.dao.OrderDetailDao;
import com.qgx.www.dao.impl.OrderDetailDaoImpl;
import com.qgx.www.entity.Address;
import com.qgx.www.entity.Product;
import com.qgx.www.service.OrderDetailService;

import java.util.List;

public class OrderDetailServiceImpl implements OrderDetailService {
    @Override
    public List<Address> getAddress(String phone) {
        OrderDetailDao orderDetailDao=new OrderDetailDaoImpl();
        return orderDetailDao.getAddress(phone);

    }

    @Override
    public List<Product> grtProduct(String product_list) {
        OrderDetailDao orderDetailDao=new OrderDetailDaoImpl();
        return orderDetailDao.getProduct(product_list);
    }
}

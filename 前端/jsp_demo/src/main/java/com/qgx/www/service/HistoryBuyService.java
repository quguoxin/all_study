package com.qgx.www.service;

import com.qgx.www.entity.Buy_product;
import com.qgx.www.entity.Orders;
import com.qgx.www.entity.Product;

import java.util.List;

public interface HistoryBuyService {

    List<Product> getHistoryProduct(int pageNo,int pageSize,String phone);

    int grtCount(String phone);

    //Boolean delAll();



}

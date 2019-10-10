package com.qgx.www.dao;

import com.qgx.www.entity.Buy_product;
import com.qgx.www.entity.Orders;
import com.qgx.www.entity.Product;

import java.util.List;
import java.util.Set;

public interface HistoryBuyDao {


    //查商品(分页)
    List<Product> getHistoryProduct(int pageNo,int pageSize,String phone);

    //计数
    int grtCount(String phone);

    //删除所有数据
    //int delAll();




}

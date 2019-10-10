package com.qgx.www.dao;

import com.qgx.www.entity.Product;

import java.util.List;

public interface MyCollectsDao {
    //查商品(分页)
    List<Product> getMyCollectProduct(int pageNo, int pageSize, String phone);

    //计数
    int grtCount(String phone);
}

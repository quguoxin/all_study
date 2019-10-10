package com.qgx.www.service;

import com.qgx.www.entity.Product;

import java.util.List;

public interface MyCollectsService {
    List<Product> getMyCollectProduct(int pageNo, int pageSize, String phone);

    int grtCount(String phone);
}

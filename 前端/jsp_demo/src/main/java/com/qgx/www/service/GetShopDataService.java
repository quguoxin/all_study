package com.qgx.www.service;

import com.qgx.www.entity.Shopping;

import java.util.List;

public interface GetShopDataService {
    //获得商品数量
    public int getShopProductNum();

    //获得商品总价
    public String getShopProductTotalPrice();
}

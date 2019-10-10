package com.qgx.www.dao;

import com.qgx.www.entity.Product;
import com.qgx.www.entity.Shopping;

import java.util.List;

public interface GetShopDataDao {
    //获得商品数量
    public int getShopProductNum();

    //获得商品对象
    public List<Shopping> getShopProduct();
}

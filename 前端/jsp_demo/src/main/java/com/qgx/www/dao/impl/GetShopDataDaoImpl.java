package com.qgx.www.dao.impl;

import com.qgx.www.dao.GetShopDataDao;
import com.qgx.www.entity.Product;
import com.qgx.www.entity.Shopping;
import com.qgx.www.util.DBUtils;

import java.util.List;

public class GetShopDataDaoImpl extends DBUtils implements GetShopDataDao{
    @Override
    public int getShopProductNum() {
        String sql="select count(1) as totalCount from shopping";
        return super.getCount(sql);
    }

    @Override
    public List<Shopping> getShopProduct() {
        String sql="select * from shopping";
        return super.getAll(Shopping.class,sql);
    }
}

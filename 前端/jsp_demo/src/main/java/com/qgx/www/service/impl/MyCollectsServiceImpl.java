package com.qgx.www.service.impl;

import com.qgx.www.dao.MyCollectsDao;
import com.qgx.www.dao.impl.MyCollectsDaoImpl;
import com.qgx.www.entity.Product;
import com.qgx.www.service.MyCollectsService;

import java.util.List;

public class MyCollectsServiceImpl implements MyCollectsService {
    @Override
    public List<Product> getMyCollectProduct(int pageNo, int pageSize, String phone) {
        MyCollectsDao myCollectsDao=new MyCollectsDaoImpl();
        return myCollectsDao.getMyCollectProduct(pageNo,pageSize,phone);
    }

    @Override
    public int grtCount(String phone) {
        MyCollectsDao myCollectsDao=new MyCollectsDaoImpl();
        return myCollectsDao.grtCount(phone);
    }
}

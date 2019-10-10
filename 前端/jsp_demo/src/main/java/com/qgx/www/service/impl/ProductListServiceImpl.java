package com.qgx.www.service.impl;


import com.qgx.www.dao.ProductListDao;
import com.qgx.www.dao.impl.ProductListDaoImpl;
import com.qgx.www.entity.Product;
import com.qgx.www.service.ProductListService;

import java.util.List;

public class ProductListServiceImpl implements ProductListService {
    ProductListDao productListDao=new ProductListDaoImpl();
    @Override
    public List<Product> findProductByPageNo(int pageNo, int pageSize, String product_type, String orderType) {
        return productListDao.findProductByPageNo(pageNo,pageSize,product_type,orderType);
    }

    @Override
    public int findCount(String product_type,String orderType) {
        return productListDao.findCount(product_type,orderType);
    }
}

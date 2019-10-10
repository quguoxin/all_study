package com.qgx.www.service.impl;

import com.qgx.www.dao.ProductDetailDao;
import com.qgx.www.dao.impl.ProductDetailDaoImpl;
import com.qgx.www.entity.Product;
import com.qgx.www.service.ProductDetailService;


import java.util.List;

public class ProductDetailServiceImpl implements ProductDetailService {
    ProductDetailDao productDetailDao=new ProductDetailDaoImpl();
    @Override
    public List<Product> findProductByPageNo(int pageNo, int pageSize) {
        return productDetailDao.findProductByPageNo(pageNo,pageSize);
    }

    @Override
    public Product findProductById(String id) {
        return productDetailDao.findProductById(id);
    }

}

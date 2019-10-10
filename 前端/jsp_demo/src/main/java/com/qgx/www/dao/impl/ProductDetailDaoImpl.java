package com.qgx.www.dao.impl;

import com.qgx.www.dao.ProductDetailDao;
import com.qgx.www.entity.Product;
import com.qgx.www.util.DBUtils;


import java.util.List;

public class ProductDetailDaoImpl extends DBUtils implements ProductDetailDao {
    @Override
    public List<Product> findProductByPageNo(int pageNo, int pageSize) {
        String sql="SELECT * FROM product LIMIT ?,?";
        return super.getAll(Product.class,sql,pageNo,pageSize);
    }

    @Override
    public Product findProductById(String id) {
        String sql="SELECT * FROM product p where p.product_code=? ";
        return super.getOne(Product.class,sql,id);
    }
}

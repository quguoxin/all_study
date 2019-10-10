package com.qgx.www.dao;

import com.qgx.www.entity.Product;


import java.util.List;

public interface ProductDetailDao {
    public List<Product> findProductByPageNo(int pageNo, int pageSize);

   public Product findProductById(String id);
}

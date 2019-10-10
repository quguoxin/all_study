package com.qgx.www.service;

import com.qgx.www.entity.Product;


import java.util.List;

public interface ProductDetailService {
    public List<Product> findProductByPageNo(int pageNo, int pageSize);
    public Product findProductById(String id);
}

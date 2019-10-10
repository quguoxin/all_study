package com.qgx.www.dao;



import com.qgx.www.entity.Product;

import java.util.List;

public interface ProductListDao {
    public List<Product> findProductByPageNo(int pageNo, int pageSize, String product_type, String orderType);
    public int findCount(String product_type, String orderType);
}

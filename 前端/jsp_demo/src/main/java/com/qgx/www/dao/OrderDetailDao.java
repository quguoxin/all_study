package com.qgx.www.dao;

import com.qgx.www.entity.Address;
import com.qgx.www.entity.Product;

import java.util.List;

public interface OrderDetailDao {
    List<Address> getAddress(String phone);

    List<Product> getProduct(String product_list);
}

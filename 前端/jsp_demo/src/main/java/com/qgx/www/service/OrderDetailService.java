package com.qgx.www.service;

import com.qgx.www.entity.Address;
import com.qgx.www.entity.Product;

import java.util.List;

public interface OrderDetailService {
    List<Address> getAddress(String phone);

    List<Product> grtProduct(String product_list);
}

package com.qgx.www.dao.impl;

import com.qgx.www.dao.OrderDetailDao;
import com.qgx.www.entity.Address;
import com.qgx.www.entity.Product;
import com.qgx.www.util.DBUtils;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailDaoImpl extends DBUtils implements OrderDetailDao {
    @Override
    public List<Address> getAddress(String phone) {
        String sql="select * from address where phone=?";
        return  super.getAll(Address.class,sql,phone);
    }

    @Override
    public List<Product> getProduct(String product_list) {
        String[] product_array= product_list.split(",");
        List<Product> productList=new ArrayList<Product>();
        for(int i=0;i<product_array.length;i++){
            String sql="select * from product where id=?";
            productList.add(super.getOne(Product.class,sql,Integer.parseInt(product_array[i])));
        }

        return productList;
    }
}

package com.qgx.www.bean;

import com.qgx.www.entity.Address;
import com.qgx.www.entity.Product;

import java.util.List;

public class OrderDetailInfoBrean {
    private List<Address> addressList;
    private List<Product> productList;

    public OrderDetailInfoBrean() {
    }

    public OrderDetailInfoBrean(List<Address> addressList, List<Product> productList) {
        this.addressList = addressList;
        this.productList = productList;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}

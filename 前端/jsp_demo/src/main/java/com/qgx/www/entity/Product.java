package com.qgx.www.entity;

public class Product {
    private int id;
    private String product_code ; //'产品编号：82632606',
    private String product_name;
    private String product_type;
    private double price;
    private String product_date;
    private int   store_num;
    private String prodect_img;
    private String evaluate;
    private int salesVolume;

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    public int getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(int salesVolume) {
        this.salesVolume = salesVolume;
    }

    public Product(int id, String product_code, String product_name, String product_type, double price, String product_date, int store_num, String prodect_img, String evaluate, int salesVolume) {
        this.id = id;
        this.product_code = product_code;
        this.product_name = product_name;
        this.product_type = product_type;
        this.price = price;
        this.product_date = product_date;
        this.store_num = store_num;
        this.prodect_img = prodect_img;
        this.evaluate = evaluate;
        this.salesVolume = salesVolume;
    }

    public Product(int id, String product_code, String product_name, double price, String prodect_img) {
        this.id = id;
        this.product_code = product_code;
        this.product_name = product_name;
        this.price = price;
        this.prodect_img = prodect_img;
    }

    public Product() {
    }

    public Product(int id, String product_code, String product_name, String product_type, double price, String product_date, int store_num, String prodect_img) {
        this.id = id;
        this.product_code = product_code;
        this.product_name = product_name;
        this.product_type = product_type;
        this.price = price;
        this.product_date = product_date;
        this.store_num = store_num;
        this.prodect_img = prodect_img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProduct_date() {
        return product_date;
    }

    public void setProduct_date(String product_date) {
        this.product_date = product_date;
    }

    public int getStore_num() {
        return store_num;
    }

    public void setStore_num(int store_num) {
        this.store_num = store_num;
    }

    public String getProdect_img() {
        return prodect_img;
    }

    public void setProdect_img(String prodect_img) {
        this.prodect_img = prodect_img;
    }
}

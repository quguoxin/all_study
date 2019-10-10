package com.qgx.www.entity;

public class Buy_product {
    private int id;// INT AUTO_INCREMENT PRIMARY KEY,
    private int product_id;//INT COMMENT '商品编号,关联product表主键id',
    private double price;// DOUBLE COMMENT '价格',
    private String buy_date;// DATETIME COMMENT '购买时间',
    private int uid ;//INT COMMENT '用户编号，关联userinfo表主键id'

    public Buy_product() {
    }

    public Buy_product(int product_id, double price, String buy_date, int uid) {
        this.product_id = product_id;
        this.price = price;
        this.buy_date = buy_date;
        this.uid = uid;
    }

    public Buy_product(int id, int product_id, double price, String buy_date, int uid) {
        this.id = id;
        this.product_id = product_id;
        this.price = price;
        this.buy_date = buy_date;
        this.uid = uid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBuy_date() {
        return buy_date;
    }

    public void setBuy_date(String buy_date) {
        this.buy_date = buy_date;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}

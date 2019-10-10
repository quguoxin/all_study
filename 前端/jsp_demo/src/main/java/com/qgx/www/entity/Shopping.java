package com.qgx.www.entity;

public class Shopping {
    private int id;// INT AUTO_INCREMENT PRIMARY KEY,
    private int buy_num;// INT COMMENT '购买数量',
    private int product_id;// INT COMMENT '商品编号,关联product表主键id',
    private String prodect_img;//  VARCHAR(150) COMMENT '商品图片路径',
    private String product_code;// VARCHAR(50) COMMENT '商品代码',
    private String product_name;// VARCHAR(50) COMMENT '商品名称',
    private double price;// DOUBLE COMMENT '单个价格',
    private int uid;// INT COMMENT '用户编号，关联userinfo表主键id'

    public Shopping() {
    }

    public Shopping(int id, int buy_num, int product_id, String prodect_img, String product_code, String product_name, double price, int uid) {
        this.id = id;
        this.buy_num = buy_num;
        this.product_id = product_id;
        this.prodect_img = prodect_img;
        this.product_code = product_code;
        this.product_name = product_name;
        this.price = price;
        this.uid = uid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBuy_num() {
        return buy_num;
    }

    public void setBuy_num(int buy_num) {
        this.buy_num = buy_num;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProdect_img() {
        return prodect_img;
    }

    public void setProdect_img(String prodect_img) {
        this.prodect_img = prodect_img;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}

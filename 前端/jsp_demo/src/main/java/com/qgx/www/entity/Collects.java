package com.qgx.www.entity;

public class Collects {
    private  int id;// INT AUTO_INCREMENT PRIMARY KEY,
    private int product_id; //INT COMMENT '商品编号,关联product表主键id',
    private int  uid;// INT COMMENT '用户编号，关联userinfo表主键id'

    public Collects() {
    }

    public Collects(int id, int product_id, int uid) {
        this.id = id;
        this.product_id = product_id;
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

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}

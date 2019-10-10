package com.qgx.www.entity;

import java.util.Date;

public class Orders {
    private int id;
    private String orders_no;//订单编号：82632606,推荐使用时间
    private String  create_date;
    private double total_money;
    private int statu;// '1等待支付,2已支付,3等待发货,4已发货,5已收货,6已取消',
    private String product_list;// '保存已选产品的编号列表:[1,2,3,4]',
    private int  uid;//userinfo的外键,关联id',


    public Orders() {
    }

    public Orders(int id, String orders_no, String create_date, double total_money, int statu, String product_list, int uid) {
        this.id = id;
        this.orders_no = orders_no;
        this.create_date = create_date;
        this.total_money = total_money;
        this.statu = statu;
        this.product_list = product_list;
        this.uid = uid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrders_no() {
        return orders_no;
    }

    public void setOrders_no(String orders_no) {
        this.orders_no = orders_no;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public double getTotal_money() {
        return total_money;
    }

    public void setTotal_money(double total_money) {
        this.total_money = total_money;
    }

    public int getStatu() {
        return statu;
    }

    public void setStatu(int statu) {
        this.statu = statu;
    }

    public String getProduct_list() {
        return product_list;
    }

    public void setProduct_list(String product_list) {
        this.product_list = product_list;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}

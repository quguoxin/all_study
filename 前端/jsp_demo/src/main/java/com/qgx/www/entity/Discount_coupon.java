package com.qgx.www.entity;

public class Discount_coupon {
    private int id ;
    private String name; //'优惠券描述',
    private String end_date; //'截止时间',
    private double money; //'优惠券减免金额',
    private double limit_money; //'优惠的满足金额',
    private int coupon_type; //'优惠券类型：1现金券2折扣券',
    /* private int uid;//'用户编号，关联userinfo表主键',*/

    public Discount_coupon() {
    }

    public Discount_coupon(int id, String name, String end_date, double money, double limit_money, int coupon_type) {
        this.id = id;
        this.name = name;
        this.end_date = end_date;
        this.money = money;
        this.limit_money = limit_money;
        this.coupon_type = coupon_type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getLimit_money() {
        return limit_money;
    }

    public void setLimit_money(double limit_money) {
        this.limit_money = limit_money;
    }

    public int getCoupon_type() {
        return coupon_type;
    }

    public void setCoupon_type(int coupon_type) {
        this.coupon_type = coupon_type;
    }
}

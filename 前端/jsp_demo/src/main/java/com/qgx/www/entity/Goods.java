package com.qgx.www.entity;

public class Goods {
    private int goodno;
    private String goodname;
    private double goodprice;
    private int goodnum;

    public Goods() {
    }

    public Goods(int goodno, String goodname, double goodprice, int goodnum) {
        this.goodno = goodno;
        this.goodname = goodname;
        this.goodprice = goodprice;
        this.goodnum = goodnum;
    }

    public int getGoodno() {
        return goodno;
    }

    public void setGoodno(int goodno) {
        this.goodno = goodno;
    }

    public String getGoodname() {
        return goodname;
    }

    public void setGoodname(String goodname) {
        this.goodname = goodname;
    }

    public double getGoodprice() {
        return goodprice;
    }

    public void setGoodprice(double goodprice) {
        this.goodprice = goodprice;
    }

    public int getGoodnum() {
        return goodnum;
    }

    public void setGoodnum(int goodnum) {
        this.goodnum = goodnum;
    }
}

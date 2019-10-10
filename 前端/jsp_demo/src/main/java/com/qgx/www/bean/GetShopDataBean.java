package com.qgx.www.bean;

public class GetShopDataBean {
    private int totalNum;
    private String totalPrice;

    public GetShopDataBean() {
    }

    public GetShopDataBean(int totalNum, String totalPrice) {
        this.totalNum = totalNum;
        this.totalPrice = totalPrice;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }
}

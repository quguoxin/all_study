package com.qgx.www.entity;
//收支明细
public class Income_statement {
   private int id;
   private String create_date;//'日期',
   private String cardNo;// '储值卡号',
   private double income; // '存入',
   private double expend; //'支出',
   private double balance ;//'账户余额',
   private String detail;//'详情'

    public Income_statement() {
    }

    public Income_statement(int id, String create_date, String cardNo, double income, double expend, double balance, String detail) {
        this.id = id;
        this.create_date = create_date;
        this.cardNo = cardNo;
        this.income = income;
        this.expend = expend;
        this.balance = balance;
        this.detail = detail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getExpend() {
        return expend;
    }

    public void setExpend(double expend) {
        this.expend = expend;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}

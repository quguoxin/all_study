package com.qgx.www.entity;

public class Userinfo {
    private int id;
    private String username;
    private String sex;
    private String password;
    private String email;
    private String love;
    private String inviteCode;
    private String phone;// '手机号码',
    private double rmb_balance;// '账户余额',
    private double yb_balance;// '悠币余额',
    private int age;

    public Userinfo(int id, String username, String sex, String password, String email, String love, String inviteCode,  String phone, double rmb_balance, double yb_balance) {
        this.id = id;
        this.username = username;
        this.sex = sex;
        this.password = password;
        this.email = email;
        this.love = love;
        this.inviteCode = inviteCode;
        this.phone = phone;
        this.rmb_balance = rmb_balance;
        this.yb_balance = yb_balance;
    }

    public Userinfo(int id, String username, String sex, String password, String email, String love, String inviteCode, String phone, double rmb_balance, double yb_balance, int age) {
        this.id = id;
        this.username = username;
        this.sex = sex;
        this.password = password;
        this.email = email;
        this.love = love;
        this.inviteCode = inviteCode;
        this.phone = phone;
        this.rmb_balance = rmb_balance;
        this.yb_balance = yb_balance;
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getRmb_balance() {
        return rmb_balance;
    }

    public void setRmb_balance(double rmb_balance) {
        this.rmb_balance = rmb_balance;
    }

    public double getYb_balance() {
        return yb_balance;
    }

    public void setYb_balance(double yb_balance) {
        this.yb_balance = yb_balance;
    }

    public Userinfo() {
    }

    public Userinfo(String username, String password, String inviteCode) {
        this.username = username;
        this.password = password;
        this.inviteCode = inviteCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLove() {
        return love;
    }

    public void setLove(String love) {
        this.love = love;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }
}

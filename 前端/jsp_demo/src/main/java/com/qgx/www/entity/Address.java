package com.qgx.www.entity;

public class Address {
    private int id;//
    private String name;//  '收货人名称',
    private String address; //'所在地区',
    private String detail_address;// '详细地址',
    private String phone ;//'收货人手机号',
    private String postcode;// '邮编',
    private String fix_telephone;// '固定电话'


    public Address(String name, String address, String detail_address, String phone, String postcode, String fix_telephone) {
        this.name = name;
        this.address = address;
        this.detail_address = detail_address;
        this.phone = phone;
        this.postcode = postcode;
        this.fix_telephone = fix_telephone;
    }

    public Address() {
    }

    public Address(int id, String name, String address, String detail_address, String phone, String postcode, String fix_telephone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.detail_address = detail_address;
        this.phone = phone;
        this.postcode = postcode;
        this.fix_telephone = fix_telephone;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetail_address() {
        return detail_address;
    }

    public void setDetail_address(String detail_address) {
        this.detail_address = detail_address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getFix_telephone() {
        return fix_telephone;
    }

    public void setFix_telephone(String fix_telephone) {
        this.fix_telephone = fix_telephone;
    }
}

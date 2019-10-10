package com.qgx.www.service;

public interface AddressService {
    public int insert(String name, String address, String detail_address, String phone, String postcode, String fix_telephone);
    public String findAddress(String area_code);
}

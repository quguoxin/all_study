package com.qgx.www.dao;



import java.util.List;

public interface AddressDao {
    public int insert(String name, String address, String detail_address, String phone, String postcode, String fix_telephone);
    public String findAddress(String area_code);
}

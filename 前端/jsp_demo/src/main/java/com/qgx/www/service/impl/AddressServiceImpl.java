package com.qgx.www.service.impl;

import com.qgx.www.dao.AddressDao;
import com.qgx.www.dao.impl.AddressDaoImpl;
import com.qgx.www.service.AddressService;


public class AddressServiceImpl implements AddressService {
    AddressDao addressDao=new AddressDaoImpl();
    @Override
    public int insert(String name, String address, String detail_address, String phone, String postcode, String fix_telephone) {
        return addressDao.insert(name,address,detail_address,phone,postcode,fix_telephone);
    }

    @Override
    public String findAddress(String area_code) {
        return addressDao.findAddress(area_code);
    }
}

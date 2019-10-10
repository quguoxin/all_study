package com.qgx.www.dao.impl;

import com.qgx.www.dao.AddressDao;
import com.qgx.www.entity.AreaBaseInfo;
import com.qgx.www.util.DBUtils;


import java.sql.Connection;
import java.util.List;

public class AddressDaoImpl extends DBUtils implements AddressDao {
    @Override
    public int insert(String name,String address,  String detail_address,String phone,  String postcode, String fix_telephone) {
        Connection connection = super.getConnection();
        if(postcode==null){
            String sql="INSERT INTO address (NAME,address,detail_address,phone) VALUES(?,?,?,?)";
            return super.update(sql,name,address,detail_address,phone);
        }
        String sql="INSERT INTO address (NAME,address,detail_address,phone,postcode,fix_telephone) VALUES(?,?,?,?,?,?)";
        return super.update(sql,name,address,detail_address,phone,postcode,fix_telephone);
    }

    @Override
    public String findAddress(String area_code) {
        Connection connection = super.getConnection();
        String sql="SELECT area_name FROM area_base WHERE area_code=?";
        AreaBaseInfo areaBaseInfo=super.getOne(AreaBaseInfo.class,sql,area_code);

        return areaBaseInfo.getArea_name();
    }
}

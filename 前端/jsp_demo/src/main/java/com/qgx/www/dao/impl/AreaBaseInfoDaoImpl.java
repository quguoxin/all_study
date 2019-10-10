package com.qgx.www.dao.impl;

import com.qgx.www.dao.AreaBaseInfoDao;
import com.qgx.www.entity.AreaBaseInfo;
import com.qgx.www.util.DBUtils;


import java.sql.Connection;
import java.util.List;

public class AreaBaseInfoDaoImpl extends DBUtils implements AreaBaseInfoDao {
    @Override
    public List<AreaBaseInfo> findProvince() {
        Connection connection = super.getConnection();
        String sql="SELECT * FROM area_base WHERE area_type=1";
        List<AreaBaseInfo> proviceList=super.getAll(AreaBaseInfo.class,sql);

        return proviceList;
    }

    @Override
    public List<AreaBaseInfo> findCityOrCity(String parent_area_code) {
        Connection connection = super.getConnection();
        String sql= "SELECT * FROM area_base WHERE parent_area_code=?";
        List<AreaBaseInfo> CityorAreaList=super.getAll(AreaBaseInfo.class,sql,parent_area_code);
        return CityorAreaList;
    }



}

package com.qgx.www.service.impl;

import com.qgx.www.dao.AreaBaseInfoDao;
import com.qgx.www.dao.impl.AreaBaseInfoDaoImpl;
import com.qgx.www.entity.AreaBaseInfo;
import com.qgx.www.service.AreaBaseInfoServers;


import java.util.List;

public class AreaBaseInfoServersImpl implements AreaBaseInfoServers {
    AreaBaseInfoDao areaBaseInfoDao=new AreaBaseInfoDaoImpl();
    @Override
    public List<AreaBaseInfo> findProvince() {
        List<AreaBaseInfo> provinceList=areaBaseInfoDao.findProvince();
        return provinceList;
    }

    @Override
    public List<AreaBaseInfo> findCityOrCity(String parent_area_code) {
        List<AreaBaseInfo> CityorAreaList=areaBaseInfoDao.findCityOrCity(parent_area_code);
        return CityorAreaList;
    }
}

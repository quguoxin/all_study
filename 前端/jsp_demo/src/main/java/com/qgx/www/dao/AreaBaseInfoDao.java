package com.qgx.www.dao;

import com.qgx.www.entity.AreaBaseInfo;

import java.util.List;

public interface AreaBaseInfoDao {
    public List<AreaBaseInfo> findProvince();
    public List<AreaBaseInfo> findCityOrCity(String parent_area_code);

}

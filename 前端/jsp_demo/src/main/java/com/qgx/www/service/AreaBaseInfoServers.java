package com.qgx.www.service;

import com.qgx.www.entity.AreaBaseInfo;


import java.util.List;

public interface AreaBaseInfoServers {
    public List<AreaBaseInfo> findProvince();
    public List<AreaBaseInfo> findCityOrCity(String parent_area_code);
}

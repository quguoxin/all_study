package com.qgx.www.dao;

import com.qgx.www.entity.Area_base;

import java.util.List;

public interface AreaBaseDao {
    //查省
    public List<Area_base> findAllProvience();

    //市
    public List<Area_base> findCityByProvience(String area_code);

    //区
    public List<Area_base> findAreaByCity(String area_code);
}
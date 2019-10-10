package com.qgx.www.service.impl;

import com.qgx.www.dao.AreaBaseDao;
import com.qgx.www.dao.impl.AreaBaseDaoImpl;
import com.qgx.www.entity.Area_base;
import com.qgx.www.service.AreaBaseService;

import java.util.List;

public class AreaBaseServiceImpl implements AreaBaseService {
    //获取省
    @Override
    public List<Area_base> findAllProvience() {
        AreaBaseDao areaBaseDao=new AreaBaseDaoImpl();
        return areaBaseDao.findAllProvience();
    }

    //市
    @Override
    public List<Area_base> findCityByProvience(String area_code) {
        AreaBaseDao areaBaseDao=new AreaBaseDaoImpl();
        return areaBaseDao.findCityByProvience(area_code);
    }

    //区
    @Override
    public List<Area_base> findAreaByCity(String area_code) {
        AreaBaseDao areaBaseDao=new AreaBaseDaoImpl();
        return areaBaseDao.findCityByProvience(area_code);
    }
}

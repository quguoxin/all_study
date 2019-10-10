package com.qgx.www.dao.impl;
import com.qgx.www.dao.AreaBaseDao;
import com.qgx.www.entity.Area_base;
import com.qgx.www.util.DBUtils;

import java.util.List;

public class AreaBaseDaoImpl extends DBUtils implements AreaBaseDao {

    //省
    @Override
    public List<Area_base> findAllProvience() {
        String sql="SELECT * FROM area_base WHERE area_type=1";
        return  super.getAll(Area_base.class,sql);
    }

    //市(根据传入父类的area_code)
    @Override
    public List<Area_base> findCityByProvience(String area_code) {
        String sql="SELECT * FROM area_base WHERE parent_area_code=?";
        return super.getAll(Area_base.class,sql,area_code);
    }

    @Override
    public List<Area_base> findAreaByCity(String area_code) {
        String sql="SELECT * FROM area_base WHERE parent_area_code=?";
        return super.getAll(Area_base.class,sql,area_code);
    }

    //区(根据传入父类的area_code)

}

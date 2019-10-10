package com.qgx.www.mapper;

import com.qgx.www.entity.Insurance;

import java.util.List;
import java.util.Map;

public interface InsuranceMapper {
    public int findCount(Insurance insurance);
    public List<Insurance> findByParams(Map<String,Object> map);
}

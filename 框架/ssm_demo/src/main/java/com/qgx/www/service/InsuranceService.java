package com.qgx.www.service;

import com.qgx.www.entity.Insurance;

import java.util.List;
import java.util.Map;

public interface InsuranceService {

    public int findCount(Insurance insurance);
    public List<Insurance> findByParams(int startIndex,int pageSize,Insurance insurance);
}

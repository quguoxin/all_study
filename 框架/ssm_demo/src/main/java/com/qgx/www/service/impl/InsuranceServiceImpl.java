package com.qgx.www.service.impl;

import com.qgx.www.entity.Insurance;
import com.qgx.www.mapper.InsuranceMapper;
import com.qgx.www.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class InsuranceServiceImpl implements InsuranceService {

    @Autowired
    private InsuranceMapper insuranceMapper;


    @Override
    public int findCount(Insurance insurance) {
        return insuranceMapper.findCount(insurance);
    }

    @Override
    public List<Insurance> findByParams(int startIndex,int pageSize,Insurance insurance) {
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("startIndex",startIndex);
        map.put("pageSize",pageSize);
        map.put("insurance",insurance);
        return insuranceMapper.findByParams(map);
    }
}

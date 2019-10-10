package com.qgx.www.mapper;

import com.qgx.www.entity.Insurance;

import java.util.List;

public interface InsuranceMapper {

    //由名字查
    public List<Insurance> findInsuranceByName(String userName);
    //由工号查
    public List<Insurance> findInsuranceByJobNum(String userJobNum);
    //由证件号查
    public List<Insurance> findInsuranceByPapersNo(String papersNo);
    //由证件类型查
    public List<Insurance> findInsuranceByPapersType(String papersType);
    //增加
    public int addInsurance(Insurance insurance);
}

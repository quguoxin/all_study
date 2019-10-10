package com.qgx.www.controller;

import com.qgx.www.bean.BootPageBean;
import com.qgx.www.entity.Insurance;
import com.qgx.www.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/insurance")
public class InsuranceController {

    @Autowired
    private InsuranceService insuranceService;

    //登录
    @RequestMapping(value = "/doLogin")
    public String doLogin(String username,String password){
        return "main";
    }


    //查询
    @RequestMapping(value = "/getInsuranceList")
    @ResponseBody
    public BootPageBean<Insurance> getInsuranceList(int offset,int limit,Insurance insurance){
        System.out.println(insurance.toString());
        int totalCount=insuranceService.findCount(insurance);
        List<Insurance> list=insuranceService.findByParams(offset,limit,insurance);
        BootPageBean bootPageBean=new BootPageBean();
        bootPageBean.setTotal(totalCount);
        bootPageBean.setRows(list);
        return bootPageBean;
    }
}

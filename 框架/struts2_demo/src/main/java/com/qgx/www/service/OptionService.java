package com.qgx.www.service;

import com.qgx.www.bean.OptionBean;

import java.util.List;

public interface OptionService {
    //查所有
    List<OptionBean> show();

    //增加
    int add(OptionBean optionBean);

    //删除
    int del(int id);
}

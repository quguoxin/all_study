package com.qgx.www.dao;

import com.qgx.www.bean.OptionBean;

import java.util.List;

public interface OptionDao {
    List<OptionBean> show();

    int del(int id);

    int add(OptionBean optionBean);
}

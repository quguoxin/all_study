package com.qgx.www.service.impl;

import com.qgx.www.bean.OptionBean;
import com.qgx.www.dao.OptionDao;
import com.qgx.www.dao.impl.OptionDaoImpl;
import com.qgx.www.service.OptionService;

import java.util.List;

public class OptionServiceImpl implements OptionService {
    OptionDao optionDao=new OptionDaoImpl();
    @Override
    public List<OptionBean> show() {
        return optionDao.show();
    }

    @Override
    public int add(OptionBean optionBean) {
        return optionDao.add(optionBean);
    }


    @Override
    public int del(int id) {
        return optionDao.del(id);
    }
}

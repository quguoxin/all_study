package com.qgx.www.service.impl;

import com.qgx.www.dao.TakeGoodDao;
import com.qgx.www.dao.impl.TakeGoodDaoImpl;
import com.qgx.www.entity.Address;
import com.qgx.www.service.TakeGoodService;


import java.util.List;

public class TakeGoodServiceImpl implements TakeGoodService {
    TakeGoodDao takeGoodDao=new TakeGoodDaoImpl();
    @Override
    public List<Address> findPageNo(int pageNo, int pageSize, String phone) {
        List<Address> list=takeGoodDao.findPageNo(pageNo,pageSize,phone);
        return  list;


    }
    public int findCount( String phone){
        int sumpages = takeGoodDao.findCount(phone);
        return sumpages;
    };
}

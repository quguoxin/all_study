package com.qgx.www.service.impl;

import com.qgx.www.dao.YouBiDao;
import com.qgx.www.dao.impl.YouBiDaoImpl;
import com.qgx.www.entity.Userinfo;
import com.qgx.www.entity.YouBi;
import com.qgx.www.service.YouBiService;


import java.util.List;

public class YouBiServiceImpl implements YouBiService {
    YouBiDao youBiDao=new YouBiDaoImpl();

    @Override
    public List<YouBi> findListByPage(int pageNo, int pageSize) {
        return youBiDao.findListByPage( pageNo,pageSize );
    }

    @Override
    public int findCount() {
        return youBiDao.findCount();
    }

    @Override
    public Userinfo findYbBalance(String phone) {
        return youBiDao.findYbBalance( phone );
    }
}

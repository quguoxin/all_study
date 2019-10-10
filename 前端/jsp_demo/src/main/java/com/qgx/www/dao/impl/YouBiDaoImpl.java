package com.qgx.www.dao.impl;

import com.qgx.www.dao.YouBiDao;
import com.qgx.www.entity.Userinfo;
import com.qgx.www.entity.YouBi;
import com.qgx.www.util.DBUtils;

import java.util.List;

public class YouBiDaoImpl extends DBUtils implements YouBiDao {
    @Override
    public List<YouBi> findListByPage(int pageNo, int pageSize) {
        String sql="select * from youbi limit ?,? ";
        return super.getAll( YouBi.class,sql,(pageNo-1)*pageSize,pageSize );
    }

    @Override
    public int findCount() {
        String sql="select count(1) as totalCount from youbi";
        return super.getCount(sql);
    }

    @Override
    public Userinfo findYbBalance(String phone) {//获取悠币余额
        String sql="select * from userinfo where phone=?";
        return super.getOne( Userinfo.class,sql,phone );

    }
}

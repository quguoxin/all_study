package com.qgx.www.dao.impl;

import com.qgx.www.dao.TakeGoodDao;
import com.qgx.www.entity.Address;
import com.qgx.www.util.DBUtils;


import java.sql.Connection;
import java.util.List;

public class TakeGoodDaoImpl extends DBUtils implements TakeGoodDao {
    @Override
    public List<Address> findPageNo(int pageNo, int pageSize, String phone){
        Connection connection = super.getConnection();
        String sql = "SELECT * FROM address WHERE phone=?";
        int  startIndex=(pageNo-1)*pageSize;
        Object[] params=null;


        sql+=" LIMIT ?,?";
        params=new Object[]{phone,startIndex,pageSize};
        List<Address> list = super.getAll(Address.class, sql,params );

        return list;
    }
    public int findCount(String phone){
        String sql="SELECT COUNT(1) AS totalCount FROM address WHERE phone=?";
        Object[] params=null;
        params=new Object[]{phone};

        return super.getCount(sql,params);
    }

}

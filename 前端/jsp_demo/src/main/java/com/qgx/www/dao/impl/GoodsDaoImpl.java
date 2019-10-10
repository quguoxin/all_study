package com.qgx.www.dao.impl;

import com.qgx.www.dao.GoodsDao;
import com.qgx.www.entity.Goods;
import com.qgx.www.util.DBUtils;

import java.util.List;

public class GoodsDaoImpl extends DBUtils implements GoodsDao {
    //查询所有
    @Override
    public List<Goods> getALL() {
        String sql="select *  from  goods";
        return super.getAll(Goods.class,sql);
    }

    //修改
    @Override
    public int update(Goods goods) {
        String sql="UPDATE goods SET goodname=?,goodprice=?,goodnum=? WHERE goodno=?";
        Object[] param={goods.getGoodname(),goods.getGoodprice(),goods.getGoodnum(),goods.getGoodno()};
        return super.update(sql,param);
    }

    //删除
    @Override
    public int del(int goodno) {
        String sql="DELETE  FROM goods WHERE goodno=?";
        return super.update(sql,goodno);
    }
}

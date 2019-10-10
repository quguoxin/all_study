package com.qgx.www.dao;

import com.qgx.www.entity.Goods;

import java.util.List;

public interface GoodsDao {
    //查询所有
    public List<Goods> getALL();
    //修改
    public int  update(Goods goods);
    //删除
    public int del(int goodno);
}

package com.qgx.www.service;

import com.qgx.www.entity.Goods;

import java.util.List;

public interface GoodsService  {
    //修改
    public Boolean  alter(Goods goods);
    //删除
    public Boolean delete(int goodno);
    //显示列表
    public List<Goods> show();
}

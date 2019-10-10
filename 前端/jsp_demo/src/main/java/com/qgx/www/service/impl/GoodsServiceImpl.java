package com.qgx.www.service.impl;

import com.qgx.www.dao.GoodsDao;
import com.qgx.www.dao.impl.GoodsDaoImpl;
import com.qgx.www.entity.Goods;
import com.qgx.www.service.GoodsService;

import java.util.List;

public class GoodsServiceImpl implements GoodsService {
    //修改
    @Override
    public Boolean alter(Goods goods) {
        GoodsDao goodsDao=new GoodsDaoImpl();
        int n=goodsDao.update(goods);
        if(n==1){
            return true;
        }
        return false;
    }

    //删除
    @Override
    public Boolean delete(int goodno) {
        GoodsDao goodsDao=new GoodsDaoImpl();
        int m=goodsDao.del(goodno);
        if(m==1){
            return true;
        }
        return false;
    }

    //显示列表
    @Override
    public List<Goods> show() {
        GoodsDao goodsDao=new GoodsDaoImpl();
        return goodsDao.getALL();
    }
}

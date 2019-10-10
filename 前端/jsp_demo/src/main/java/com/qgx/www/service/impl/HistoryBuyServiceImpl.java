package com.qgx.www.service.impl;

import com.qgx.www.dao.HistoryBuyDao;
import com.qgx.www.dao.impl.HistoryBuyDaoImpl;
import com.qgx.www.entity.Buy_product;
import com.qgx.www.entity.Orders;
import com.qgx.www.entity.Product;
import com.qgx.www.service.HistoryBuyService;

import java.util.List;
import java.util.Set;

public class HistoryBuyServiceImpl implements HistoryBuyService {

    @Override
    public List<Product> getHistoryProduct(int pageNo,int pageSize,String phone) {
        HistoryBuyDao historyBuyDao=new HistoryBuyDaoImpl();
        return historyBuyDao.getHistoryProduct(pageNo,pageSize,phone);
    }



    @Override
    public int grtCount(String phone) {
        HistoryBuyDao historyBuyDao=new HistoryBuyDaoImpl();
        return historyBuyDao.grtCount(phone);
    }

   /* @Override
    public Boolean delAll() {
        Boolean ok=false;
        HistoryBuyDao historyBuyDao=new HistoryBuyDaoImpl();
        int b=historyBuyDao.delAll();
        if(b!=0){
            return true;
        }
        return false;
    }*/

}

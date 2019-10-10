package com.qgx.www.service.impl;

import com.qgx.www.dao.HistoryBuyDelDao;
import com.qgx.www.dao.impl.HistoryBuyDelDaoImpl;
import com.qgx.www.entity.Product;
import com.qgx.www.entity.Userinfo;
import com.qgx.www.service.HistoryBuyDelService;

import java.util.List;

public class HistoryBuyDelServiceImpl implements HistoryBuyDelService {
    @Override
    public Boolean delHistoryBuy(int id) {
        HistoryBuyDelDao historyBuyDelDao=new HistoryBuyDelDaoImpl();
        int ok=historyBuyDelDao.delHistoryBuy(id);
        if(ok>0){
            return true;
        }
        return false;
    }

    @Override
    public Userinfo getUserinfo(String phone) {
        HistoryBuyDelDao historyBuyDelDao=new HistoryBuyDelDaoImpl();
        return historyBuyDelDao.getUid(phone);
    }

    @Override
    public int addByCar(int id, Product product,int productNum) {
        HistoryBuyDelDao historyBuyDelDao=new HistoryBuyDelDaoImpl();
        return historyBuyDelDao.addByCar(id,product,productNum);
    }

    @Override
    public int addSelectBuyCar(int uid, List<Product> productList) {
        HistoryBuyDelDao historyBuyDelDao=new HistoryBuyDelDaoImpl();
        return historyBuyDelDao.addSelectBuyCar(uid,productList);
    }

    @Override
    public Product getProduct(String product_code) {
        HistoryBuyDelDao historyBuyDelDao=new HistoryBuyDelDaoImpl();
        return historyBuyDelDao.getProduct(product_code);
    }

    @Override
    public Boolean delMyCollects(int id) {
        HistoryBuyDelDao historyBuyDelDao=new HistoryBuyDelDaoImpl();
        int ok1=historyBuyDelDao.delMyCollects(id);
        if(ok1>0){
            return true;
        }
        return false;
    }

    @Override
    public Boolean delAlldelMyCollects(String[] product_idArray) {
        HistoryBuyDelDao historyBuyDelDao=new HistoryBuyDelDaoImpl();
        int ok2=historyBuyDelDao.delAlldelMyCollects(product_idArray);
        if(ok2>0){
            return true;
        }
        return false;
    }

    @Override
    public Boolean addMyCollects(int uid, int productNo) {
        HistoryBuyDelDao historyBuyDelDao=new HistoryBuyDelDaoImpl();
        int aa=historyBuyDelDao.addMyCollects(uid,productNo);
        if(aa==1){
            return true;
        }
        return false;
    }
}

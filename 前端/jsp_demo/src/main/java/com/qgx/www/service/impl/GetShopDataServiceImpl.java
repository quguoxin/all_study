package com.qgx.www.service.impl;

import com.qgx.www.dao.GetShopDataDao;
import com.qgx.www.dao.impl.GetShopDataDaoImpl;
import com.qgx.www.entity.Shopping;
import com.qgx.www.service.GetShopDataService;

import java.text.DecimalFormat;
import java.util.List;

public class GetShopDataServiceImpl implements GetShopDataService {
    @Override
    public int getShopProductNum() {
        GetShopDataDao getShopDataDao=new GetShopDataDaoImpl();
        return getShopDataDao.getShopProductNum();
    }

    @Override
    public String getShopProductTotalPrice() {
        double totalPrice=0;
        GetShopDataDao getShopDataDao=new GetShopDataDaoImpl();
        List<Shopping> shoppingList=getShopDataDao.getShopProduct();
        for(int i=0;i<shoppingList.size();i++){
            totalPrice+= shoppingList.get(i).getPrice()*shoppingList.get(i).getBuy_num();
        }
        return new DecimalFormat("0.00").format(totalPrice);
    }
}

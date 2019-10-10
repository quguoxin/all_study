package com.qgx.www.service.impl;


import com.qgx.www.dao.MyShoppingDao;
import com.qgx.www.dao.impl.MyShoppingDaoImpl;
import com.qgx.www.entity.Shopping;
import com.qgx.www.service.MyShoppingService;

import java.util.Arrays;
import java.util.List;

public class MyShoppingServiceImpl implements MyShoppingService {
    MyShoppingDao myShoppingDao=new MyShoppingDaoImpl();
    @Override
    public List<Shopping> findMyShoppingList(int pageNo, int pageSize, String phone) {
        return myShoppingDao.findMyShoppingList(pageNo,pageSize,phone);
    }

    @Override
    public boolean delProduct(int id) {
        int num=myShoppingDao.delProduct(id);
        if(num>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean delBySelect(String ids) {
        //将1-2-3切割成int类型集合
        String[] idArray=ids.split("-");
        Integer[] idArray2=new Integer[idArray.length];
        for (int i=0;i<idArray.length;i++){
            idArray2[i]=Integer.parseInt(idArray[i]);
        }
        List<Integer> idList= Arrays.asList(idArray2);//将数组转集合
        int num=myShoppingDao.delectBySelect(idList);
        if(num>0){
            return true;
        }

        return false;
    }

    @Override
    public boolean changeBuyNum(int id, int buy_num) {
        int num=myShoppingDao.changeBuyNum(id,buy_num);
        if(num>0){
            return true;
        }
        return false;
    }
}

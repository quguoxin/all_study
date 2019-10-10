package com.qgx.www.dao.impl;


import com.qgx.www.dao.MyShoppingDao;
import com.qgx.www.entity.Shopping;
import com.qgx.www.util.DBUtils;

import java.util.List;

public class MyShoppingDaoImpl extends DBUtils implements MyShoppingDao {

    @Override
    public List<Shopping> findMyShoppingList(int pageNo, int pageSize, String phone) {
        String sql="SELECT * FROM `shopping` s WHERE s.uid=(SELECT id FROM userinfo u WHERE u.phone=?) limit ?,?";
        return super.getAll(Shopping.class,sql,phone,(pageNo-1)*pageSize,pageSize);
    }

    @Override
    public int delProduct(int id) {
        String sql="DELETE FROM shopping where id=?";
        return super.update(sql,id);
    }

    @Override
    public int delectBySelect(List<Integer> idList) {
        String sql="delete from shopping where id in(";
        for(int i=0;i<idList.size();i++){
            if(i== idList.size()-1){
                sql+=idList.get(i);
            }else {
                sql+=idList.get(i)+",";
            }
          }
        sql+=")";
        return super.update(sql);
    }

    @Override
    public int changeBuyNum(int id, int buy_num) {
        String sql="update  shopping set buy_num=? where id=?";
        return super.update(sql,buy_num,id);
    }
}

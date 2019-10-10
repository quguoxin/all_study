package com.qgx.www.dao;


import com.qgx.www.entity.Shopping;

import java.util.List;

public interface MyShoppingDao {
    public List<Shopping> findMyShoppingList(int pageNo, int pageSize, String phone);
    public int delProduct(int id);
    public int delectBySelect(List<Integer> list);
    public int changeBuyNum(int id, int buy_num);
}

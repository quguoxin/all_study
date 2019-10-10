package com.qgx.www.service;


import com.qgx.www.entity.Shopping;

import java.util.List;

public interface MyShoppingService {
    public List<Shopping> findMyShoppingList(int pageNo, int pageSize, String phone);

    public boolean delProduct(int id);

    public boolean delBySelect(String ids);

    public boolean changeBuyNum(int id, int buy_num);
}

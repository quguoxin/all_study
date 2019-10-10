package com.qgx.www.service;

import com.qgx.www.entity.Product;
import com.qgx.www.entity.Userinfo;

import java.util.List;

public interface HistoryBuyDelService {
    public Boolean delHistoryBuy(int id);

    public Userinfo getUserinfo(String phone);

    public int addByCar(int id, Product product,int productNum);

    public int addSelectBuyCar(int uid, List<Product> productList);

    public Product getProduct(String product_code);

    //单个删除收藏商品
    public Boolean delMyCollects(int id);

    //批量
    public Boolean delAlldelMyCollects(String[] product_idArray);

    //加入收藏
    public Boolean addMyCollects(int uid,int productNo);
}

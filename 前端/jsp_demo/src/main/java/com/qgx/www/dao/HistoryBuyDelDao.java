package com.qgx.www.dao;

import com.qgx.www.entity.Product;
import com.qgx.www.entity.Userinfo;

import java.util.List;

public interface HistoryBuyDelDao {

    //单个删除已购商品
    public int delHistoryBuy(int id);

    //获取个人uid
    public Userinfo getUid(String phone);

    //获取商品对象
    public Product getProduct(String product_code);

    //单个加入购物车
    public int addByCar(int id, Product product,int productNum);

    //批量加入购物车
    public int addSelectBuyCar(int uid, List<Product> productList);

    //单个删除收藏商品
    public int delMyCollects(int id);

    //批量删除收藏商品
    public int delAlldelMyCollects(String[] product_idArray);

    //加入收藏
    public int addMyCollects(int uid,int productNo);
}

package com.qgx.www.dao.impl;

import com.qgx.www.dao.HistoryBuyDelDao;
import com.qgx.www.entity.Product;
import com.qgx.www.entity.Userinfo;
import com.qgx.www.util.DBUtils;

import java.util.List;

public class HistoryBuyDelDaoImpl extends DBUtils implements HistoryBuyDelDao {
    @Override
    public int delHistoryBuy(int id) {
        String sql="DELETE FROM buy_product WHERE product_id=?";
        return super.update(sql,id);
    }

    @Override
    public Userinfo getUid(String phone) {
        String sql="select id from userinfo where phone=?";
        return super.getOne(Userinfo.class,sql,phone);
    }

    @Override
    public Product getProduct(String product_code) {
        String sql="select *  from product where product_code=?";
        return super.getOne(Product.class,sql,product_code);
    }

    @Override
    public int addByCar(int id, Product product,int productNum) {
        String sql="INSERT INTO shopping(buy_num,product_id,prodect_img,product_code,product_name,price,uid) VALUES (?,?,?,?,?,?,?)";
        Object[] params={productNum,product.getId(),product.getProdect_img(),
                         product.getProduct_code(),product.getProduct_name(),product.getPrice(),id};
        return super.update(sql,params);
    }

    @Override
    public int addSelectBuyCar(int uid, List<Product> productList) {
        String sql="INSERT INTO shopping(buy_num,product_id,prodect_img,product_code,product_name,price,uid) VALUES (";
        for(int i=0;i<productList.size();i++){
            Product product=productList.get(i);
            if(i==productList.size()-1){
                sql+=1+","+product.getId()+",'"+product.getProdect_img()+"','"+product.getProduct_code()+"','"+product.getProduct_name()+"',"+product.getPrice()+","+uid+")";
            }else {
                sql+=1+","+product.getId()+",'"+product.getProdect_img()+"','"+product.getProduct_code()+"','"+product.getProduct_name()+"',"+product.getPrice()+","+uid+"),(";
            }
        }
        return super.update(sql);
    }

    @Override
    public int delMyCollects(int id) {
        String sql="DELETE FROM collects WHERE product_id=?";
        return super.update(sql,id);
    }

    @Override
    public int delAlldelMyCollects(String[] product_idArray) {
        String sql="DELETE FROM collects WHERE product_id in(";
        for(int i=0;i<product_idArray.length;i++){
            if(i==product_idArray.length-1){
                sql+=product_idArray[i]+")";
            }else {
                sql+=product_idArray[i]+",";
            }
        }
        return super.update(sql);

    }

    @Override
    public int addMyCollects(int uid, int productNo) {
        String sql="INSERT INTO collects (product_id,uid) VALUES (?,?)";
        return  super.update(sql,productNo,uid);
    }

}

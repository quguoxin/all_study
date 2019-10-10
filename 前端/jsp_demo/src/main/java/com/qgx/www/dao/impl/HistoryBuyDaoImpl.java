package com.qgx.www.dao.impl;

import com.qgx.www.dao.HistoryBuyDao;
import com.qgx.www.entity.Buy_product;
import com.qgx.www.entity.Orders;
import com.qgx.www.entity.Product;
import com.qgx.www.util.DBUtils;


import java.util.List;


public class HistoryBuyDaoImpl extends DBUtils implements HistoryBuyDao {

    @Override
    public List<Product> getHistoryProduct(int pageNo,int pageSize,String phone) {
      String sql="SELECT p.id,p.product_code,p.product_name,p.product_type,p.price,p.product_date,p.store_num,p.prodect_img  \n" +
              "FROM product p,buy_product b WHERE p.product_code=b.product_id \n" +
              "AND b.uid=(SELECT u.id FROM userinfo u WHERE u.phone=?) LIMIT ?,?";
      return super.getAll(Product.class,sql,phone,(pageNo-1)*pageSize,pageSize);
    }



    @Override
    public int grtCount(String phone) {
        String sql="SELECT COUNT(1) as totalCount FROM product p,buy_product b WHERE p.product_code=b.product_id \n" +
                "AND b.uid=(SELECT u.id FROM userinfo u WHERE u.phone=?)";
        return super.getCount(sql,phone);
    }

   /* @Override
    public int delAll() {
        String sql="DELETE FROM buy_product";
        return super.update(sql);
    }*/

}

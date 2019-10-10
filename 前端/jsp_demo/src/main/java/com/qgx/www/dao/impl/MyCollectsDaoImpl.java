package com.qgx.www.dao.impl;

import com.qgx.www.dao.MyCollectsDao;
import com.qgx.www.entity.Product;
import com.qgx.www.util.DBUtils;

import java.util.List;

public class MyCollectsDaoImpl extends DBUtils implements MyCollectsDao {
    @Override
    public List<Product> getMyCollectProduct(int pageNo, int pageSize, String phone) {
        String sql="SELECT p.id,p.product_code,p.product_name,p.product_type,p.price,p.product_date,p.store_num,p.prodect_img  \n" +
                "FROM product p,collects c WHERE p.product_code=c.product_id \n" +
                "AND c.uid=(SELECT u.id FROM userinfo u WHERE u.phone=?) LIMIT ?,?";
        return super.getAll(Product.class,sql,phone,(pageNo-1)*pageSize,pageSize);
    }

    @Override
    public int grtCount(String phone) {
        String sql="SELECT COUNT(1) as totalCount FROM product p,collects c WHERE p.product_code=c.product_id \n" +
                "AND c.uid=(SELECT u.id FROM userinfo u WHERE u.phone=?)";
        return super.getCount(sql,phone);
    }
}

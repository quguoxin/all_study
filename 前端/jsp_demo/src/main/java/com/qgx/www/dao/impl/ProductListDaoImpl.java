package com.qgx.www.dao.impl;

import com.qgx.www.dao.ProductListDao;
import com.qgx.www.entity.Product;
import com.qgx.www.util.DBUtils;


import java.util.List;

public class ProductListDaoImpl extends DBUtils implements ProductListDao {
    @Override
    public List<Product> findProductByPageNo(int pageNo, int pageSize,String product_type,String orderType) {
        String sql="";
        int orderType2= Integer.parseInt(orderType);
        int a=0;
        if(!product_type.equals("")){
            if (orderType2==1){
                sql="select * from product where product_type=? order by salesVolume DESC limit ?,?";
                return super.getAll(Product.class,sql,product_type,(pageNo-1)*pageSize,pageSize);
            }else if(orderType2==2){
                sql="select * from product where product_type=? order by price DESC limit ?,?";
                return super.getAll(Product.class,sql,product_type,(pageNo-1)*pageSize,pageSize);
            }else if(orderType2==3){
                sql="select * from product where product_type=? order by evaluate DESC limit ?,?";
                return super.getAll(Product.class,sql,product_type,(pageNo-1)*pageSize,pageSize);
            } else if(orderType2==0){
                sql="select * from product where product_type=? limit ?,?";
                return super.getAll(Product.class,sql,product_type,(pageNo-1)*pageSize,pageSize);
            }
        }else {
            if (orderType2==1){
                sql="select * from product  order by salesVolume DESC limit ?,?";
                return super.getAll(Product.class,sql,(pageNo-1)*pageSize,pageSize);
            }else if(orderType2==2){
                sql="select * from product   order by price DESC limit ?,?";
                return super.getAll(Product.class,sql,(pageNo-1)*pageSize,pageSize);
            }else if(orderType2==3){
                sql="select * from product   order by evaluate DESC limit ?,?";
                return super.getAll(Product.class,sql,(pageNo-1)*pageSize,pageSize);
            } else if(orderType2==0){
                sql="select * from product  limit ?,?";
                return super.getAll(Product.class,sql,(pageNo-1)*pageSize,pageSize);
            }

        }
       /* Object[] params=null;
        if(!"".equals(product_type)){
            if (!("price".equals(product_type)||"salesVolume".equals(product_type)||"evaluate".equals(product_type))){
                sql+=" where p.product_type=? ";
                params=new Object[]{product_type,(pageNo-1)*pageSize,pageSize};
            }else {
                sql+=" ORDER BY ? DESC ";
                params=new Object[]{product_type,(pageNo-1)*pageSize,pageSize};
            }
        }
        else {
            params=new Object[]{(pageNo-1)*pageSize,pageSize};
        }
        sql+=" limit ?,? ";

        List<Product> list=DBUtils.getAll(Product.class,sql,params);*/
 return null;
    }

    @Override
    public int findCount(String product_type,String orderType) {
      String sql="";
        if(!product_type.equals("")){
            if (!orderType.equals("")){
                sql="select count(1) as totalCount from product where product_type=? order by ? DESC";
                return super.getCount(sql,product_type,orderType);
            }else {
                sql="select count(1) as totalCount from product where product_type=?";
                return super.getCount(sql,product_type);
            }
        }else {
            if (!orderType.equals("")){
                sql="select count(1) as totalCount from product order by ? DESC";
                return super.getCount(sql,orderType);
            }else {
                sql="select count(1) as totalCount from product ";
                return super.getCount(sql);
            }
    }

       /* String sql="select count(1) as totalCount from product p ";
        Object[] params=null;
        if(!"".equals(product_type)){
            if (!("price".equals(product_type)||"salesVolume".equals(product_type)||"evaluate".equals(product_type))){
                sql+=" where p.product_type=? ";
                params=new Object[]{product_type};
            }else {
                sql+=" ORDER BY ? ";
                params=new Object[]{product_type};
            }

        }else {
            params=new Object[]{""};;
        }
        return DBUtils.getCount(sql,params);*/
    }
}

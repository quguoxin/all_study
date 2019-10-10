package com.qgx.www.dao.impl;

import com.qgx.www.dao.OrderDao;
import com.qgx.www.entity.Orders;
import com.qgx.www.util.DBUtils;


import java.util.List;

/**
 * 分页查询  类型查询
 */
public class OrderDaoImpl extends DBUtils implements OrderDao {
    @Override
    public List<Orders> findOrdersListByPageNo(int pageNo, int pageSize, String phone,String order_statu) {
        String sql="select * from orders o where o.uid=(select id from userinfo u where u.phone=?)  ";
        int startIndex=(pageNo-1)*pageSize;
        Object[] params=null;
        if(!order_statu.equals("0")){
            sql+=" and statu=? ";
            params=new Object[]{phone,order_statu,startIndex,pageSize};
        }else {
            params=new Object[]{phone,startIndex,pageSize};
        }
        sql+=" LIMIT ?,? ";

        return super.getAll(Orders.class,sql,params);
    }

    @Override
    public int findCount(String phone,String order_statu) {
        String sql="select count(1) as totalCount from orders o where o.uid=(select id from userinfo u where u.phone=?)";
        Object[] params=null;
        if(!order_statu.equals("0")){
            sql+="and statu=?";
            params=new Object[]{phone,order_statu};
        }else {
            params=new Object[]{phone};
        }
        return super.getCount(sql,params);
    }
}

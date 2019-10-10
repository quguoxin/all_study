package com.qgx.www.dao.impl;

import com.qgx.www.dao.DiscountCouponDao;
import com.qgx.www.entity.Discount_coupon;
import com.qgx.www.util.DBUtils;

import java.util.List;

public class DiscountCouponDaoImpl extends DBUtils implements DiscountCouponDao {
    @Override
    public List<Discount_coupon> findDiscountCouponListByPageNo(int pageNo, int pageSize, String phone) {
        int startIndex=(pageNo-1)*pageSize;
        String sql="select * from discount_coupon d where d.uid=(select id from userinfo u where u.phone=?) LIMIT ?,? ";
        return super.getAll(Discount_coupon.class,sql,phone,startIndex,pageSize);
    }

    @Override
    public int findCount(String phone) {
        String sql="select count(1) as totalCount from discount_coupon d where d.uid=(select id from userinfo u where u.phone=?) ";
        return super.getCount(sql,phone);
    }
}

package com.qgx.www.dao;

import com.qgx.www.entity.Discount_coupon;
import com.qgx.www.entity.Orders;

import java.util.List;

public interface DiscountCouponDao {

    public List<Discount_coupon> findDiscountCouponListByPageNo(int pageNo, int pageSize, String phone);

    int findCount(String phone);
}

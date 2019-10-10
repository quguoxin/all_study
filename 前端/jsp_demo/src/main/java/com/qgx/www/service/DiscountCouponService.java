package com.qgx.www.service;

import com.qgx.www.entity.Discount_coupon;

import java.util.List;

public interface DiscountCouponService {
    public List<Discount_coupon> findDiscountCouponListByPageNo(int pageNo, int pageSize, String phone);

    int findCount(String phone);
}

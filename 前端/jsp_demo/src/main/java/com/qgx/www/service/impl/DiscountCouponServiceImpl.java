package com.qgx.www.service.impl;

import com.qgx.www.dao.DiscountCouponDao;
import com.qgx.www.dao.impl.DiscountCouponDaoImpl;
import com.qgx.www.entity.Discount_coupon;
import com.qgx.www.service.DiscountCouponService;

import java.util.List;

public class DiscountCouponServiceImpl implements DiscountCouponService {
    @Override
    public List<Discount_coupon> findDiscountCouponListByPageNo(int pageNo, int pageSize, String phone) {
        DiscountCouponDao discountCouponDao=new DiscountCouponDaoImpl();
        return discountCouponDao.findDiscountCouponListByPageNo(pageNo,pageSize,phone);
    }

    @Override
    public int findCount(String phone) {
        DiscountCouponDao discountCouponDao=new DiscountCouponDaoImpl();
        return discountCouponDao.findCount(phone);
    }
}

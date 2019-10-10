package com.qgx.www.bean;

import java.util.List;

/**
 * 分页
 */
public class PageBean<T> {
    private int pageNo;//当前页码
    private int pageSize;//页显示行数
    private int totalPage;//总页数
    private int totalCount;//总记录数
    private List<T> data;//分页集合
    private double yb_balance;
    private String phone;

    public PageBean(int pageNO, int pageSize, String phone, List<T> data, int totalPage) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalPage = totalPage;
        this.data = data;
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getYb_balance() {
        return yb_balance;
    }

    public void setYb_balance(double yb_balance) {
        this.yb_balance = yb_balance;
    }

    public PageBean(int pageNo, int pageSize, int totalPage, int totalCount, List<T> data, double yb_balance) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalPage = totalPage;
        this.totalCount = totalCount;
        this.data = data;
        this.yb_balance = yb_balance;
    }

    public PageBean(String pageNo) {
    }

    public PageBean(int pageNo, int pageSize, int totalPage, int totalCount, List<T> data) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalPage = totalPage;
        this.totalCount = totalCount;
        this.data = data;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}

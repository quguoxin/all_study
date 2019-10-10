package com.qgx.www.entity;

public class YouBi {
  private int id;
    private String create_date;// '获得时间',
    private int num;// '获得数量',
    private String remark;// '获得来源，比如：登录获得悠币'

    public YouBi() {
    }

    public YouBi(int id, String create_date, int num, String remark) {
        this.id = id;
        this.create_date = create_date;
        this.num = num;
        this.remark = remark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}

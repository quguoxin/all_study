package com.qgx.www.entity;

public class Area_base {
    private String area_code;//地区码
    private String parent_area_code;//父地区码,
    private String area_name;//地区名称
    private int area_type;//地区类型：0--无 1--省级地区 2--市级地区 3--县级地区',
    private String create_time;//创建时间

    public Area_base() {
    }

    public Area_base(String area_code, String parent_area_code, String area_name, int area_type, String create_time) {
        this.area_code = area_code;
        this.parent_area_code = parent_area_code;
        this.area_name = area_name;
        this.area_type = area_type;
        this.create_time = create_time;
    }

    public String getArea_code() {
        return area_code;
    }

    public void setArea_code(String area_code) {
        this.area_code = area_code;
    }

    public String getParent_area_code() {
        return parent_area_code;
    }

    public void setParent_area_code(String parent_area_code) {
        this.parent_area_code = parent_area_code;
    }

    public String getArea_name() {
        return area_name;
    }

    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }

    public int getArea_type() {
        return area_type;
    }

    public void setArea_type(int area_type) {
        this.area_type = area_type;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }
}

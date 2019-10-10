package com.qgx.www.entity;

import java.util.Date;

public class AreaBaseInfo {
    private String area_code;
    private String parent_area_code;
    private String area_name;
    private int area_type;
    private String create_time;

    public AreaBaseInfo() {
    }

    public AreaBaseInfo(String area_code, String parent_area_code, String area_name, int area_type, String create_time) {
        this.area_code = area_code;
        this.parent_area_code = parent_area_code;
        this.area_name = area_name;
        this.area_type = area_type;
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "AreaBaseInfo{" +
                "area_code='" + area_code + '\'' +
                ", parent_area_code='" + parent_area_code + '\'' +
                ", area_name='" + area_name + '\'' +
                ", area_type=" + area_type +
                ", create_time='" + create_time + '\'' +
                '}';
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

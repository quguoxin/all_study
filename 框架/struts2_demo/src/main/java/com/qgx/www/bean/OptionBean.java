package com.qgx.www.bean;

public class OptionBean {
    private int id;
    private String title;
    private String option;
    private String type;

    public OptionBean() {
    }

    public OptionBean(int id, String title, String option, String type) {
        this.id = id;
        this.title = title;
        this.option = option;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

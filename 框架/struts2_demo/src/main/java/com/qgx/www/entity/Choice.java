package com.qgx.www.entity;

import java.util.List;

public class Choice {
    private int id;
    private String title;
    private int optionType;
    private List<Choice_option> list;

    public Choice() {
    }

    public Choice(int id, String title, int optionType) {
        this.id = id;
        this.title = title;
        this.optionType = optionType;
    }

    public Choice(int id, String title, int optionType, List<Choice_option> list) {
        this.id = id;
        this.title = title;
        this.optionType = optionType;
        this.list = list;
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

    public int getOptionType() {
        return optionType;
    }

    public void setOptionType(int optionType) {
        this.optionType = optionType;
    }

    public List<Choice_option> getList() {
        return list;
    }

    public void setList(List<Choice_option> list) {
        this.list = list;
    }
}

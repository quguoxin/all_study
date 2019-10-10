package com.qgx.www.entity;

public class Choice {
    private int id;
    private String title;
    private int optionType;

    public Choice() {
    }

    public Choice(int id, String title, int optionType) {
        this.id = id;
        this.title = title;
        this.optionType = optionType;
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

    @Override
    public String toString() {
        return "Choice{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", optionType=" + optionType +
                '}';
    }
}

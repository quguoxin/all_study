package com.qgx.www.entity;

public class Choice_option {
    private int id;
    private String content;
    private int cid;

    public Choice_option() {
    }

    public Choice_option(int id, String content, int cid) {
        this.id = id;
        this.content = content;
        this.cid = cid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
}

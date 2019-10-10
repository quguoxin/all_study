package com.qgx.www.ioc;

import java.util.List;

public class UserInfo {
    private int id;
    private String username;
    private String sex;
    private List<String> love;
    private ExtendInfo extendInfo;

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", love=" + love +
                ", extendInfo=" + extendInfo +
                '}';
    }

    public UserInfo(int id, String username, String sex) {
        this.id = id;
        this.username = username;
        this.sex = sex;
    }



    public UserInfo() {
    }

    public List<String> getLove() {
        return love;
    }

    public void setLove(List<String> love) {
        this.love = love;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public ExtendInfo getExtendInfo() {
        return extendInfo;
    }

    public void setExtendInfo(ExtendInfo extendInfo) {
        this.extendInfo = extendInfo;
    }
}

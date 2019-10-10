package com.qgx.www.entity;

public class Insurance {
    private int id;
    private String userName;//姓名
    private String userJobNum;//工号
    private String papersNo;//证件号
    private String papersType;//证件类型


    public Insurance() {
    }

    public Insurance(String userName, String userJobNum, String papersNo, String papersType) {
        this.userName = userName;
        this.userJobNum = userJobNum;
        this.papersNo = papersNo;
        this.papersType = papersType;
    }

    public Insurance(int id, String userName, String userJobNum, String papersNo, String papersType) {
        this.id = id;
        this.userName = userName;
        this.userJobNum = userJobNum;
        this.papersNo = papersNo;
        this.papersType = papersType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserJobNum() {
        return userJobNum;
    }

    public void setUserJobNum(String userJobNum) {
        this.userJobNum = userJobNum;
    }

    public String getPapersNo() {
        return papersNo;
    }

    public void setPapersNo(String papersNo) {
        this.papersNo = papersNo;
    }

    public String getPapersType() {
        return papersType;
    }

    public void setPapersType(String papersType) {
        this.papersType = papersType;
    }

    @Override
    public String toString() {
        return "Insurance{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userJobNum='" + userJobNum + '\'' +
                ", papersNo='" + papersNo + '\'' +
                ", papersType='" + papersType + '\'' +
                '}';
    }
}

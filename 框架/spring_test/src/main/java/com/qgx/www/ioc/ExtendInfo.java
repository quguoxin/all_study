package com.qgx.www.ioc;

public class ExtendInfo {
    private String phone;
    private int age;

    @Override
    public String toString() {
        return "ExtendInfo{" +
                "phone='" + phone + '\'' +
                ", age=" + age +
                '}';
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

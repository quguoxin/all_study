package entity;

import java.util.Date;

public class Student {
    private String studentno;
    private String loginpwd;
    private String studentname;
    private String  sex;
    private int gradeid;
    private String phone;
    private String adress;
    private Date borndate;
    private String email;

    @Override
    public String toString() {
        return "Student{" +
                "studentno='" + studentno + '\'' +
                ", loginpwd='" + loginpwd + '\'' +
                ", studentname='" + studentname + '\'' +
                ", sex='" + sex + '\'' +
                ", gradeid=" + gradeid +
                ", phone='" + phone + '\'' +
                ", adress='" + adress + '\'' +
                ", borndate=" + borndate +
                ", email='" + email + '\'' +
                '}';
    }

    public Student() {
    }

    public Student(String studentno, String loginpwd, String studentname, String sex, int gradeid, String phone, String adress, Date borndate, String email) {
        this.studentno = studentno;
        this.loginpwd = loginpwd;
        this.studentname = studentname;
        this.sex = sex;
        this.gradeid = gradeid;
        this.phone = phone;
        this.adress = adress;
        this.borndate = borndate;
        this.email = email;
    }

    public String getStudentno() {
        return studentno;
    }

    public void setStudentno(String studentno) {
        this.studentno = studentno;
    }

    public String getLoginpwd() {
        return loginpwd;
    }

    public void setLoginpwd(String loginpwd) {
        this.loginpwd = loginpwd;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getGradeid() {
        return gradeid;
    }

    public void setGradeid(int gradeid) {
        this.gradeid = gradeid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Date getBorndate() {
        return borndate;
    }

    public void setBorndate(Date borndate) {
        this.borndate = borndate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

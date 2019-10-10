package entity;

public class UserInfo {
    private int userid;
    private String username;
    private int sex;
    private String phone;
    private String idcard;
    private String address;

    @Override
    public String toString() {
        return "UserInfo{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", sex=" + sex +
                ", phone='" + phone + '\'' +
                ", idcard='" + idcard + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public UserInfo() {
    }

    public UserInfo(int userid, String username, int sex, String phone, String idcard, String address) {
        this.userid = userid;
        this.username = username;
        this.sex = sex;
        this.phone = phone;
        this.idcard = idcard;
        this.address = address;
    }


    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

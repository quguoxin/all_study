package day08;

public class Person {
    private String name;
    private int age;
    private String school;
    private String major;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Person(String n,int a){
        this.name="新哥";
        this.age=18;
    }

    public Person(String n,int a,String s){
        this.name="新哥";
        this.age=18;
        this.school="清华大学";
    }
    public Person(String n,int a,String s,String m){
        this.name="新哥";
        this.age=18;
        this.school="清华大学";
        this.major="机械设计制造及其自动化";
    }
    public void show(){
        System.out.println("姓名："+name+"\n年龄："+age+"\n学校："+school+"\n专业："+major);
    }

}

package day16;

import org.omg.CORBA.Object;

import java.util.Objects;

public class Student implements Comparable<Student>{
    private int no;
    private String name;
    private double grade;

    public int compareTo(Student anotherStudent){
        if(this.grade<anotherStudent.grade){
            return -1;
        }else if(this.grade>anotherStudent.grade){
            return 1;
        }else {
            if(this.no<anotherStudent.no){
                return -1;
            }else {
                return 1;
            }
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }

    @Override
    public int hashCode() {
        return no+name.hashCode()+(int) grade;
    }

    @Override
    public boolean equals(java.lang.Object obj) {
        if(obj instanceof Student){
            Student another=(Student)obj;
            if(this.no==another.no&&this.name.equals(another.name)&&this.grade==another.grade){
                return true;
            }
        }
        return false;
    }

    public Student() {
    }

    public Student(int no, String name, double grade) {
        this.no = no;
        this.name = name;
        this.grade = grade;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}

package day24.t2;

import day24.ColorName;

@Table(tableName = "student")
public class Student {

    @Column(name = "student_no",isNull=false)
    private int studentNo;

    @Column(name = "student_name",size=50)
    private String studentName;
}

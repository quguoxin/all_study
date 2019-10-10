package entity;

import java.util.Date;

public class ExamResult {
    private int id;
    private String  studentno;
    private int subjectid;
    private int studentresult;
    private Date examdate;


    @Override
    public String toString() {
        return "ExamResult{" +
                "id=" + id +
                ", studentno='" + studentno + '\'' +
                ", subjectid=" + subjectid +
                ", studentresult=" + studentresult +
                ", examdate=" + examdate +
                '}';
    }

    public ExamResult() {
    }

    public ExamResult(int id, String studentno, int subjectid, int studentresult, Date examdate) {
        this.id = id;
        this.studentno = studentno;
        this.subjectid = subjectid;
        this.studentresult = studentresult;
        this.examdate = examdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentno() {
        return studentno;
    }

    public void setStudentno(String studentno) {
        this.studentno = studentno;
    }

    public int getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(int subjectid) {
        this.subjectid = subjectid;
    }

    public int getStudentresult() {
        return studentresult;
    }

    public void setStudentresult(int studentresult) {
        this.studentresult = studentresult;
    }

    public Date getExamdate() {
        return examdate;
    }

    public void setExamdate(Date examdate) {
        this.examdate = examdate;
    }
}

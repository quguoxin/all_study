package entity;

public class Subject {
    private  int subjectid;
    private  String subjectname;
    private  int classhour;
    private  int gradeid;


    @Override
    public String toString() {
        return "Subject{" +
                "subjectid=" + subjectid +
                ", subjectname='" + subjectname + '\'' +
                ", classhour=" + classhour +
                ", gradeid=" + gradeid +
                '}';
    }

    public Subject() {
    }

    public Subject(int subjectid, String subjectname, int classhour, int gradeid) {
        this.subjectid = subjectid;
        this.subjectname = subjectname;
        this.classhour = classhour;
        this.gradeid = gradeid;
    }

    public int getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(int subjectid) {
        this.subjectid = subjectid;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    public int getClasshour() {
        return classhour;
    }

    public void setClasshour(int classhour) {
        this.classhour = classhour;
    }

    public int getGradeid() {
        return gradeid;
    }

    public void setGradeid(int gradeid) {
        this.gradeid = gradeid;
    }
}

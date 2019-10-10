package day20;

public class StudentIfo {
    /*"FlowId INT AUTO_INCREMENT PRIMARY KEY COMMENT '流水号',\n" +
            "`Type` INT COMMENT '四级/六级',\n" +
            "IdCard VARCHAR(18) UNIQUE COMMENT '身份证号码',\n" +
            "ExamCard VARCHAR(15) UNIQUE COMMENT '准考证号码',\n" +
            "StudentName VARCHAR(20) COMMENT '学生姓名',\n" +
            "Location VARCHAR(20) COMMENT '区域',\n" +
            "Grade INT COMMENT '成绩'\n" +*/
    public  int type;
    public String idCard;
    public String examCard;
    public String studentName;
    public String location;
    public String grade;

    public StudentIfo() {
    }

    public StudentIfo(int type, String idCard, String examCard, String studentName, String location, String grade) {
        this.type = type;
        this.idCard = idCard;
        this.examCard = examCard;
        this.studentName = studentName;
        this.location = location;
        this.grade = grade;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getExamCard() {
        return examCard;
    }

    public void setExamCard(String examCard) {
        this.examCard = examCard;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

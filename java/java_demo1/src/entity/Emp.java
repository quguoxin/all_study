package entity;

public class Emp {
    private int empNo;
    private String eName;
    private String job;
    private int deptNo;

    @Override
    public String toString() {
        return "Emp{" +
                "empNo=" + empNo +
                ", eName='" + eName + '\'' +
                ", job='" + job + '\'' +
                ", deptNo=" + deptNo +
                '}';
    }

    public Emp() {
    }

    public Emp(int empNo, String eName, String job, int deptNo) {
        this.empNo = empNo;
        this.eName = eName;
        this.job = job;
        this.deptNo = deptNo;
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }
}

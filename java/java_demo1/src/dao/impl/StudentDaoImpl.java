package dao.impl;

import dao.StudentDao;
import entity.Grade;
import entity.Student;
import util.JdbcUtil;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentDaoImpl extends JdbcUtil implements StudentDao {
    @Override
    public int add(Student student) {
        Object[] params={student.getStudentno(),
                         student.getLoginpwd(),
                         student.getStudentname(),
                         student.getSex(),
                         student.getGradeid(),
                         student.getPhone(),
                         student.getAdress(),
                         student.getBorndate(),
                         student.getEmail()};
        String sql="insert into student values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return super.commonUpdate(sql,params);
    }

    @Override
    public int update(Student student) {
        Object[] params={student.getPhone(),student.getStudentno()};
        String sql="update student set phone = ? where studentno = ?";
        return super.commonUpdate(sql,params);
    }

    @Override
    public int delete(String studentNo) {
        Object[] params={studentNo};
        String sql="delete student where studentno = ?";
        return super.commonUpdate(sql,params);
    }

    @Override
    public List findAll() {
        Object[] params={};
        List<Student> list=new ArrayList<Student>();
        String sql="select * from  student";
        ResultSet resultSet= super.commonQuery(sql,params);
        try {
            while (resultSet.next()){
                String studentNo=resultSet.getString("studentno");
                String loginPwd=resultSet.getString("loginpwd");
                String studentName=resultSet.getString("studentname");
                String  sex=resultSet.getString("sex");
                int gradeId=resultSet.getInt("gradeid");
                String phone=resultSet.getString("phone");
                String adress=resultSet.getString("adress");
                Date bornDate=resultSet.getDate("borndate");
                String email=resultSet.getString("email");
                list.add(new Student(studentNo,loginPwd,studentName,sex,gradeId,phone,adress,bornDate,email));
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Student findById(String studentNo) {
        Student student=null;
        Object[] params={studentNo};
        String sql="select * from  student where studentno=? ";
        ResultSet resultSet= super.commonQuery(sql,params);
        try{
            if(resultSet.next()){
                String loginPwd=resultSet.getString("loginpwd");
                String studentName=resultSet.getString("studentname");
                String  sex=resultSet.getString("sex");
                int gradeId=resultSet.getInt("gradeid");
                String phone=resultSet.getString("phone");
                String adress=resultSet.getString("adress");
                Date bornDate=resultSet.getDate("borndate");
                String email=resultSet.getString("email");
                student=new Student(studentNo,loginPwd,studentName,sex,gradeId,phone,adress,bornDate,email);
            }
            return student;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

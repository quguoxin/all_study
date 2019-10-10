package dao;

import entity.Grade;
import entity.Student;

import java.util.List;

public interface StudentDao {
    //  add  update   delete     read
    //增
    public int add(Student student);
    //改
    public int update(Student student);
    //删
    public int delete(String studentNo);
    //查
    public List findAll();
    //定点查
    public Student findById(String studentNo);
}

package dao;


import entity.Subject;
import java.util.List;

public interface SubjectDao {
    //  add  update   delete     read
    //增
    public int add(Subject subject);
    //改
    public int update(Subject subject);
    //删
    public int delete(int subjectId);
    //查
    public List findAll();
    //定点查
    public Subject findById(int subjectId);
}

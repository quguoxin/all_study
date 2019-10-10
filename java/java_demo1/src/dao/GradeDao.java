package dao;

import entity.Grade;

import java.util.List;

public interface GradeDao {
    //  add  update   delete     read
    //增
    public int add(Grade grade);
    //改
    public int update( Grade grade);
    //删
    public int delete(int gradeId);
    //查
    public List findAll();
    //定点查
    public Grade findById(int gradeId);

}

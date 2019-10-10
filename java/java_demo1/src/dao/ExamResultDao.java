package dao;

import entity.ExamResult;
import java.util.List;

public interface ExamResultDao {
    //  add  update   delete     read
    //增
    public int add(ExamResult examResult);
    //改
    public int update(ExamResult examResult);
    //删
    public int delete(int id);
    //查
    public List findAll();
    //定点查
    public ExamResult findById(int id);
}

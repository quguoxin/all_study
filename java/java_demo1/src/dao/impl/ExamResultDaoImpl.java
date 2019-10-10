package dao.impl;

import dao.ExamResultDao;
import entity.ExamResult;
import util.JdbcUtil;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExamResultDaoImpl extends JdbcUtil implements ExamResultDao {
    @Override
    public int add(ExamResult examResult) {
        Object[] params={examResult.getStudentno(),examResult.getSubjectid(),examResult.getStudentresult(),examResult.getExamdate()};
        String sql="insert into result values (seq_result.nextval,? ,? ,?,? )";
        return super.commonUpdate(sql,params);
    }

    @Override
    public int update(ExamResult examResult) {
        Object[] params={examResult.getStudentresult(),examResult.getId()};
        String sql="update result set studentresult = ? where id = ?";
        return super.commonUpdate(sql,params);
    }

    @Override
    public int delete(int id) {
        Object[] params={id};
        String sql="delete result where id = ?";
        return super.commonUpdate(sql,params);
    }

    @Override
    public List findAll() {
        Object[] params={};
        List<ExamResult> list=new ArrayList<ExamResult>();
        String sql="select * from  result";
        ResultSet resultSet= super.commonQuery(sql,params);
        try {
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String  studentNo=resultSet.getString("studentno");
                int subjectId=resultSet.getInt("subjectid");
                int studentResult=resultSet.getInt("studentresult");
                Date examdate=resultSet.getDate("examdate");
                list.add(new ExamResult(id,studentNo,subjectId,studentResult,examdate));
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ExamResult findById(int id) {
        ExamResult examResult=null;
        Object[] params={id};
        String sql="select * from  result where id=? ";
        ResultSet resultSet= super.commonQuery(sql,params);
        try{
            if(resultSet.next()){
                String  studentNo=resultSet.getString("studentno");
                int subjectId=resultSet.getInt("subjectid");
                int studentResult=resultSet.getInt("studentresult");
                Date examdate=resultSet.getDate("examdate");
                examResult=new ExamResult(id,studentNo,subjectId,studentResult,examdate);
            }
            return examResult;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

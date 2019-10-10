package dao.impl;

import dao.SubjectDao;
import entity.Subject;
import util.JdbcUtil;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SubjectDaoImpl extends JdbcUtil implements SubjectDao{
    @Override
    public int add(Subject subject) {
        Object[] params={subject.getSubjectname(),subject.getClasshour(),subject.getGradeid()};
        String sql="insert into subject values (seq_subject.nextval, ?, ?, ?)";
        return super.commonUpdate(sql,params);
    }

    @Override
    public int update(Subject subject) {
        Object[] params={subject.getClasshour(),subject.getSubjectid()};
        String sql="update subject set classhour = ? where subjectid = ?";
        return super.commonUpdate(sql,params);
    }

    @Override
    public int delete(int subjectId) {
        Object[] params={subjectId};
        String sql="delete subject where subjectid = ?";
        return super.commonUpdate(sql,params);
    }

    @Override
    public List findAll() {
        Object[] params={};
        List<Subject> list=new ArrayList<Subject>();
        String sql="select * from  subject";
        ResultSet resultSet= super.commonQuery(sql,params);
        try {
            while (resultSet.next()){
                int subjectId=resultSet.getInt("subjectid");
                String subjectName=resultSet.getString("subjectname");
                int classhour=resultSet.getInt("classhour");
                int gradeId=resultSet.getInt("gradeid");
                list.add(new Subject(subjectId,subjectName,classhour,gradeId));
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Subject findById(int subjectId) {
        Subject subject=null;
        Object[] params={subjectId};
        String sql="select * from  subject where subjectid=? ";
        ResultSet resultSet= super.commonQuery(sql,params);
        try{
            if(resultSet.next()){
                String subjectName=resultSet.getString("subjectname");
                int classhour=resultSet.getInt("classhour");
                int gradeId=resultSet.getInt("gradeid");
                subject=new Subject(subjectId,subjectName,classhour,gradeId);
            }
            return subject;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

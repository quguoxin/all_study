package dao.impl;

import dao.GradeDao;
import entity.Grade;
import util.JdbcUtil;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GradeDaoImpl extends JdbcUtil implements GradeDao{

    //增
    @Override
    public int add( Grade grade) {
        Object[] params={grade.getGradeName()};
        String sql="insert into grade values (seq_grade.nextval, ?)";
        return super.commonUpdate(sql,params);
    }

    //改
    @Override
    public int update(Grade grade) {
        Object[] params={grade.getGradeName(),grade.getGradeId()};
        String sql="update grade set gradename = ? where gradeid = ?";
        return super.commonUpdate(sql,params);
    }

    //删
    @Override
    public int delete( int gradeId) {
        Object[] params={gradeId};
        String sql="delete grade where gradeid = ?";
        return super.commonUpdate(sql,params);
    }

    //查全部
    @Override
    public List findAll() {
        Object[] params={};
        List<Grade> list=new ArrayList<Grade>();
        String sql="select * from  grade";
        ResultSet resultSet= super.commonQuery(sql,params);
        try {
            while (resultSet.next()){
                int gradeId=resultSet.getInt("gradeid");
                String gradeName =resultSet.getString("gradename");
                list.add(new Grade(gradeId,gradeName));
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //定点查
    @Override
    public Grade findById(int gradeId) {
        Grade grade=null;
        Object[] params={gradeId};
        String sql="select * from  grade where gradeid=? ";
        ResultSet resultSet= super.commonQuery(sql,params);
        try{
            if(resultSet.next()){
                String gradeName =resultSet.getString("gradename");
                grade=new Grade(gradeId,gradeName);
            }
            return grade;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

package dao.impl;

import dao.EmpDao;
import entity.Emp;
import oracle.jdbc.OracleTypes;
import oracle.jdbc.oracore.OracleType;
import util.JdbcUtil;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDaoImpl extends JdbcUtil implements EmpDao{
    @Override
    public List<Emp> getEmp(String job) {
        Connection connection=super.getCon();
        String sql ="call pro_emp(?,?)";
        try {
            CallableStatement cs=connection.prepareCall(sql);
            //设置参数
            //输入参数
            cs.setString(1,job);
            //输出参数
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.executeQuery();//直接执行，无需管执行结果
            ResultSet resultSet=(ResultSet) cs.getObject(2);//
            List<Emp> list=new ArrayList<Emp>();
            while (resultSet.next()){
                int empNo=resultSet.getInt("empno");
                String eName=resultSet.getString("ename");
                String jobs=resultSet.getString("job");
                int deptNo=resultSet.getInt("deptno");
                list.add(new Emp(empNo,eName,jobs,deptNo));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }
}

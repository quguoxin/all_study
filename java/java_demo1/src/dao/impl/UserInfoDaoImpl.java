package dao.impl;

import dao.UserInfoDao;
import entity.UserInfo;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.JdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserInfoDaoImpl extends JdbcUtil implements UserInfoDao{
    @Override
    public List<UserInfo> getLossUers(String sql) {
        Connection connection=super.getCon();
        QueryRunner queryRunner=new QueryRunner();
        try {
            List<UserInfo> list=queryRunner.query(connection,sql,new BeanListHandler<UserInfo>(UserInfo.class));
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  null;
    }
}

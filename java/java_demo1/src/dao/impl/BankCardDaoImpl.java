package dao.impl;

import dao.BankCardDao;
import entity.BankCard;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.JdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BankCardDaoImpl extends JdbcUtil implements BankCardDao {
    @Override
    public List<BankCard> getBankCardNo() {
        Connection connection =super.getCon();
        String sql="select * from bankcard t where t.opendate between " +
                "'17-6月-2018' and '23-6月-2018'";
        QueryRunner queryRunner=new QueryRunner();
        try {
            List<BankCard> list=queryRunner.query
                    (connection,sql,new BeanListHandler<BankCard>(BankCard.class));
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbUtils.closeQuietly(connection);
        }

        return null;
    }
}

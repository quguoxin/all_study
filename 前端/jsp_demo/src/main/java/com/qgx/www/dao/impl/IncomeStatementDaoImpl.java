package com.qgx.www.dao.impl;

import com.qgx.www.dao.IncomeStatementDao;
import com.qgx.www.entity.Income_statement;
import com.qgx.www.util.DBUtils;


import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class IncomeStatementDaoImpl extends DBUtils implements IncomeStatementDao {
    @Override
    public List<Income_statement> findCardNoByIncomeStatement(String cardNo) {
        String sql="select * from income_statement where cardNo=? ";
        return super.getAll( Income_statement.class,sql,cardNo );
    }

    @Override
    public int recharge(String cardNo, double balance,double rmb_balance) {
            /*String sql = "SELECT * FROM income_statement WHERE cardNo=?";
            Income_statement income_statement= super.getOne(Income_statement.class,sql,cardNo);
            double money= income_statement.getBalance()+balance;//这边抛出了异常，先解决这边
            String sql1="UPDATE income_statement SET income=?, balance=? WHERE cardNo=?";
            return super.update(sql1,balance,money,cardNo);*/
            //向数据库增加一条数据
            String sql="INSERT INTO income_statement (create_date,cardNo,income,balance,detail) VALUES (?,?,?,?,?)";
            Object[] params={new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()),cardNo,balance,balance+rmb_balance,"充值"};
            return super.update(sql,params);

            //增加改变userinfo余额
        }


 /*   @Override
    public int addIncome_statement(Income_statement income_statement) {//充值记录
        Date date = new Date();
        SimpleDateFormat simpleDateFormat   = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime = simpleDateFormat.format(date);
        String sql = "INSERT INTO `income_statement` (`create_date`,`cardNo`,`income`,`expend`,`balance`,`detail`) VALUES(?,?,?,?,?,?)";
        int n = super.update(sql,nowTime,income_statement.getCardNo(),income_statement.getIncome(),income_statement.getExpend(),income_statement.getBalance(),income_statement.getDetail());
        return n;
    }*/

}

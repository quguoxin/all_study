package com.qgx.www.dao;


import com.qgx.www.entity.Income_statement;

import java.util.List;

public interface IncomeStatementDao {
    //查询卡号
    public List<Income_statement> findCardNoByIncomeStatement(String cardNo);

    public int recharge(String cardNo, double balance,double Rmb_balance);

/*//充值记录
    public int addIncome_statement(Income_statement income_statement);*/
}

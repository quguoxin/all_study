package com.qgx.www.service.impl;


import com.qgx.www.dao.IncomeStatementDao;
import com.qgx.www.dao.impl.IncomeStatementDaoImpl;
import com.qgx.www.entity.Income_statement;
import com.qgx.www.service.IncomeStatementService;

import java.util.List;


public class IncomeStatementServiceImpl implements IncomeStatementService {
    IncomeStatementDao incomeStatementDao=new IncomeStatementDaoImpl();

    @Override
    public List<Income_statement> findCardNoByIncomeStatement(String cardNo) {
        return incomeStatementDao.findCardNoByIncomeStatement(cardNo);
    }

    @Override
    public int recharge(String cardNo, double balance,double rmb_balance) {
        return  incomeStatementDao.recharge(cardNo,balance,rmb_balance);
    }

   /* @Override
    public int addIncome_statement(Income_statement income_statement) {
        return incomeStatementDao.addIncome_statement(income_statement);
    }*/


}

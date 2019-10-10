package dao;

import entity.BankCard;

import java.util.List;

public interface BankCardDao {
    //本周开户
    public List<BankCard>  getBankCardNo();
}

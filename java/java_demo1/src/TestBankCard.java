import dao.BankCardDao;
import dao.impl.BankCardDaoImpl;
import entity.BankCard;

import java.util.List;

public class TestBankCard {
    public static void main(String[] args) {
        BankCardDao bankCardDao=new BankCardDaoImpl();
        List<BankCard> list=bankCardDao.getBankCardNo();
        for(BankCard bankCard:list){
            System.out.println(bankCard.toString());
        }
    }
}

package day21;

/**
 * Created by Administrator on 2018/6/7.
 */
public interface BankService {
    //登录
    public boolean login(String cardno, String pwd);

    //1.存钱
    public int saveMoney(String cardno, double money);

    //2.取钱
    public int giveMoney(String cardno, double money);

    //3.转账
    public int transferMoney(String from, String to, double money);

    //4.查询余额
    public void showBalance(String cardno);


}

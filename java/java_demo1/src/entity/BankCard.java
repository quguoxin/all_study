package entity;

import java.sql.Timestamp;
import java.util.Date;

public class BankCard {
    private String bankcardno;
    private int userid;
    private String  tradepassword;
    private int  currencytypeid;
    private double  balance;
    private double  openmoney;
    private String opendate;
    private int  isloss;
    private int  savingid;
    private double  availbalance;

    @Override
    public String toString() {
        return "BankCard{" +
                "bankcardno='" + bankcardno + '\'' +
                ", userid=" + userid +
                ", tradepassword='" + tradepassword + '\'' +
                ", currencytypeid=" + currencytypeid +
                ", balance=" + balance +
                ", openmoney=" + openmoney +
                ", opendate=" + opendate +
                ", isloss=" + isloss +
                ", savingid=" + savingid +
                ", availbalance=" + availbalance +
                '}';
    }

    public BankCard() {
    }

    public BankCard(String bankcardno, int userid, String tradepassword, int currencytypeid, double balance, double openmoney, String opendate, int isloss, int savingid, double availbalance) {
        this.bankcardno = bankcardno;
        this.userid = userid;
        this.tradepassword = tradepassword;
        this.currencytypeid = currencytypeid;
        this.balance = balance;
        this.openmoney = openmoney;
        this.opendate = opendate;
        this.isloss = isloss;
        this.savingid = savingid;
        this.availbalance = availbalance;
    }

    public String getBankcardno() {
        return bankcardno;
    }

    public void setBankcardno(String bankcardno) {
        this.bankcardno = bankcardno;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getTradepassword() {
        return tradepassword;
    }

    public void setTradepassword(String tradepassword) {
        this.tradepassword = tradepassword;
    }

    public int getCurrencytypeid() {
        return currencytypeid;
    }

    public void setCurrencytypeid(int currencytypeid) {
        this.currencytypeid = currencytypeid;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getOpenmoney() {
        return openmoney;
    }

    public void setOpenmoney(double openmoney) {
        this.openmoney = openmoney;
    }

    public String getOpendate() {
        return opendate;
    }

    public void setOpendate(String opendate) {
        this.opendate = opendate;
    }

    public int getIsloss() {
        return isloss;
    }

    public void setIsloss(int isloss) {
        this.isloss = isloss;
    }

    public int getSavingid() {
        return savingid;
    }

    public void setSavingid(int savingid) {
        this.savingid = savingid;
    }

    public double getAvailbalance() {
        return availbalance;
    }

    public void setAvailbalance(double availbalance) {
        this.availbalance = availbalance;
    }
}

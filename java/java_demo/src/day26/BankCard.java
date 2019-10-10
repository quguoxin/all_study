package day26;

import java.util.Date;

public class BankCard {
    private String bankCardNo;
    private double balance;
    private String userName;
    private String openDate;
    private String currentType;


    @Override
    public String toString() {
        return "BankCard{" +
                "bankCardNo='" + bankCardNo + '\'' +
                ", balance=" + balance +
                ", userName='" + userName + '\'' +
                ", openDate='" + openDate + '\'' +
                ", currentType='" + currentType + '\'' +
                '}';
    }

    public BankCard() {
    }

    public BankCard(String bankCardNo, double balance, String userName, String openDate, String currentType) {
        this.bankCardNo = bankCardNo;
        this.balance = balance;
        this.userName = userName;
        this.openDate = openDate;
        this.currentType = currentType;
    }

    public String getBankCardNo() {
        return bankCardNo;
    }

    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public String getCurrentType() {
        return currentType;
    }

    public void setCurrentType(String currentType) {
        this.currentType = currentType;
    }
}

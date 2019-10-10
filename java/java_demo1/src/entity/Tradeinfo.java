package entity;

import java.util.Date;

public class Tradeinfo {
/*    -- Name            Type           Nullable  Default  Comments
-- TRADENO         VARCHAR2(50)                      交易流水：tryyyyMMddhhmmss+6位随机数
-- TRADEDATE       TIMESTAMP(6)                      交易日期
-- TRADETYPE       NUMBER(11)                        交易类型：1存款，2取款，3转账，4收入
-- TRADECARDID     VARCHAR2(19)                      卡号
-- ACCEPTCARDID    VARCHAR2(19)   Y                  对方账号，转账时使用，其他交易类型可为空
-- TRADEMONEY      NUMBER(20,2)                      交易金额
-- CURRENCYTYPEID  NUMBER(11)                        交易币种
-- TRADEDIRECTION  NUMBER(11)     Y                  交易方向：-1出账1入账
-- REMARK          VARCHAR2(200)  Y                  备注*/


    private String tradeNo;
    private Date tradeDate;
    private int tradeType;
    private String tradeCardId;
    private String acceptCardId;
    private double tradeMoney;
    private int currencyTypeId;
    private int tradeDirection;
    private String remark;

    @Override
    public String toString() {
        return "Tradeinfo{" +
                "tradeNo='" + tradeNo + '\'' +
                ", tradeDate=" + tradeDate +
                ", tradeType=" + tradeType +
                ", tradeCardId='" + tradeCardId + '\'' +
                ", acceptCardId='" + acceptCardId + '\'' +
                ", tradeMoney=" + tradeMoney +
                ", currencyTypeId=" + currencyTypeId +
                ", tradeDirection=" + tradeDirection +
                ", remark='" + remark + '\'' +
                '}';
    }

    public Tradeinfo() {
    }

    public Tradeinfo(String tradeNo, Date tradeDate, int tradeType, String tradeCardId, String acceptCardId, double tradeMoney, int currencyTypeId, int tradeDirection, String remark) {
        this.tradeNo = tradeNo;
        this.tradeDate = tradeDate;
        this.tradeType = tradeType;
        this.tradeCardId = tradeCardId;
        this.acceptCardId = acceptCardId;
        this.tradeMoney = tradeMoney;
        this.currencyTypeId = currencyTypeId;
        this.tradeDirection = tradeDirection;
        this.remark = remark;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public Date getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(Date tradeDate) {
        this.tradeDate = tradeDate;
    }

    public int getTradeType() {
        return tradeType;
    }

    public void setTradeType(int tradeType) {
        this.tradeType = tradeType;
    }

    public String getTradeCardId() {
        return tradeCardId;
    }

    public void setTradeCardId(String tradeCardId) {
        this.tradeCardId = tradeCardId;
    }

    public String getAcceptCardId() {
        return acceptCardId;
    }

    public void setAcceptCardId(String acceptCardId) {
        this.acceptCardId = acceptCardId;
    }

    public double getTradeMoney() {
        return tradeMoney;
    }

    public void setTradeMoney(double tradeMoney) {
        this.tradeMoney = tradeMoney;
    }

    public int getCurrencyTypeId() {
        return currencyTypeId;
    }

    public void setCurrencyTypeId(int currencyTypeId) {
        this.currencyTypeId = currencyTypeId;
    }

    public int getTradeDirection() {
        return tradeDirection;
    }

    public void setTradeDirection(int tradeDirection) {
        this.tradeDirection = tradeDirection;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}

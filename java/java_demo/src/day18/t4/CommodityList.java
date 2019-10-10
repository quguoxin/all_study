package day18.t4;

import com.sun.xml.internal.ws.developer.Serialization;

import java.io.Serializable;

/**
 * 商品清单
 */
public  class CommodityList{
    private String commodityNo;
    private String commodityName;
    private String commodityPrice;
    private String commodityNumber;

    public CommodityList() {
    }

    public CommodityList(String commodityNo, String commodityName, String commodityPrice, String commodityNumber) {
        this.commodityNo = commodityNo;
        this.commodityName = commodityName;
        this.commodityPrice = commodityPrice;
        this.commodityNumber = commodityNumber;

    }

    public String getCommodityNo() {
        return commodityNo;
    }

    public void setCommodityNo(String commodityNo) {
        this.commodityNo = commodityNo;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getCommodityPrice() {
        return commodityPrice;
    }

    public void setCommodityPrice(String commodityPrice) {
        this.commodityPrice = commodityPrice;
    }

    public String getCommodityNumber() {
        return commodityNumber;
    }

    public void setCommodityNumber(String commodityNumber) {
        this.commodityNumber = commodityNumber;
    }

}

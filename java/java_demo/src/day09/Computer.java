package day09;

/**
 * 借
 */

public class Computer {
    //电脑属性：名字   价格    库存
    private String name1;
    private String name2;
    private String name3;
    private double price1;
    private double price2;
    private double price3;
    private int amount1;
    private int amount2;
    private int amount3;

    //封装


    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getName3() {
        return name3;
    }

    public void setName3(String name3) {
        this.name3 = name3;
    }

    public double getPrice1() {
        return price1;
    }

    public void setPrice1(double price1) {
        this.price1 = price1;
    }

    public double getPrice2() {
        return price2;
    }

    public void setPrice2(double price2) {
        this.price2 = price2;
    }

    public double getPrice3() {
        return price3;
    }

    public void setPrice3(double price3) {
        this.price3 = price3;
    }

    public int getAmount1() {
        return amount1;
    }

    public void setAmount1(int amount1) {
        this.amount1 = amount1;
    }

    public int getAmount2() {
        return amount2;
    }

    public void setAmount2(int amount2) {
        this.amount2 = amount2;
    }

    public int getAmount3() {
        return amount3;
    }

    public void setAmount3(int amount3) {
        this.amount3 = amount3;
    }

    //无参够造
    public Computer(){

    }
    //有参构造
    public Computer(String name1, String name2, String name3, double price1, double price2, double price3, int amount1, int amount2, int amount3) {
        this.name1 = name1;
        this.name2 = name2;
        this.name3 = name3;
        this.price1 = price1;
        this.price2 = price2;
        this.price3 = price3;
        this.amount1 = amount1;
        this.amount2 = amount2;
        this.amount3 = amount3;
    }
}

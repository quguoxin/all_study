package day22;

public class PhoneInf {
    private String model;
    private  double price;
    private  double dayPrice;
    private  int store;

    @Override
    public String toString() {
        return
                "型号：" + model + "  价格：" + price + "  日租价格：" + dayPrice + "  库存：" + store ;
    }

    public PhoneInf() {
    }

    public PhoneInf(String model, double price, double dayPrice, int store) {
        this.model = model;
        this.price = price;
        this.dayPrice = dayPrice;
        this.store = store;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDayPrice() {
        return dayPrice;
    }

    public void setDayPrice(double dayPrice) {
        this.dayPrice = dayPrice;
    }

    public int getStore() {
        return store;
    }

    public void setStore(int store) {
        this.store = store;
    }
}

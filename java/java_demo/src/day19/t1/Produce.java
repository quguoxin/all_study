package day19.t1;

import java.io.Serializable;

public class Produce implements Serializable{
    private static final long serialVersionUID = 6350827120970370950L;
    private String produceName;
    private double producePrice;
    private int produceNumber;

    @Override
    public String toString() {
        return produceName+"\t\t"+producePrice + "\t\t"+ produceNumber ;

    }

    public Produce() {
    }

    public Produce(String produceName, double producePrice, int produceNumber) {
        this.produceName = produceName;
        this.producePrice = producePrice;
        this.produceNumber = produceNumber;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getProduceName() {
        return produceName;
    }

    public void setProduceName(String produceName) {
        this.produceName = produceName;
    }

    public double getProducePrice() {
        return producePrice;
    }

    public void setProducePrice(double producePrice) {
        this.producePrice = producePrice;
    }

    public int getProduceNumber() {
        return produceNumber;
    }

    public void setProduceNumber(int produceNumber) {
        this.produceNumber = produceNumber;
    }
}

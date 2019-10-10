package day11.T4;

public class Tractors extends MotoVehicle{
    private int bambooHat;

    public int getBambooHat() {
        return bambooHat;
    }

    public void setBambooHat(int bambooHat) {
        this.bambooHat = bambooHat;
    }

    public Tractors(int bambooHat) {
        this.bambooHat = bambooHat;
    }

    public Tractors(String no, String brand, String color, double mileage, int bambooHat) {
        super(no, brand, color, mileage);
        this.bambooHat = bambooHat;
    }

    @Override
    public double calcRent(int days) {
        double price=0;
        if(bambooHat==1){
            price=200;
        }else if(bambooHat==2){
            price=300;
        }else if(bambooHat==3){
            price=500;
        }
        return price*days;
    }
}

package day11.T4;

public class Car extends MotoVehicle {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public Car() {
    }

    public Car(String type) {
        this.type = type;
    }

    public Car(String no, String brand, String color, double mileage, String type) {
        super(no, brand, color, mileage);
        this.type = type;
    }

    @Override
    public double calcRent(int days) {
        double price=0;
        if(type.equals("别克商务舱GL8")){
           price=600;
        }else if(type.equals("宝马550i")){
            price=500;
        }else if(type.equals("别克林荫大道")){
            price=300;
        }
        return price*days;
    }
}

package day11.T4;

public class Bus extends MotoVehicle {
    private int seatCount;

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public Bus() {
    }

    public Bus(int seatCount) {
        this.seatCount = seatCount;
    }

    public Bus(String no, String brand, String color, double mileage, int seatCount) {
        super(no, brand, color, mileage);
        this.seatCount = seatCount;
    }


    @Override
    public double calcRent(int days) {
        double price=0;
        if(seatCount<=16){
           price=800;
        }else {
            price=1500;
        }
        return price*days;
    }
}

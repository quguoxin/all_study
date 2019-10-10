package day06;

public class Cup {
    String shape;
    String colour;
    double weight;
    double capacity;
    public void water(){
        System.out.println(shape+colour+"重"+weight+"g，容量"+capacity+"L的杯子可以盛水");
    }

    public void makeTea(){
        System.out.println(shape+colour+"重"+weight+"g，容量"+capacity+"L的杯子可以泡茶");
    }
}

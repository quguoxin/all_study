package day11.T3;

public class GeometricObject {
    protected String color;
    protected double weight;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    protected GeometricObject() {
        color="white";
        weight=1.0;
    }

    protected GeometricObject(String color, double weight) {
        this.color =color;
        this.weight =weight;
    }
}

package day10.t3;

public class Cylinder extends Circle {
    private double length;

    public Cylinder() {

    }

    public Cylinder(double radius, double length) {
        super(radius);
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double findVolume(){
        return super.findArea()*length;
    }

    public double findArea(){
        return super.findArea()*2+getRadius()*2*3.14*length;
    }
}

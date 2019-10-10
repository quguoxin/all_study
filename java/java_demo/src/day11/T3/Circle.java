package day11.T3;

import java.util.Objects;

public class Circle extends GeometricObject {
    private double radius;

    public Circle(){

    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius,String color,double weight){
        this.radius=radius;
        this.color=color;
        this.weight=weight;
    }

    public double findArea(){//面积
        return 3.14*radius*radius;
    }


    @Override
    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }
        if(obj instanceof Circle){
            Circle circle=(Circle)obj;
            if(this.radius==circle.radius){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "半径 radius=" + radius;

    }


    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}

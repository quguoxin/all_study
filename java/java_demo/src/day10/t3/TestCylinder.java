package day10.t3;

public class TestCylinder {
    public static void main(String[] args) {

        //利用set设置园的半径和高
        /*Cylinder cylinder=new Cylinder();
        cylinder.setLength(1);
        cylinder.setRadius(1);
        System.out.println("圆柱体积："+cylinder.findVolume()+"\n表面积："+cylinder.findArea());


        Circle circle=new Circle();
        circle.setRadius(1);
        System.out.println("表面积："+circle.findArea());*/

        //利用构造方法设置半径和高
         Cylinder cylinder=new Cylinder(1,1);
        System.out.println("圆柱体积："+cylinder.findVolume()+"\n表面积："+cylinder.findArea());





    }


}

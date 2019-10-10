package day11.T3;

public class Test {
    public static void main(String[] args) {
        Circle circle1=new Circle(1.0);
        Circle circle2=new Circle(2.0);
        //判断颜色
        System.out.println("颜色相等吗？===》"+ circle1.getColor().equals(circle2.getColor()));
        //利用equals判断半径
        System.out.println("半径相等吗？===》"+circle1.equals(circle2));
        //输出半径
        System.out.println("圆1"+circle1.toString());
        System.out.println("圆2"+circle2.toString());
    }
}

package day06;

public class People {
    public static void main(String[] args) {

        Human gongShengWei=new Human();
        gongShengWei.name="龚胜伟";
        gongShengWei.age=27;
        gongShengWei.sex="男";
        gongShengWei.height=165;
        gongShengWei.weigth=150;

        gongShengWei.eat();
        gongShengWei.sleep();
        gongShengWei.snore();

    }
}

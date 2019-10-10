package day11.T1;

public class Breeder {

    public void feed(Animal food){
        if(food instanceof Tiger){
            Tiger tiger=(Tiger)food;
            tiger.eat();
        }else if(food instanceof Shark){
            Shark shark=(Shark)food;
            shark.eat();
        }
    }

    public static void main(String[] args) {
        Breeder breeder=new Breeder();
        breeder.feed(new Shark());
    }
}

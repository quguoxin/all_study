package day06;

public class VacuumCup {
    public static void main(String[] args) {
        Cup vacuumCup=new Cup();
        vacuumCup.shape="圆柱形";
        vacuumCup.colour="白色";
        vacuumCup.weight=20;
        vacuumCup.capacity=1;

        vacuumCup.water();
        vacuumCup.makeTea();
    }
}

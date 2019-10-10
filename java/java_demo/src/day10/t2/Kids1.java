package day10.t2;

public class Kids1 extends ManKind {
    private int yearsOld;

    public String employeed(int salary){
        return super.employeed(salary)+",but Kids should study and no job.";
    }
    public int printAge(int yearsOld){
        return yearsOld;
    }
}

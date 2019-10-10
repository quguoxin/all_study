package day10.t2;

public class ManKind {
    private int sex;
    private int salary;
    public String  manOrWorman(int sex){
        if(sex==1){
            return "man";
        }else {
            return "woman";
        }
    }

    public String employeed(int salary){
        if(salary==0){
            return "no job";
        }else {
            return "job";
        }
    }
}

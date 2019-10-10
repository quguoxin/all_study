package day08;

public class School {
    private String name;
    private int num;
    private String place;




    public String getName() {
        return name;
    }

    public int getNum() {
        return num;
    }

    public String getPlace() {
        return place;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public School() {
        this.name = "qgx";
        this.num = 17;
        this.place = "深圳";
    }
    public School(String name){
        this.name=name;
    }
    public School(String name,int num){
        this.name=name;
        this.num=num;
    }
    public School(String name, int num, String place){
        this.name=name;
        this.num=num;
        this.place=place;

    }
    public void show(){
        System.out.println(name+"\n"+num+"\n"+place);
    }
}

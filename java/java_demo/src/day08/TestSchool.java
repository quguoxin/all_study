package day08;

public class TestSchool {
    public static void main(String[] args) {
        School testSchool1=new School();
        testSchool1.show();

        School testSchool2=new School("ssds");
        testSchool2.show();

        School testSchool3=new School("ssds",1);
        testSchool3.show();

        School testSchool4=new School("ssds",3,"sfdsfsdfsdf");
        testSchool4.show();




    }
}

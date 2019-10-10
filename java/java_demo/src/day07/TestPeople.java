package day07;

public class TestPeople {
    public static void main(String[] args) {
        People testPeople=new People();


        testPeople.setSex("男");
        String sex=testPeople.getSex();
        System.out.println("性别："+sex);

        testPeople.setAge(123);
        int age =testPeople.getAge();
        System.out.println("年龄："+age);

        testPeople.setName("瞿国新");
        String name =testPeople.getName();
        System.out.println("姓名："+name);

        testPeople.setHeight(180);
        double height =testPeople.getHeight();
        System.out.println("身高："+height);

        testPeople.setWeigth(150);
        double weight=testPeople.getWeigth();
        System.out.println("体重："+weight);

        testPeople.setIdCard("421013199312054514");
        String idCard=testPeople.getIdCard();
        System.out.println("身份证："+idCard);
    }
}

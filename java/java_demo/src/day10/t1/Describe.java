package day10.t1;

public class Describe {
    public static void main(String[] args) {
        Cleaner cleaners=new Cleaner();
        System.out.println(cleaners.introduce("张三","后勤部门",2500)+
                cleaners.cleaner("做清洁工作"));
        Manager managers=new Manager();
        System.out.println(cleaners.introduce("李四","销售部门",5000)+
                cleaners.cleaner("做业务经理工作"));




    }
}

import dao.impl.GradeDaoImpl;
import entity.Grade;

import java.util.List;
import java.util.Scanner;

public class TestGrade {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        System.out.println("*****功能列表*****");
        System.out.println("1.增加\n2.改\n3.删\n4.查全部\n5.定点查");
        System.out.println("请输入：");
        int number=input.nextInt();
        Grade grade =new Grade();
        GradeDaoImpl gradeDaoImpl=new GradeDaoImpl();
        switch (number){
            case 1:
                grade.setGradeName("大五");
                System.out.println(gradeDaoImpl.add(grade));
                break;
            case 2:
                grade.setGradeId(6);
                grade.setGradeName("qgx");
                System.out.println(gradeDaoImpl.update(grade));
                break;
            case 3:
                System.out.println(gradeDaoImpl.delete(6));
                break;
            case 4:
                List<Grade> list=gradeDaoImpl.findAll();
                for(Grade tmp:list){
                    System.out.println(tmp.toString());
                }
                break;
            case 5:
                System.out.println(gradeDaoImpl.findById(3).toString());
                break;
            default:
                System.out.println("输入有误！");
                break;
        }

    }
}

package day05;
import java.util.Arrays;
import java.util.Scanner;
public class Grade {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("请输入学生人数：");
        int number=input.nextInt();
        double []student=new double[number];
        System.out.println("请依次输入"+number+"个成绩：");
        double max=0;
        for(int i=0;i<number;i++){
            double score=input.nextDouble();
            student[i]=score;

            if(student[i]>max){
               max=student[i];
            }
        }

        /*Arrays.sort(student);*/
        System.out.println("最高分是："+max);

        for(int i=0;i<number;i++){
            if(student[i]>=student[number-1]-10){
                System.out.println("student "+i+" score is "+student[i]+" grade is A");
            }else if(student[i]>=student[number-1]-20){
                System.out.println("student "+i+" score is "+student[i]+" grade is B");
            }else if(student[i]>=student[number-1]-30){
                System.out.println("student "+i+" score is "+student[i]+" grade is C");
            }else {
                System.out.println("student "+i+" score is "+student[i]+" grade is D");
            }
        }
    }
}

package day24;

import java.util.List;
import java.util.Scanner;

public class TestMonth {
    public static void main(String[] args) {
        //循环输出各个月份及说明
        Month[] month1=Month.values();
        for(Month month:month1){
            System.out.println(month.toString());
        }


        //输入编号，打印其对应的月份和说明
        Scanner input =new Scanner(System.in);
        System.out.println("请输入月份编号：");
        System.out.println(Month.getByNo(input.nextInt()).toString());

    }


}

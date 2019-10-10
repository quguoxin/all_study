package com.qgx.www.my_test;

import java.util.Scanner;

public class Change {
    public static void main(String[] args) {
        System.out.println("请输入字符串");
        Scanner input =new Scanner(System.in);
        String str =input.next();
        String[] strArray={"zero","one","two","three","four","five","six"};
        for(int i=0;i<strArray.length;i++){
            if(str.contains(strArray[i])){
                str=str.replace(strArray[i],i+"");
            }
        }
        System.out.println(str);
    }
}

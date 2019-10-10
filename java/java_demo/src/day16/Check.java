package day16;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Check {
    public void checkTeam(Map<Integer,String> map){
        Scanner input=new Scanner(System.in);
        boolean isok=false;
        do{
            System.out.print("请输入您想要查询的年份(格式:1983)：");
            Integer year=input.nextInt();
            if(!map.containsKey(year)){
                System.out.println("该年没有举办世界杯哦！请重新输入");
            }else {
                System.out.println(year+"年的冠军队伍是："+map.get(year));
                checkYear(map);
                isok=true;
            }
        }while (!isok);
    }

    public void checkYear(Map<Integer,String> map){
        Scanner input=new Scanner(System.in);
        boolean isok=false;
        do{
            System.out.print("请输入您想要查询的队伍：");
            String team=input.next();
            if(!map.containsValue(team)){
                System.out.println("您的输入有误，或者"+team+"至今没有夺冠哦");
            }else {
                String str="";
                Set<Integer> set=map.keySet();
                Iterator<Integer> it=set.iterator();
                while (it.hasNext()){
                    Integer key=it.next();
                    if(map.get(key).equals(team)){
                        str=key+"  "+str;
                    }
                }
                System.out.println("夺冠年份为："+str);
                isok=true;
            }
        }while (!isok);
    }
}

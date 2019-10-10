package day18.t1t2t3;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class PageSetup {
    static String filmOffice;
    static String time;
    static String moviceName;
    static  String price;
    static String seatNo;
    //读
    public static String readFile(String readAddress){
        //创建读对象
        Reader reader=null;
        try {
            reader=new FileReader(readAddress);//输入读地址
            char[] c=new char[1024];//定义字符数组接收
            reader.read(c);//返回数组的真实长度，并将数据读取到数组中
            String str=new String(c);//数组转化为字符串
            return str;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    //写
    public static void writeFile(String writeAddress,String str){
        //创建写对象
        Writer writer=null;
        //获取粘贴文件地址，如果没有则自己创建
        File file=new File(writeAddress);
        File parentFile=file.getParentFile();//获取父类文件夹
        if(!parentFile.exists()){//如果不存在则自己创建
            parentFile.mkdirs();//创建多重文件
        }
        try {
            writer=new FileWriter(writeAddress);//写入地址
            writer.write(str);//进行写入
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //输入票信息
    public static void ticketMessage(){
        Scanner input=new Scanner(System.in);
        String strs=readFile("C:\\1\\film.html");
        System.out.println("请输入标题：");
        String title=input.next();
        System.out.println("请输入影厅：");
        filmOffice=input.next();
        System.out.println("请输入时间：");
        time=input.next();
        System.out.println("请输入片名：");
        moviceName=input.next();
        System.out.println("请输入票价：");
        price=input.next();
        seatNo=titck();
        strs=strs.replace("${title}",title).replace("${filmOffice}",filmOffice)
                .replace("${time}",time).replace("${moviceName}",moviceName)
                .replace("${seatNo}",seatNo).replace("${price}",price);
        writeFile("D:\\11\\films.html",strs);
    }

    //随机选座
    public static String titck(){
        //public static void main(String[] args) {
        int[][] ticket = {
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 0},
                {0, 0, 1, 1, 1, 0},
                {0, 0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
        };

        int row = (int) (Math.random() * 10);
        int line = (int) (Math.random() * 6);
        while (ticket[row][line] == 1) {
            System.out.println("第" + (row + 1) + "排，第" + (line + 1) + "列已售出，将为您重选！");
            row = (int) (Math.random() * 10);
            line = (int) (Math.random() * 6);
        }
        seatNo=(row + 1) + "排" + (line + 1) + "号";
        ticket[row][line] = 1;
        System.out.println("已为您随机出票！！！");
        System.out.println("********************\n中影星美影城\n"+filmOffice+"\n"+moviceName+"\n日期："+time+"\n"+moviceName+"\n座位号：" +seatNo+"\n"+price+"\n********************");
        System.out.println("\t\t\t\t银幕");
        System.out.println("         1  2  3  4  5  6 ");
        for (int i = 0; i < 10; i++) {
            System.out.println("第" + (i + 1) + "排\t" + Arrays.toString(ticket[i]));
        }
        return (row + 1) + "排" + (line + 1) + "号";
    }


    public static void main(String[] args) {
        ticketMessage();

    }
}

package day17.t5t6;

import java.io.*;
import java.util.Scanner;

public class Copy {
    //读
    public byte[] read(String name1){
        InputStream inputStream=null;
        try {
            inputStream=new FileInputStream(name1);//地址
            int length=inputStream.available();//长度
            byte[] bytes=new byte[length];//字节数组
            int n=inputStream.read(bytes);//返回读取到的内容总长度,数据存储在了byte数组中
            return bytes;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new byte[0];
    }
    //写
    public void write(String name2,byte[] bytes){
            OutputStream outputStream=null;
            //获取粘贴文件地址，
            File file=new File(name2);
            File parentFile=file.getParentFile();
            if(!parentFile.exists()){
                parentFile.mkdirs();//创建多重文件
            }
            try {
                outputStream=new FileOutputStream(name2);
                outputStream.write(bytes);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    }

    //读写一体
    public void copy(String name1,String name2){
        OutputStream outputStream=null; //定义
        InputStream inputStream=null;
        File file=new File(name2); //获取粘贴文件地址
        File parentFile=file.getParentFile(); //获取父类文件夹
        if(!parentFile.exists()){ //如果不存在则自己创建
            parentFile.mkdirs(); //创建多重文件
        }
        try {
            inputStream=new FileInputStream(name1);//创建对象
            outputStream=new FileOutputStream(name2);
            int res;
            while ((res=inputStream.read())!=-1){//边读边写:读
                outputStream.write(res);//读边写:写
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try{
                outputStream.close();
                inputStream.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    //复制
    public static void main(String[] args) {
        Copy copys=new Copy();
        Scanner input=new Scanner(System.in);
        System.out.println("请输入您要复制文件的地址：");
        String name1=input.next();
        System.out.println("请输入您要粘贴文件的地址：");
        String name2=input.next();

        //复制1：
        //copys.write(name2,copys.read(name1));

        //复制2：
        copys.copy(name1,name2);

    }
}

package day17.t3t4;

import java.io.*;

public class Read {
    public static void main(String[] args) {
        InputStream inputStream=null;
        try {
            inputStream=new FileInputStream("C:\\1\\1.txt");
            int length=inputStream.available();
            byte[] bytes=new byte[length];
            int n=inputStream.read(bytes);//返回读取到的内容总长度,数据存储在了byte数组中
            System.out.println(new String(bytes).trim());
            //用for循环
            /*System.out.println("*****************for***********************");
            int res;
            int index=0;
            do{
                    res=inputStream.read();
                    bytes[index]=(byte)res;==>两步合成一步：int res=inputSream.read(bytes)
                    index++;

            }while (index<length);
            System.out.println(new String(bytes));*/
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //写
        OutputStream outputStream=null;
        try {
            outputStream=new FileOutputStream("D:\\\\1\\\\1.txt");
            String str="you can you up!";
            byte[] bytes1=str.getBytes();
            outputStream.write(bytes1);
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
}

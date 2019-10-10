package day27.tcp;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TpcClient {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        Socket socket= null;
        try {
            while (true){
                //连接
                socket = new Socket("192.168.0.120",2222);
                //输出到客服端
                OutputStream outputStream=socket.getOutputStream();
                ObjectOutputStream oos=new ObjectOutputStream(outputStream);
                oos.writeObject("【瞿老爷】："+input.next());
                //接收客服端的反馈信息
                InputStream inputStream=socket.getInputStream();
                ObjectInputStream ois=new ObjectInputStream(inputStream);
                Object obj=ois.readObject();
                System.out.println(obj.toString());

                //关闭io流
                ois.close();
                oos.close();
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

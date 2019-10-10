package day27.tcp;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class TcpThread implements Runnable{
    private Socket socket;

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public TcpThread() {
    }

    public TcpThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            //对方地址
            InetAddress inetAddress=socket.getInetAddress();
            //接收客户
            InputStream inputStream=socket.getInputStream();
            ObjectInputStream ois=new ObjectInputStream(inputStream);
            String msg=ois.readObject().toString();
            System.out.println(inetAddress+"："+msg);
            //反馈客户
            OutputStream outputStream=socket.getOutputStream();
            ObjectOutputStream oos=new ObjectOutputStream(outputStream);
            oos.writeObject("哈哈哈");
            //关闭io流
            ois.close();
            oos.close();
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }
}

package day27.tcp;

import java.net.ServerSocket;
import java.net.Socket;

public class TpcServer {
    public static void main(String[] args) {
        try {
            //建立服务器
            ServerSocket serverSocket=new ServerSocket(6666);
            while (true){
                //开启服务器,有客户连接上则自动创建Socket socket
                Socket socket=serverSocket.accept();
                //多线程
                new Thread(new TcpThread(socket)).start();
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }
}

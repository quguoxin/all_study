package day27.download;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpServer {
    public static void main(String[] args) {
        //读取磁盘中的数据存储在数组中
        InputStream inputStream=null;
        try {
            inputStream=new FileInputStream("C:\\1\\12.PNG");
            int length=inputStream.available();
            byte[] bytes=new byte[length];
            int n=inputStream.read(bytes);

            //发送字节数组给客户端
            InetAddress myAddress = InetAddress.getByName("192.168.0.163");
            DatagramSocket socket=new DatagramSocket(6666,myAddress);
            InetAddress otherAddress=InetAddress.getByName("192.168.0.163");
            //发
            DatagramPacket packet1=new DatagramPacket(bytes,bytes.length,otherAddress,8888);
            socket.send(packet1);
            //收
            byte[] byte2=new byte[1024];
            DatagramPacket packet2=new DatagramPacket(byte2,byte2.length,otherAddress,8888);
            socket.receive(packet2);
            System.out.println("客户端反馈："+new String(byte2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

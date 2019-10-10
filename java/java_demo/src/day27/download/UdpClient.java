package day27.download;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpClient {
    public static void main(String[] args) {
        try {
            InetAddress myAddress = InetAddress.getByName("192.168.0.163");
            DatagramSocket socket=new DatagramSocket(8888,myAddress);
            InetAddress otherAddress=InetAddress.getByName("192.168.0.163");
            //从服务器下载（接收）
            byte[] byte1=new byte[61*1024];
            DatagramPacket packet1=new DatagramPacket(byte1,byte1.length,otherAddress,6666);
            socket.receive(packet1);
            System.out.println("下载的文件内容为："+new String(byte1));

            //反馈给服务端
            String msg = "我已下载成功！";
            byte[] byte2=msg.getBytes();
            DatagramPacket packet2=new DatagramPacket(byte2,byte2.length,otherAddress,6666);
            socket.send(packet2);

            //写入到磁盘
            OutputStream outputStream=null;
            //获取粘贴文件地址，
            File file=new File("C:\\Users\\Administrator\\Desktop\\下载2.png");
            File parentFile=file.getParentFile();
            if(!parentFile.exists()){
                parentFile.mkdirs();//创建多重文件
            }
            outputStream=new FileOutputStream("C:\\Users\\Administrator\\Desktop\\下载的2.png");
            outputStream.write(byte1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

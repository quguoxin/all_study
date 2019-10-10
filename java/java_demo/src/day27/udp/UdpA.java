package day27.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UdpA {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        try {
            //自己
            InetAddress myAddress = InetAddress.getByName("192.168.0.124");
            DatagramSocket socket=new DatagramSocket(6666,myAddress);
            //对方
            InetAddress otherAddress=InetAddress.getByName("192.168.0.124");
            while (true){
                //发
                System.out.print("瞿老爷A说：");
                String msg = input.next();
                byte[] byte1=msg.getBytes();
                DatagramPacket packet1=new DatagramPacket(byte1,byte1.length,otherAddress,8888);
                socket.send(packet1);
                //收
                byte[] byte2=new byte[1024];
                DatagramPacket packet2=new DatagramPacket(byte2,byte2.length,otherAddress,8888);
                socket.receive(packet2);
                System.out.println("瞿老爷B说："+new String(byte2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

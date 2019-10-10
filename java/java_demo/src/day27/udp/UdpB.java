package day27.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UdpB {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        try {
            //自己
            InetAddress myAddress = InetAddress.getByName("192.168.0.124");
            DatagramSocket socket=new DatagramSocket(8888,myAddress);
            //对方
            InetAddress otherAddress=InetAddress.getByName("192.168.0.124");
            while (true){
                //收
                byte[] byte1=new byte[1024];
                DatagramPacket packet1=new DatagramPacket(byte1,byte1.length,otherAddress,6666);
                socket.receive(packet1);
                System.out.println("瞿老爷A说："+new String(byte1));
                //发
                System.out.print("瞿老爷B说：");
                String msg = input.next();
                byte[] byte2=msg.getBytes();
                DatagramPacket packet2=new DatagramPacket(byte2,byte2.length,otherAddress,6666);
                socket.send(packet2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

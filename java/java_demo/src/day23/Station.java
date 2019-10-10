package day23;
public class Station {
    public static void main(String[] args) {
        Ticket ticket=new Ticket();
        Thread thread1=new Thread(ticket,"宝安");
        Thread thread2=new Thread(ticket,"罗湖");
        Thread thread3=new Thread(ticket,"南山");
        Thread thread4=new Thread(ticket,"龙华");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

    }
}

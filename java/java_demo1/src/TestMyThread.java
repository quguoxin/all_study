public class TestMyThread {
    public static void main(String[] args) {

        //继承
        /*MyThread myThread1=new MyThread();
        myThread1.start();

        MyThread myThread2=new MyThread();
        myThread2.start();

        MyThread myThread3=new MyThread();
        myThread3.start();

        MyThread myThread4=new MyThread();
        myThread4.start();*/

        //多态
        MyThread2 myThread1=new MyThread2();
        Thread thread1=new Thread(myThread1,"小明");
        thread1.start();

        MyThread2 myThread2=new MyThread2();
        Thread thread2=new Thread(myThread2,"小黑");
        thread2.start();

        MyThread2 myThread3=new MyThread2();
        Thread thread3=new Thread(myThread3,"小白");
        thread3.start();

        MyThread2 myThread4=new MyThread2();
        Thread thread4=new Thread(myThread4,"小黄");
        thread4.start();
    }
}

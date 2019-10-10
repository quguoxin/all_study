public class MyThread extends Thread {
    @Override
    public void run() {
        for(int i=1;i<11;i++){
            System.out.println("我来了，"+Thread.currentThread().getName()+"，"+i);
        }
    }
}

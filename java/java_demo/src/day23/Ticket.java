package day23;

/**
 * 实现接口创建多线程
 */
public class Ticket implements Runnable{
    int total=20;
    @Override
    public void run() {
        for(int i=1;i<=20;i++){
            synchronized (this){
                notify();
                if(total<=0){
                    System.out.println(Thread.currentThread().getName()+"票卖完了~");
                    break;
                }
                System.out.println(Thread.currentThread().getName()+"车站，" +
                        "卖出T101次列车第"+(20-total+1)+"张票");
                total--;
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }




}

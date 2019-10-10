package day23;

/**
 * 实现接口创建多线程
 */
public class GetApple implements Runnable{
    int sum=5;
    @Override
    public void run() {
        for(int i=1;i<=5;i++){
            if(!getApple()){
                break;
            }
        }
    }


    public synchronized boolean getApple(){//锁方法
        notify();
        if(sum>0){
            System.out.println(Thread.currentThread().getName()+"拿走一个苹果，还剩"+(--sum)+"个。");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;
        }else {
            System.out.println("苹果被拿完了！"+Thread.currentThread().getName()+"走了！");
            return false;
        }


    }
}

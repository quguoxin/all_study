import entity.Sum;

public class TestSum {
    public static void main(String[] args) {
        try {
            Sum sum1=new Sum(0,100);
            Thread thread1=new Thread(sum1);
            thread1.start();
            thread1.join();
            //System.out.println(sum1.getSum());
            Sum sum2=new Sum(101,200);
            Thread thread2=new Thread(sum2);
            thread2.start();
            thread2.join();
            //System.out.println(sum2.getSum());
            Sum sum3=new Sum(201,300);
            Thread thread3=new Thread(sum3);
            thread3.start();
            thread3.join();
            //System.out.println(sum3.getSum());
            System.out.println(sum1.getSum()+sum2.getSum()+sum3.getSum());

        } catch (InterruptedException e) {
            //e.printStackTrace();
        }
    }
}

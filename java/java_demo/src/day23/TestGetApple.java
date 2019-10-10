package day23;

public class TestGetApple {
    public static void main(String[] args) {
        GetApple getApple=new GetApple();//GetApple实现了Runnable接口
        Thread thread1=new Thread(getApple,"小明");//“小明为线程名称”
        Thread thread2=new Thread(getApple,"小黑");

        thread1.start();//start():只负责启动线程,jvm会去调用run()执行子线程中的代码，不是直接执行run()
        thread2.start();
    }
}

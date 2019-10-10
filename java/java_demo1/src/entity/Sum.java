package entity;

public class Sum implements Runnable{
    private int a=0;
    private int b=0;

    public int sum=0;
    @Override
    public  void run() {
        for(int i=a;i<=b;i++){
            sum+=i;
        }
    }

    public int  getSum(){
        return sum;
    }

    public Sum(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

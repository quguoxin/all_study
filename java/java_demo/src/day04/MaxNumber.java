package day04;

public class MaxNumber {
    public static void main(String[] args) {
        int sum=8888;
        int max=1;
        while(sum>max){
            sum=sum-max;
            if(sum<max){
                break;
            }
            max++;
        }
        System.out.println("最大值为"+max);
    }
}

package day04;

public class Summation {
    public static void main(String[] args) {
        int sum=0;
        /*int i=1;
        while(i<=100){
            if(i%2==0){
                sum+=i;
            }
            i++;
        }
        System.out.println(sum);*/

        /*int i=1;
        do{
            if(i%2==0){
                sum+=i;
            }
            i++;
        }while (i<=100);
        System.out.println(sum);*/

        for (int i=1;i<=100;i++){
            if(i%2==0){
                sum+=i;
            }
        }
        System.out.println(sum);
    }
}

package day04;

public class PrimeNumber {
    public static void main(String[] args) {

        for(int i=2;i<=100;i++){
            for(int j=2;j<=i;j++){
                    if(i!=2&&i%j==0&&i!=j){
                        System.out.println(i+"【不是】质数");
                        break;
                    }else {
                        if(j==i){
                            System.out.println(i+"【是】质数");
                            break;
                        }

                    }
            }
        }
    }
}


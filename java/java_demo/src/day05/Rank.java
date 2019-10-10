package day05;

public class Rank {
    public static void main(String[] args) {
        int[] number={90,2,56,76,28,66,12,44,54,77,87,98};
        int n=number.length;
        int tmp=0;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-1-i;j++){
                if (number[j]>number[j+1]){
                    tmp=number[j+1];
                    number[j+1]=number[j];
                    number[j]=tmp;
                }
            }
        }

        System.out.print("从小到大是：");
        for(int i=0;i<n;i++){
            System.out.print(number[i]+"\t\t");
        }

        System.out.print("\n从大到小是：");
        for(int i=n-1;i>=0;i--){
            System.out.print(number[i]+"\t\t");
        }
    }
}

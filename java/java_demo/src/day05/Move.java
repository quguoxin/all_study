package day05;

public class Move {
    public static void main(String[] args) {
        int first=25;
        int second=30;
        int tmp=0;
        System.out.println("移动前：\nfirst="+first+"\n"+"second="+second);

        tmp=first;
        first=second;
        second=tmp;
        System.out.println("移动后：\nfirst="+first+"\n"+"second="+second);
    }
}

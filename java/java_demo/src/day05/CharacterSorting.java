package day05;

import java.util.Arrays;
import java.util.Scanner;

public class CharacterSorting {
    public static void main(String[] args) {
        char[] character={'a','c','u','b','e','p','f','z'};
        int length=character.length;
        Arrays.sort(character);
        System.out.print("升序输出：");
        for(int i=0;i<length;i++){
            System.out.print(character[i]+"\t");
        }
        System.out.print("\n降序输出：");
        for(int i=0;i<length;i++){
            System.out.print(character[length-i-1]+"\t");
        }



        Scanner input=new Scanner(System.in);
        System.out.print("\n待输入的字符是：");
        char newCharacter=input.next().charAt(0);

        char[] character2=Arrays.copyOf(character,9);
        int subscript=0;

        for(int i=0;i<length;i++){
            if((int)(newCharacter)<=(int)(character[i])){
                subscript=i;
                System.out.println("插入字符的下标是："+subscript);
                break;
            }
        }

        for(int i=character2.length-2;i>=subscript;i--){
            character2[i+1]=character2[i];
        }

        character2[subscript]=newCharacter;
        System.out.print("\n插入后的排序是：");
        for(int i=0;i<character2.length;i++){
            System.out.print(character2[i]+"\t");
        }
    }
}

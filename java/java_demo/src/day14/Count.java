package day14;

public class Count {
    public static void main(String[] args) {
       String str="abcde123cde45cdepecde";
       String str1="cde";
       int length=str.length();
       str=str.replace(str1,"");
       int number=(length-str.length())/str1.length();
        System.out.println("含有小字符串的个数为："+number);
    }
}

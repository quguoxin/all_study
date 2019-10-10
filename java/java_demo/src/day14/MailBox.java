package day14;

import java.util.Scanner;

public class MailBox {

    public static boolean verifier(String mailBox){
        if(!mailBox.contains("@")){
            System.out.println("不包含@");
            return false;
        }
        if(!mailBox.contains(".com")){
            System.out.println("结尾不包含.com");
            return false;
        }
        if(mailBox.indexOf("@")>mailBox.indexOf(".com")){
            System.out.println("@不在.com之前");
            return false;
        }
        if(mailBox.endsWith(".com")){
            System.out.println("结尾不包含.com");
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
       do{
           System.out.println("请输入邮箱：");
           Scanner input=new Scanner(System.in);
           String mailBox=input.next();
           System.out.println(verifier(mailBox));
       }while (false);

    }
}

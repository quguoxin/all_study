package day04;
import java.util.Scanner;
public class Register {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String user="jim";
        String password="123456";

        /*int i=1;
        do{
            System.out.print("请输入用户名：");
            String user1=input.next();
            System.out.print("请输入密码：");
            String password1=input.next();
            if(user1.equals(user)&&password1.equals(password)){
                System.out.println("欢迎登陆MyShopping系统！");
                break;
            }else {
                if(i==3){
                    System.out.println("输入错误，您还有"+(3-i)+"次机会\n\n对不起您三次均输入错误！");
                }else{
                    System.out.println("输入错误，您还有"+(3-i)+"次机会");
                }
            }
            i++;
        }while (i<=3);*/

        /*int i=1;
        while (i<=3){
            System.out.print("请输入用户名：");
            String user1=input.next();
            System.out.print("请输入密码：");
            String password1=input.next();
            if(user1.equals(user)&&password1.equals(password)){
                System.out.println("欢迎登陆MyShopping系统！");
                break;
            }else {
                if(i==3){
                    System.out.println("输入错误，您还有"+(3-i)+"次机会\n\n对不起您三次均输入错误！");
                }else{
                    System.out.println("输入错误，您还有"+(3-i)+"次机会");
                }
            }
            i++;
        }*/

        for(int j=1;j<=3;j++){
            System.out.print("请输入用户名：");
            String user1=input.next();
            System.out.print("请输入密码：");
            String password1=input.next();
            if(user1.equals(user)&&password1.equals(password)){
                System.out.println("欢迎登陆MyShopping系统！");
                break;
            }else {
                if(j==3){
                    System.out.println("输入错误，您还有"+(3-j)+"次机会\n\n对不起您三次均输入错误！");
                }else{
                    System.out.println("输入错误，您还有"+(3-j)+"次机会");
                }
            }
        }
    }
}

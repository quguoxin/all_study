package day03;
import java.util.Scanner;
public class SafeBox {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String password1="iloveyou";
        String password2="iloveyoutoo";
        System.out.println("O(∩_∩)O欢迎您前来提现O(∩_∩)O");
        System.out.println("请输入房间密码：");
        String inputPassword=input.next();
        if(inputPassword.equals(password1)){
            System.out.println("请输入保险柜密码：");
            inputPassword=input.next();
            if(inputPassword.equals(password2)){
                System.out.println("恭喜你，提现100万！！！");
            }else{
                System.out.println("密码错误o(╥﹏╥)o");
            }
        }else{
            System.out.println("密码错误o(╥﹏╥)o");
        }
    }
}

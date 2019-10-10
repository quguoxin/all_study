package day14;

import java.util.Scanner;

/**
 * 用户名（必须是包含字母和数字，首字母必须是字母，长度4~12位）
 密码（必须是6~12位的数字加字母）
 身份证（15或18位的数字，最后一个位可以是大写或小写X）
 手机号码（11位的数字，前3位必须是133,135,136,138,150,158,183）

 */
public class PersonalInformation {
    //用户名（必须是包含字母和数字，首字母必须是字母，长度4~12位）
    public static boolean checkUsername(String username){

        //长度
        if(username.length()<4||username.length()>12){
            System.out.println("长度不符合要求，需要4-12位。");
            return false;
        }

        //只能是数字字母
        username=username.toLowerCase();
        for(int i=0;i<username.length();i++){
            if(username.charAt(i)<'0'||username.charAt(i)>'z'||(username.charAt(i)>'9'&&username.charAt(i)<'a')){
                System.out.println("含有非法字符，只能由数字字母组成！");
                return false;
            }
        }

        //包含字母
         boolean isok=false;
        username=username.toLowerCase();
        for(int i=0;i<username.length();i++){
            if(username.charAt(i)>='a'&&username.charAt(i)<='z'){
                isok=true;
                break;
            }
        }
        if(!isok){
            System.out.println("必须包含字母");
            return false;
        }
        //包含数字
        isok=false;
        for(int i=0;i<username.length();i++){
                if((int)username.charAt(i)>='0'&&(int)username.charAt(i)<='9'){
                    isok=true;
                    break;
                }
        }
        if(!isok){
            System.out.println("必须包含数字");
            return false;
        }

        //首字母
        if(username.charAt(0)<'A'||(username.charAt(0)>'Z'&&username.charAt(0)<'a')||username.charAt(0)>'z'){
            System.out.println("首字母不符合要求，必须是字母");
            return false;
        }

        return true;
    }

    //密码（必须是6~12位的数字加字母）
    public static boolean checkPassword(String password){
        //长度
        if(password.length()<6||password.length()>12){
            System.out.println("长度不符合要求，需要6-12位。");
            return false;
        }

        //只能是数字字母
        password=password.toLowerCase();
        for(int i=0;i<password.length();i++){
            if(password.charAt(i)<'0'||password.charAt(i)>'z'||(password.charAt(i)>'9'&&password.charAt(i)<'a')){
                System.out.println("含有非法字符，只能由数字字母组成！");
                return false;
            }
        }
        //包含字母
        boolean isok=false;
        password=password.toLowerCase();
        for(int i=0;i<password.length();i++){
            if(password.charAt(i)>='a'&&password.charAt(i)<='z'){
                isok=true;
                break;
            }
        }
        if(!isok){
            System.out.println("必须包含字母");
            return false;
        }
        //包含数字
        isok=false;
        for(int i=0;i<password.length();i++){
            if((int)password.charAt(i)>='0'&&(int)password.charAt(i)<='9'){
                isok=true;
                break;
            }
        }
        if(!isok){
            System.out.println("必须包含数字");
            return false;
        }
        return true;
    }

    //身份证（15或18位的数字，最后一个位可以是大写或小写X）
    public static boolean checkIdcard(String idcard){
        //长度
        if(idcard.length()!=15&&idcard.length()!=18){
            System.out.println("长度不符合要求，需要15或18位。");
            return false;
        }
        //数字
        for(int i=0;i<idcard.length()-1;i++){
            if(idcard.charAt(i)<'0'||idcard.charAt(i)>'9'){
                System.out.println("必须由数字组成");
                return false;
            }
        }
        //最后一位
        idcard=idcard.toLowerCase();
        if(idcard.charAt(idcard.length()-1)!='x'&&(idcard.charAt(idcard.length()-1)<'0'||idcard.charAt(idcard.length()-1)>'9')){
            System.out.println("最后一位只能是数字或者x或者X");
            return false;
        }

        return true;
    }

    //手机号码（11位的数字，前3位必须是133,135,136,138,150,158,183）
    public static boolean checkPhone(String phone){
        //长度
        if(phone.length()!=11){
            System.out.println("长度不符合要求，需要11位。");
            return false;
        }
        //数字
        for(int i=0;i<phone.length();i++){
            if(phone.charAt(i)<'0'||phone.charAt(i)>'9'){
                System.out.println("必须由数字组成");
                return false;
            }
        }
        //前3位必须是133,135,136,138,150,158,183
        if(!phone.startsWith("133")&&!phone.startsWith("135")&&!phone.startsWith("136")&&!phone.startsWith("138")&&!phone.startsWith("150")
                &&!phone.startsWith("158")&&!phone.startsWith("183")){
            System.out.println("必须是133,135,136,138,150,158,183开头");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        //验证用户名
        boolean isok=false;
        do{
            System.out.println("请输入您的用户名：");
            String username=input.next();
            isok=checkUsername(username);
            if(isok){
                System.out.println("用户名符合要求");
                break;
            }
                System.out.println("请重新输入");

        }while (!isok);

        //验证密码
        isok=false;
        do{
            System.out.println("请输入您的密码：");
            String password=input.next();
            isok=checkPassword(password);
            if(isok){
                System.out.println("密码符合要求");
                break;
            }
                System.out.println("请重新输入");

        }while (!isok);

        //验证身份证
        isok=false;
        do{
            System.out.println("请输入您的身份证：");
            String idcard=input.next();
            isok=checkIdcard(idcard);
            if(isok){
                System.out.println("身份证符合要求");
                break;
            }
                System.out.println("请重新输入");

        }while (!isok);

        //验证手机号码
        isok=false;
        do{
            System.out.println("请输入您的手机号：");
            String phone=input.next();
            isok=checkPhone(phone);
            if(isok){
                System.out.println("手机号符合要求");
                break;
            }
                System.out.println("请重新输入");

        }while (!isok);



    }
}

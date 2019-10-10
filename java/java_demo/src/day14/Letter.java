package day14;

public class Letter {
    public static void main(String[] args) {
        String str="Hello12345World";
        int capitalNumber=0;
        int lowercaseLettersNumber=0;
        int number=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)>='A'&&str.charAt(i)<='Z'){
                capitalNumber+=1;
            }else if(str.charAt(i)>='a'&&str.charAt(i)<='z'){
                lowercaseLettersNumber+=1;
            }else if(str.charAt(i)>='0'&&str.charAt(i)<='9'){
                number+=1;
            }
        }
        System.out.println(str+"大写字母："+capitalNumber+"个，小写字母："+lowercaseLettersNumber+"个，数字："+number+"个");
    }
}

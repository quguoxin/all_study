package day07;

public class Card {
    /**
     * 卡号19位，全数字
     */
    private String cardNo;
    public void setCardNo(String youCardNo){
        if(youCardNo.length()==19){
            /*char a=youCardNo.charAt(0)*/
            char[] array=youCardNo.toCharArray();

            boolean ok=true;
            for(int i=0;i<19;i++){
                if(array[i]>'9'||array[i]<'0'){
                    System.out.println("卡号必须是数字，请重新输入");
                    ok=false;
                }
                if(ok==true){
                    cardNo=youCardNo;
                }
            }
        }else{
            System.out.println("卡号必须19位，请重新输入！");
        }
    }
    public String getCardNo(){
        return cardNo;
    }
    /**
     * 密码6位，全数字
     */
    private String password;
    public void setPassword(String youpassword){
        if(youpassword.length()==6){
            char[] array=youpassword.toCharArray();
            boolean ok=true;
            for(int i=0;i<6;i++){
                if(array[i]>'9'||array[i]<'0'){
                    System.out.println("密码必须是数字，请重新输入");
                    ok=false;
                }
                if(ok==true){
                    password=youpassword;
                }
            }

        }else{
            System.out.println("密码必须6位，请重新输入！");
        }
    }
    public String getPassword(){
        return password;
    }
    /**
     * 余额正数，小于1000万
     */
    private double balance;
    public void setBalance(double youbalance){
        if(youbalance<=0||youbalance>10000000){
            System.out.println("您的余额不符合要求");
        }else{
            balance=youbalance;
        }
    }
    public double getBalance(){
        return balance;
    }





}

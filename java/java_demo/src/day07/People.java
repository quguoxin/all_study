package day07;

public class People {
    private String sex;
    private int age;
    private String name;
    private double height;
    private double weigth;
    private String idCard;

    public String getName() {
        return name;
    }

    public void setName(String myName) {
        char[] array=myName.toCharArray();
        boolean ok=true;
        if(((int)array[0]>=97&&(int)array[0]<=122)||((int)array[0]>=65&&(int)array[0]<=90)){
            for(int i=1;i<array.length;i++){
                if((int)array[i]<65||((int)array[i]>90&&(int)array[i]<97)||(int)array[i]>122){
                    System.out.println("您的姓名有误！");
                    ok=false;
                    break;
                }
            }
        }else if((int)array[0]>=19968&&(int)array[0]<=40869){
            for(int i=1;i<array.length;i++){
                if((int)array[i]<19968||(int)array[i]>40869){
                    System.out.println("您的姓名有误！");
                    ok=false;
                    break;
                }
            }
        }else {
            System.out.println("您的姓名有误！");
            ok=false;
        }

        if(ok==true){
            name=myName;
        }
    }



    public double getHeight() {
        return height;
    }

    public void setHeight(double myHeight) {
        if(myHeight>0&&myHeight<=260){
            height=myHeight;
        }else {
            System.out.println("您的身高有误！");
        }
    }




    public double getWeigth() {
        return weigth;
    }

    public void setWeigth(double myWeigth) {
        if(myWeigth>0&&myWeigth<=1000){
            weigth=myWeigth;
        }else {
            System.out.println("您的体重有误！");
        }
    }




    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String myIdCard) {
        if(myIdCard.length()==15||myIdCard.length()==18){
            int length=myIdCard.length();
            boolean ok=true;
            for(int i=0;i<length;i++){
                char id=myIdCard.charAt(i);
                if(i<length-1){
                    if(id>'9'||id<'0'){
                        System.out.println("您的身份证有误！");
                        ok=false;
                        break;
                    }
                }else {
                    if((id>'9'||id<'0')&&id!='X'){
                        System.out.println("您的身份证有误！");
                        ok=false;
                        break;
                    }
                }
            }

            if(ok){
                idCard=myIdCard;
            }
        }else {
            System.out.println("您的身份证有误！");
        }
    }




    public String getSex() {
        return sex;
    }

    public void setSex(String mySex) {
        if(mySex.equals("男")||mySex.equals("女")){
            sex=mySex;
        }else {
            System.out.println("您的输入有误！");
        }
    }




    public int getAge() {
        return age;
    }

    public void setAge(int myAge) {
        if(myAge>0&&myAge<=130){
            age=myAge;
        }else {
            System.out.println("您的年龄有误");
        }
    }
}

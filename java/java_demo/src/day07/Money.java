package day07;

public class Money {

    private String currency;
    private String unit;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String myCurrency) {
        /*boolean ok=true;
        char[] array=myCurrency.toCharArray();
        for(int i=0;i<array.length;i++){
            if(array[i]<19968||array[i]>40869){
                System.out.println("您的币种有误！");
                ok=false;
                break;
            }
        }*/

        if(myCurrency.equals("人民币")||myCurrency.equals("美元")||myCurrency.equals("日元")||myCurrency.equals("韩元")||myCurrency.equals("英镑")){
           currency=myCurrency;
        }else {
            System.out.println("您的币种有误！");
        }
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String myUnit) {
        if(myUnit.equals("元")){
            unit=myUnit;
        }else {
            System.out.println("您的单位有误！");
        }
    }
}

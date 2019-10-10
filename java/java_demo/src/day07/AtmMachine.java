package day07;

import javax.lang.model.type.NullType;

public class AtmMachine {

    private String bankName;
    private String factory;
    private String productPlace;


    public String getBankName() {
        return bankName;
    }

    public void setBankName(String myBankName) {
        if(myBankName.equals("中国农业银行")||myBankName.equals("Agricultural Bank of China")||myBankName.equals("中国建设银行")||myBankName.equals("China Construction Bank")||myBankName.equals("中国工商银行")||myBankName.equals("Industrial and Commercial Bank of China")){
            bankName=myBankName;
        }else {
            System.out.println("银行单位有误！");
        }
    }



    public String getFactory() {
        return factory;
    }

    public void setFactory(String myFactory) {
        if(myFactory==null||myFactory.length()==0){
            System.out.println("请输入厂商，厂商不能为空哦！");
        }else {
            factory=myFactory;
        }
    }



    public String getProductPlace() {
        return productPlace;
    }

    public void setProductPlace(String myProductPlace) {
        if(null==myProductPlace||myProductPlace.length()==0){
            System.out.println("请输入产地，产地不能为空哦！");
        }else {
            productPlace=myProductPlace;
        }
    }
}

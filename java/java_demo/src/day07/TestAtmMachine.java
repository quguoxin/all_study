package day07;

public class TestAtmMachine {
    public static void main(String[] args) {
        AtmMachine testAtmMachine=new AtmMachine();

        testAtmMachine.setBankName("中国农业银行");
        String bankName =testAtmMachine.getBankName();
        System.out.println("单位："+bankName);

        testAtmMachine.setFactory("s");
        String factory=testAtmMachine.getFactory();
        System.out.println("厂商："+factory);

        testAtmMachine.setProductPlace("s");
        String productPlace=testAtmMachine.getProductPlace();
        System.out.println("产地："+productPlace);
    }
}

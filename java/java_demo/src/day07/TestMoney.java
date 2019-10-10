package day07;

public class TestMoney {
    public static void main(String[] args) {
        Money testMoney=new Money();

        testMoney.setCurrency("美元");
        String currency=testMoney.getCurrency();
        System.out.println("币种："+currency);

        testMoney.setUnit("元");
        String unit=testMoney.getUnit();
        System.out.println("单位："+unit);
    }
}

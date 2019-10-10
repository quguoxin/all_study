package day07;

public class CardTest {
    public static void main(String[] args) {
        Card card=new Card();
        card.setCardNo("1234567890123456789");
        String cardNo=card.getCardNo();
        System.out.println("卡号："+cardNo);



        card.setPassword("123456");
        String password=card.getPassword();
        System.out.println("密码："+password);

        card.setBalance(1234566.67);
        double balance= card.getBalance();
        System.out.println("余额："+balance);
    }
}

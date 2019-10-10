package day15.Bank;

public class BankAccount {
    private String cardNumber;
    private String cardPassage;
    private String cardName;
    private String idCard;

    public BankAccount() {
    }

    public BankAccount(String cardNumber, String cardPassage, String cardName, String idCard) {
        this.cardNumber = cardNumber;
        this.cardPassage = cardPassage;
        this.cardName = cardName;
        this.idCard = idCard;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardPassage() {
        return cardPassage;
    }

    public void setCardPassage(String cardPassage) {
        this.cardPassage = cardPassage;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
}

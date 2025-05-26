package entities;

public class Card {
    private String cardNumber;
    private String password;

    public Card(String cardNumber, String password) {
        this.cardNumber = cardNumber;
        this.password = password;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public boolean validatePassword(String txt){
        return this.password.equals(txt);
    }


}

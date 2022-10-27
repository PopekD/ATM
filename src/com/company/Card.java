package com.company;

public class Card {
    String nameCard;
    String cardNumber;
    String expirationDate;
    String pin;
    int cvv;
    int amount;



    public Card() {
        nameCard = "";
        cardNumber = "";
        expirationDate = "";
        cvv = 0;
        amount = 0;
        pin = "";
    }

    public String getNameCard() { return nameCard; }

    public void setNameCard(String nameCard) { this.nameCard = nameCard; }

    public String getCardNumber() { return cardNumber; }

    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public int getAmount() { return amount; }

    public void setAmount(int amount) { this.amount = amount; }

    public String getPin() { return pin; }

    public void setPin(String pin) { this.pin = pin; }

}

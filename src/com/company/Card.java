package com.company;

public class Card {
    String nameCard;
    int cardNumber;
    String  experationmDate;
    int cvv;

    public Card() {
        nameCard = "";
        cardNumber = 0;
        experationmDate = "";
        cvv = 0;
    }

    public String getNameCard() { return nameCard; }

    public void setNameCard(String nameCard) { this.nameCard = nameCard; }

    public int getCardNumber() { return cardNumber; }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExperationmDate() {
        return experationmDate;
    }

    public void setExperationmDate(String experationmDate) {
        this.experationmDate = experationmDate;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

}

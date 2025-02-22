package ru.firstTry.bot;

public class Card {
    private final int rank;
    private final int suit;

    private final String[] ranks = {"J", "Q", "K", "6", "7", "8", "9", "10", "A"};
    private final String[] suits = {"♥️", "♦️", "♣️", "♠️"};

    public Card(int rank, int suit) {
        this.suit = suit;
        this.rank = rank;
        //size = 36;
    }

    public int getRank() {
        return rank;
    }

    public int getSuit() {
        return suit;
    }

    public String nameOfCard() {
        return ranks[rank] + " " + suits[suit];
    }
}

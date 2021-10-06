package ru.firstTry.bot;

public class Cards {
    private int rank;
    private int suit;
    //private int size;
    private String[] ranks = { "J", "Q", "K", "6","7","8","9","10", "A"};
    private String[] suits = {"черви", "бубны", "крести", "пики"};

    public Cards(int rank, int suit) {
        this.suit = suit;
        this.rank = rank;
        //size = 36;
    }

    public int getRank(){
        return rank;
    }

    public int getSuit(){
        return suit;
    }

    public String nameOfCard(){
        return ranks[rank] + " : " + suits[suit];
    }
}
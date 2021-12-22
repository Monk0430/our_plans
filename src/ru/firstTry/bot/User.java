package ru.firstTry.bot;

public class User {
    public int id;

    public long chat_id;

    public String user_name;

    public String full_name;

    public String hand;

    public String deck;

    public User(long chat_id, String user_name, String full_name, String hand, String deck) {
        this.chat_id = chat_id;
        this.user_name = user_name;
        this.full_name = full_name;
        this.hand = hand;
        this.deck = deck;
    }
}
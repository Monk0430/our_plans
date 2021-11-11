package ru.firstTry.bot;

public class User {
    public int id;

    public long chat_id;

    public String user_name;

    public String full_name;

    public int balance;

    public User(int id, long chat_id, String user_name, String full_name, int balance) {
        this.id = id;
        this.chat_id = chat_id;
        this.user_name = user_name;
        this.full_name = full_name;
        this.balance = balance;
    }
}

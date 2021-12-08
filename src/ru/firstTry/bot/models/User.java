package ru.firstTry.bot.models;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
    private long chatId;

    private String username;

    private String fullName;

    private int balance;


    public User() {

    }

    public User(long chatId, String username, String fullName, int balance) {
        this.chatId = chatId;
        this.username = username;
        this.fullName = fullName;
        this.balance = balance;
    }

    @Id
    public long getChatId() {
        return this.chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String name) {
        this.username = username;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String email) {
        this.fullName = fullName;
    }

    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}

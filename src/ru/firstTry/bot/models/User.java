package ru.firstTry.bot.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "chat_id")
    private long chatId;
    private String username;
    @Column(name = "full_name")
    private String fullName;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Game> games;

    public User() {
    }

    public User(long chatId, String username, String fullName) {
        this.chatId = chatId;
        this.username = username;
        this.fullName = fullName;
        games = new ArrayList<>();
    }

    public void addGame(Game game) {
        game.setUser(this);
        games.add(game);
    }

    public void removeGame(Game game) {
        games.remove(game);
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    @Override
    public String toString() {
        return "models.User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", fullName=" + fullName +
                '}';
    }
}
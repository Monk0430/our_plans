package ru.firstTry.bot;

import org.sqlite.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DBHandler {
    private static final String CON_STR = "jdbc:sqlite:./src/resources/bot.db";

    private static DBHandler instance = null;

    public static synchronized DBHandler getInstance() throws SQLException {
        if (instance == null)
            instance = new DBHandler();
        return instance;
    }

    private final Connection connection;

    private DBHandler() throws SQLException {
        DriverManager.registerDriver(new JDBC());
        this.connection = DriverManager.getConnection(CON_STR);
    }

    public List<User> getAllUsers() {
        try (Statement statement = this.connection.createStatement()) {
            List<User> users = new ArrayList<User>();

            ResultSet resultSet = statement.executeQuery("SELECT chat_id, user_name, full_name, hand, deck FROM users");

            while (resultSet.next()) {
                users.add(new User(
                        resultSet.getLong("chat_id"),
                        resultSet.getString("user_name"),
                        resultSet.getString("full_name"),
                        resultSet.getString("hand"),
                        resultSet.getString("deck")
                )
                );
            }
            return users;

        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public User getUserByChatId(long chat_id) {
        try (PreparedStatement statement = this.connection.prepareStatement(
                "SELECT chat_id, user_name, full_name, hand, deck FROM users WHERE chat_id = ?")) {
            statement.setObject(1, chat_id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
                return new User(
                        resultSet.getLong("chat_id"),
                        resultSet.getString("user_name"),
                        resultSet.getString("full_name"),
                        resultSet.getString("hand"),
                        resultSet.getString("deck")
                );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addUser(User user) {
        try (PreparedStatement statement = this.connection.prepareStatement(
                "INSERT INTO Users(`chat_id`, `user_name`, `full_name`, `hand`, `deck`) " +
                        "VALUES(?, ?, ?, ?, ?)")) {
            statement.setObject(1, user.chat_id);
            statement.setObject(2, user.user_name);
            statement.setObject(3, user.full_name);
            statement.setObject(4, user.hand);
            statement.setObject(5, user.deck);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setHandAndDeck(long chat_id, String hand, String deck) {
        try (PreparedStatement statement = this.connection.prepareStatement(
                "UPDATE users SET hand=?, deck=? WHERE chat_id=?")) {
            statement.setObject(1, hand);
            statement.setObject(2, deck);
            statement.setObject(3, chat_id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int id) {
        try (PreparedStatement statement = this.connection.prepareStatement(
                "DELETE FROM Users WHERE id = ?")) {
            statement.setObject(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
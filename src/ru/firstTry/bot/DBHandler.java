package ru.firstTry.bot;

import org.sqlite.JDBC;

import java.sql.*;
import java.util.*;

public class DBHandler {
    private static final String CON_STR = "jdbc:sqlite:./src/resources/bot.db";

    private static DBHandler instance = null;

    public static synchronized DBHandler getInstance() throws SQLException {
        if (instance == null)
            instance = new DBHandler();
        return instance;
    }

    private Connection connection;

    private DBHandler() throws SQLException {
        DriverManager.registerDriver(new JDBC());
        this.connection = DriverManager.getConnection(CON_STR);
    }

    public List<User> getAllUsers() {
        try (Statement statement = this.connection.createStatement()) {
            List<User> users = new ArrayList<User>();

            ResultSet resultSet = statement.executeQuery("SELECT id, chat_id, user_name, full_name, balance FROM users");

            while (resultSet.next()) {
                users.add(new User(resultSet.getInt("id"),
                        resultSet.getLong("chat_id"),
                        resultSet.getString("user_name"),
                        resultSet.getString("full_name"),
                        resultSet.getInt("balance")));
            }
            return users;

        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

//    public User getUserByChatId(long chat_id) {
//        // Тут так-то надо sql запрос
//        List<User> users = getAllUsers();
//        for (User user : users) {
//            if (user.chat_id == chat_id)
//                return user;
//        }
//        return null;
//    }

    public User getUserByChatId(long chat_id) {
        try (PreparedStatement statement = this.connection.prepareStatement(
                "SELECT id, chat_id, user_name, full_name, balance FROM users WHERE chat_id = ?")) {
            statement.setObject(1, chat_id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
                return new User(resultSet.getInt("id"),
                    resultSet.getLong("chat_id"),
                    resultSet.getString("user_name"),
                    resultSet.getString("full_name"),
                    resultSet.getInt("balance"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addUser(User user) {
        try (PreparedStatement statement = this.connection.prepareStatement(
                "INSERT INTO Users(`chat_id`, `user_name`, `full_name`, `balance`) " +
                        "VALUES(?, ?, ?, ?)")) {
            statement.setObject(1, user.chat_id);
            statement.setObject(2, user.user_name);
            statement.setObject(3, user.full_name);
            statement.setObject(4, user.balance);
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

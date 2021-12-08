package ru.firstTry.bot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) {
        System.out.println(getHelloMessage("User"));
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new Handler());

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    public static String getHelloMessage(String name) {
        return "Hello, " + name + "!";
    }
}

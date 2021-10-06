package ru.firstTry.bot;

import com.pengrad.telegrambot.TelegramBot;

public class TelegramAPI {
    private static final TelegramBot bot = new TelegramBot(Config.BotToken);

    public static void SendMessage(int chatId, String text) {
    }
}

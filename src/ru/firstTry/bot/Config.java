package ru.firstTry.bot;

public class Config {
    // https://t.me/our_plans_bot
    private static final String BotToken = "2081782070:AAGj0PE4ZGtsVZdDbhZojv77aRvzYH1s068";
    private static final String BotUsername = "our_plans_bot";
    private static final String WeatherToken = "4fec795d30e972f1082d9c81736071ed";

    public static String getBotToken() {
        return BotToken;
    }

    public static String getBotUsername() {
        return BotUsername;
    }

    public static String getWeatherToken() {
        return WeatherToken;
    }

}

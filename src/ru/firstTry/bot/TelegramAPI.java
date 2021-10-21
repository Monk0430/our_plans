package ru.firstTry.bot;

import org.json.JSONObject;

public class TelegramAPI {
    private static final String apiUrl = "https://api.telegram.org/bot" + Config.getBotToken() + "/";
    private final Requests requests = new Requests();

    public JSONObject getUpdates(int offset) {
        String data = requests.get(apiUrl + "getUpdates?offset=" + offset);
        return new JSONObject(data);
    }

    public void sendMessage(int chatId, String text) {
        requests.get(apiUrl + "sendMessage?chat_id=" + chatId + "&text=" + text);
    }
}

package ru.firstTry.bot;

import org.json.JSONObject;

public class WeatherAPI {

    public static int get_weather() {
        Requests requests = new Requests();
        String url = "https://api.openweathermap.org/data/2.5/weather?" +
                "q=Ekaterinburg" +
                "&utils=metric" +
                "&appid=" + Config.getValue("weather.token");
        String data = requests.get(url);
        JSONObject obj = new JSONObject(data);
        return (int) (obj.getJSONObject("main").getDouble("temp") - 273.15);
    }
    public static String get_responceCode() {
        Requests requests = new Requests();
        String url = "https://api.openweathermap.org/data/2.5/weather?" +
                "q=Ekaterinburg" +
                "&utils=metric" +
                "&appid=" + Config.getValue("weather.token");
        String code = requests.getResponceCode(url);
        return code;
    }

}
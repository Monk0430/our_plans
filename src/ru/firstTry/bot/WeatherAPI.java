package ru.firstTry.bot;

import org.json.JSONObject;

public class WeatherAPI {

    public static int get_weather() {
        String url = "https://api.openweathermap.org/data/2.5/weather?" +
                "q=Ekaterinburg" +
                "&utils=metric" +
                "&appid=" + Config.WeatherToken;
        String data = Requests.get(url);
        JSONObject obj = new JSONObject(data);
        return (int) (obj.getJSONObject("main").getDouble("temp") - 273.15);
    }

}

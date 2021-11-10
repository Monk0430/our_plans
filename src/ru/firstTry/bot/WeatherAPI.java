package ru.firstTry.bot;

import org.json.JSONObject;

public class WeatherAPI {

    private static final String WeatherToken = "4fec795d30e972f1082d9c81736071ed";

    public static String getWeatherToken() {
        return WeatherToken;
    }

    public static int get_weather() {
        Requests requests = new Requests();
        String url = "https://api.openweathermap.org/data/2.5/weather?" +
                "q=Ekaterinburg" +
                "&utils=metric" +
                "&appid=" + getWeatherToken();
        String data = requests.get(url);
        JSONObject obj = new JSONObject(data);
        return (int) (obj.getJSONObject("main").getDouble("temp") - 273.15);
    }

}

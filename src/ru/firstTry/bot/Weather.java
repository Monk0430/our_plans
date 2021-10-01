package ru.firstTry.bot;

import org.json.JSONObject;

public class Weather {

    public static int get_weather() {
        String url = "https://api.openweathermap.org/data/2.5/weather?" +
                "q=Ekaterinburg" +
                "&utils=metric" +
                "&appid=4fec795d30e972f1082d9c81736071ed";
        String data = Requests.get(url);
        JSONObject obj = new JSONObject(data);
        return (int) (obj.getJSONObject("main").getDouble("temp") - 273.15);
    }

}

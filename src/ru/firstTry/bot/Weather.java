package ru.firstTry.bot;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Weather {

    public static int get_weather() {
        String url = "https://api.openweathermap.org/data/2.5/weather?" +
                "q=Ekaterinburg" +
                "&utils=metric" +
                "&appid=4fec795d30e972f1082d9c81736071ed";
        String data = get(url);
        JSONObject obj = new JSONObject(data);
        return (int) (obj.getJSONObject("main").getDouble("temp") - 273.15);
    }

    private static String get(String link) {
        String result = "{}";
        try {
            URL url = new URL(link);
            URLConnection yc = url.openConnection();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(yc.getInputStream())
            );
            String inputLine;
            while ((inputLine = in.readLine()) != null)
                result = inputLine;
            in.close();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        return result;
    }

}

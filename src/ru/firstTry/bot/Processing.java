package ru.firstTry.bot;

import java.net.*;
import java.io.*;
import java.net.URL;
import org.json.JSONObject;

public class Processing {
    public String processing(String command) throws IOException{
        switch (command) {
            case "-help":
                return "-weather - показывает погоду в Екатеринбурге.\n-anecdote - показывает рандомный анекдот.";
            case "-weather":
                int temp = get_weather();
                return "Температура в Ектеринбурге: " + temp + "°С";
            case "-anecdote":
                // Code
                return "Колобок повесился.";
            default:
                return "Неизвестная комманда.";
        }
    }

    private int get_weather() throws IOException{
        String url = "https://api.openweathermap.org/data/2.5/weather?"+
                "q=Ekaterinburg"+
                "&utils=metric"+
                "&appid=4fec795d30e972f1082d9c81736071ed";
        String data = get(url);
        JSONObject obj = new JSONObject(data);
        return (int)(obj.getJSONObject("main").getDouble("temp") - 273.15);

    }

    private String get(String link) throws IOException {
        URL url = new URL(link);
        URLConnection yc = url.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        yc.getInputStream()));
        String inputLine;
        String result = "";

        while ((inputLine = in.readLine()) != null)
            result = inputLine;
        in.close();
        return result;
    }
}

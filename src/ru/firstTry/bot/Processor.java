package ru.firstTry.bot;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Processor {

    public void processing(BotRequest command) {
        Console console = new Console();

        switch (command.getInput()) {
            case "-help" -> console.print(
                    '\n',
                    "-weather - показывает погоду в Екатеринбурге.",
                    "-anecdote - показывает рандомный анекдот.",
                    "-exit - завершить сеанс."
            );
            case "-weather" -> {
                int temp = WeatherAPI.get_weather();
                console.print("Температура в Ектеринбурге:", "" + temp, "°С");
            }
            case "-anecdote" -> console.print("Колобок повесился.");
            case "-exit" -> console.print("Пока.");
            default -> console.print("Неизвестная комманда.");
        }
    }

    private int get_weather() throws IOException {
        String url = "https://api.openweathermap.org/data/2.5/weather?" +
                "q=Ekaterinburg" +
                "&utils=metric" +
                "&appid=4fec795d30e972f1082d9c81736071ed";
        String data = get(url);
        JSONObject obj = new JSONObject(data);
        return (int) (obj.getJSONObject("main").getDouble("temp") - 273.15);

    }

    private String get(String link) throws IOException {
        URL url = new URL(link);
        URLConnection yc = url.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(yc.getInputStream())
        );
        String inputLine;
        String result = "";

        while ((inputLine = in.readLine()) != null)
            result = inputLine;
        in.close();
        return result;
    }

}

package ru.firstTry.bot;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;

public class Weather implements Treatment {
    @Override
    public String messageHandling(String data){
        int temp = WeatherAPI.get_weather();
        return "<b>Температура в Ектеринбурге: " + "" + String.valueOf(temp) + "°С</b>";
    }

    public boolean isPossible(String data){
        return data.equals("weather");
    }
}

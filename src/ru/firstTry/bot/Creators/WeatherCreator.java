package ru.firstTry.bot.Creators;

import org.javatuples.Pair;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import ru.firstTry.bot.Keyboards;
import ru.firstTry.bot.WeatherAPI;

public class WeatherCreator implements Treatment {
    @Override
    public Pair<String, InlineKeyboardMarkup> messageHandling(String data){
        int temp = WeatherAPI.get_weather();
        String message = "<b>Температура в Ектеринбурге: " + "" + String.valueOf(temp) + "°С</b>";
        return new Pair<String, InlineKeyboardMarkup>(message, Keyboards.getBackKeyboard("start"));
    }

    public boolean isPossible(String data){
        return data.equals("weather");
    }
}

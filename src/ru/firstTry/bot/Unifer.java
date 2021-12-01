package ru.firstTry.bot;

import org.javatuples.Pair;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import ru.firstTry.bot.Creators.AnectodesCreator;
import ru.firstTry.bot.Creators.StartCreator;
import ru.firstTry.bot.Creators.Treatment;
import ru.firstTry.bot.Creators.WeatherCreator;

import java.util.ArrayList;
import java.util.List;

;

public class Unifer {

    private final List<Treatment> list;

    public Unifer(){
        list = new ArrayList<>();
        list.add(new AnectodesCreator());
        list.add(new WeatherCreator());
        list.add(new StartCreator());
    }

    public Pair<String, InlineKeyboardMarkup> handleUpdate(Update update) {
        String data = update.getCallbackQuery().getData();
        for (Treatment p : list)
            if (p.isPossible(data)) {
                return p.messageHandling(data);
            }
        return null;
    }
}

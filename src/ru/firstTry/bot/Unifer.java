package ru.firstTry.bot;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
;

public class Unifer {

    private final List<Treatment> list;

    public Unifer(){
        list = new ArrayList<>();
        list.add(new AnectodesCreator());
        list.add(new Weather());
    }
    public String[] handleUpdate(Update update) {
        String[] arr = new String[2];
        String data = update.getCallbackQuery().getData();
        for (Treatment p : list)
            if (p.isPossible(data)) {
                arr[0] = p.messageHandling(data);
                arr[1] = "start";
                return arr;
            }
        return null;
    }
}

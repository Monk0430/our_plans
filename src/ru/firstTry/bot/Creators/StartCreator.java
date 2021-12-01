package ru.firstTry.bot.Creators;


import org.javatuples.Pair;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import ru.firstTry.bot.Keyboards;

public class StartCreator implements Treatment {
    @Override
    public Pair<String, InlineKeyboardMarkup> messageHandling(String data) {
        return new Pair<String, InlineKeyboardMarkup>("<b>Выберите кнопку</b>", Keyboards.getStartKeyboard());
    }

    @Override
    public boolean isPossible(String data) {
        return data.equals("start");
    }
}

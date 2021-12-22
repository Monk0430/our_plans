package ru.firstTry.bot.Creators;


import org.javatuples.Pair;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import ru.firstTry.bot.Keyboards;

public class AnecdotesCreator implements Treatment {
    @Override
    public Pair<String, InlineKeyboardMarkup> messageHandling(String data) {
        return new Pair<String, InlineKeyboardMarkup>("\"<b>Колобок повесился</b>\"", Keyboards.getBackKeyboard("start"));
    }

    @Override
    public boolean isPossible(String data) {
        return data.equals("anecdote");
    }
}

package ru.firstTry.bot.Creators;

import org.javatuples.Pair;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public interface Treatment {
    public Pair<String, InlineKeyboardMarkup> messageHandling(String data);
    public boolean isPossible(String data);
}

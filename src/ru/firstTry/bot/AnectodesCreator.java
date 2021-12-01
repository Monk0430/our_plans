package ru.firstTry.bot;

import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;

public class AnectodesCreator implements Treatment {
    @Override
    public String messageHandling(String data) {
        return "<b>Колобок повесился</b>";
    }

    @Override
    public boolean isPossible(String data) {
        return data.equals("anecdote");
    }
}

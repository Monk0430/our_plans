package ru.firstTry.bot;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class Keyboards {
    public static InlineKeyboardMarkup getStartKeyboard() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(getButton("Погода", "weather"));
        rowList.add(getButton("Анекдот", "anecdote"));
        rowList.add(getButton("Играть", "play"));
        inlineKeyboardMarkup.setKeyboard(rowList);

        return inlineKeyboardMarkup;
    }
    public static InlineKeyboardMarkup getStartGameKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> gameList = new ArrayList<>();
        gameList.add(getButton("посмотреть руку", "hand"));
        gameList.add(getButton("взять карту", "take"));
        gameList.add(getButton("вскрываемся", "result"));
        inlineKeyboardMarkup.setKeyboard(gameList);
        return inlineKeyboardMarkup;
    }

    public static InlineKeyboardMarkup getBackKeyboard(String callBack) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        List<List<InlineKeyboardButton>> gameList = new ArrayList<>();
        rowList.add(getBackButton(callBack));
        gameList.add(getBackButton(callBack));
        inlineKeyboardMarkup.setKeyboard(rowList);
        inlineKeyboardMarkup.setKeyboard(gameList);
        return inlineKeyboardMarkup;
    }

    public static List<InlineKeyboardButton> getBackButton(String callBack) {
        return getButton("« Назад", callBack);
    }

    private static List<InlineKeyboardButton> getButton(String text, String callBack) {
        InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
        inlineKeyboardButton.setText(text);
        inlineKeyboardButton.setCallbackData(callBack);
        List<InlineKeyboardButton> keyboardButtonsRow = new ArrayList<>();
        keyboardButtonsRow.add(inlineKeyboardButton);
        return keyboardButtonsRow;
    }

}

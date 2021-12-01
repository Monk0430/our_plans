package ru.firstTry.bot.Creators;


import org.javatuples.Pair;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import ru.firstTry.bot.Deck;
import ru.firstTry.bot.Game;
import ru.firstTry.bot.Keyboards;

public class GameCreator implements Treatment {
    Deck deck;
    Game newGame;
    @Override
    public Pair<String, InlineKeyboardMarkup> messageHandling(String data) {
        switch (data) {
            case "play" -> {
                deck = new Deck();
                newGame = new Game(deck);
                newGame.showHand();
                return new Pair<String, InlineKeyboardMarkup>(
                        "<b>Сыграем</b>",
                        Keyboards.getStartGameKeyboard()
                );
            }
            case "hand" -> {
                return new Pair<String, InlineKeyboardMarkup>(
                        newGame.play(deck,"Посмотреть руку"),
                        Keyboards.getBackKeyboard("play")
                );
            }
            case "take" -> {
                return new Pair<String, InlineKeyboardMarkup>(
                        newGame.play(deck,"Взять карту"),
                        Keyboards.getBackKeyboard("play")
                );

            } case "result" -> {
                return new Pair<String, InlineKeyboardMarkup>(
                        newGame.play(deck,"Хватит"),
                        Keyboards.getBackKeyboard("start")
                );
            }
        }
        return null;
    }

    @Override
    public boolean isPossible(String data) {
        return data.equals("play") || data.equals("hand") || data.equals("take") || data.equals("result");
    }
}

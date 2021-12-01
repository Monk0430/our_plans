package ru.firstTry.bot.Creators;


import org.javatuples.Pair;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import ru.firstTry.bot.Game;
import ru.firstTry.bot.Keyboards;

public class GameCreator implements Treatment {
    private Game game;

    @Override
    public Pair<String, InlineKeyboardMarkup> messageHandling(String data) {
        switch (data) {
            case "start_game" -> {
                game = new Game();
                game.showHand();
                return new Pair<String, InlineKeyboardMarkup>(
                        "<b>Сыграем</b>",
                        Keyboards.getStartGameKeyboard()
                );
            }
            case "play" -> {
                game.showHand();
                return new Pair<String, InlineKeyboardMarkup>(
                        "<b>Сыграем</b>",
                        Keyboards.getStartGameKeyboard()
                );
            }
            case "hand" -> {
                return new Pair<String, InlineKeyboardMarkup>(
                        game.play("посмотреть руку"),
                        Keyboards.getBackKeyboard("play")
                );
            }
            case "take" -> {
                return new Pair<String, InlineKeyboardMarkup>(
                        game.play("взять карту"),
                        Keyboards.getBackKeyboard("play")
                );

            } case "result" -> {
                return new Pair<String, InlineKeyboardMarkup>(
                        game.play("хватит"),
                        Keyboards.getBackKeyboard("start")
                );
            }
        }
        return null;
    }

    @Override
    public boolean isPossible(String data) {
        return data.equals("start_game") || data.equals("play") || data.equals("hand") || data.equals("take") || data.equals("result");
    }
}

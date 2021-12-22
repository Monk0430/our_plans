package ru.firstTry.bot.Creators;


import org.javatuples.Pair;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import ru.firstTry.bot.Game;
import ru.firstTry.bot.Keyboards;

public class GameCreator implements Treatment {
    private final long chat_id;

    public GameCreator(long chat_id) {
        this.chat_id = chat_id;
    }

    @Override
    public Pair<String, InlineKeyboardMarkup> messageHandling(String data) {
        switch (data) {
            case "start_game" -> {
                Game.start(this.chat_id);
                String text = Game.showHand(this.chat_id) + "\n" + "<b>Ваш счет:</b> " + Game.scoring(this.chat_id);
                return new Pair<String, InlineKeyboardMarkup>(
                        text,
                        Keyboards.getStartGameKeyboard()
                );
            }
            case "take" -> {
                Game.getCard(this.chat_id);
                String text = Game.showHand(this.chat_id) + "\n" + Game.scoring(this.chat_id);
                return new Pair<String, InlineKeyboardMarkup>(
                        text,
                        Keyboards.getStartGameKeyboard()
                );
            }

            case "result" -> {
                String score = Game.result(this.chat_id);
                return new Pair<String, InlineKeyboardMarkup>(
                        score,
                        Keyboards.getBackKeyboard("start")
                );
            }
        }
        return null;
    }

    @Override
    public boolean isPossible(String data) {
        return data.equals("start_game") || data.equals("play") ||
                data.equals("hand") || data.equals("take") || data.equals("result");
    }
}
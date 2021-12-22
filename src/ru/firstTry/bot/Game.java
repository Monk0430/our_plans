package ru.firstTry.bot;

import com.google.gson.Gson;
import org.json.JSONObject;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private static final Gson gson = new Gson();


    public static void start(long chat_id) {
        ArrayList<Card> deck = new ArrayList<>(36);
        for(int i=0 ; i<4; i++) {
            for(int j = 0; j<9; j++) {
                deck.add(new Card(j, i));
            }
        }

        List<List<Integer>> formatDeck = GameUtil.formatCards(deck);
        List<List<Integer>> formatHand = new ArrayList<List<Integer>>();

        for (int i = 0; i < 2; i++) {
            int rnd = GameUtil.random(formatDeck.size());
            deck.remove(deck.get(rnd));
            formatHand.add(formatDeck.get(rnd));
        }
        
        String deck_obj = gson.toJson(GameUtil.formatCards(deck));
        String hand_obj = gson.toJson(formatHand);
        
        try {
            DBHandler dbHandler = DBHandler.getInstance();
            dbHandler.setHandAndDeck(chat_id, hand_obj, deck_obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static String showHand(long chat_id) {
        User user = null;
        try {
            DBHandler dbHandler = DBHandler.getInstance();
            user = dbHandler.getUserByChatId(chat_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JSONObject hand = new JSONObject("{'json': " + user.hand + "}");

        return "<b>Ваши карты:</b> " + GameUtil.showHand(GameUtil.toCards(hand));
    }

    public static void getCard(long chat_id) {
        User user = null;
        try {
            DBHandler dbHandler = DBHandler.getInstance();
            user = dbHandler.getUserByChatId(chat_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JSONObject deck = new JSONObject("{'json': " + user.deck + "}");
        List<List<Integer>> formatDeck = GameUtil.toArray(deck);
        int rnd = GameUtil.random(formatDeck.size());
        List<Integer> card = formatDeck.get(rnd);
        formatDeck.remove(card);
        JSONObject hand = new JSONObject("{'json': " + user.hand + "}");
        List<List<Integer>> formatHand = GameUtil.toArray(hand);
        formatHand.add(card);

        String deck_obj = gson.toJson(formatDeck);
        String hand_obj = gson.toJson(formatHand);
        try {
            DBHandler dbHandler = DBHandler.getInstance();
            dbHandler.setHandAndDeck(chat_id, hand_obj, deck_obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int scoring(long chat_id) {
        User user = null;
        try {
            DBHandler dbHandler = DBHandler.getInstance();
            user = dbHandler.getUserByChatId(chat_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JSONObject hand = new JSONObject("{'json': " + user.hand + "}");
        return GameUtil.score(GameUtil.toCards(hand));
    }

    public static String result(long chat_id) {
        User user = null;
        try {
            DBHandler dbHandler = DBHandler.getInstance();
            user = dbHandler.getUserByChatId(chat_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<Card> botHand = new ArrayList<>();
        JSONObject deck = new JSONObject("{'json': " + user.deck + "}");
        List<List<Integer>> formatDeck = GameUtil.toArray(deck);
        for (int i = 0; i < 2; i++) {
            int rnd = GameUtil.random(formatDeck.size());
            List<Integer> card = formatDeck.get(rnd);
            formatDeck.remove(formatDeck.get(rnd));
            botHand.add(new Card(card.get(0), card.get(1)));
        }

        int total = GameUtil.score(botHand);
        while (true) {
            int a = 21 - total;
            int rnd = GameUtil.random(15);
            if (rnd < a) {
                int _rnd = GameUtil.random(formatDeck.size());
                List<Integer> card = formatDeck.get(_rnd);
                formatDeck.remove(formatDeck.get(_rnd));
                botHand.add(new Card(card.get(0), card.get(1)));
                total = GameUtil.score(botHand);
            }
            else break;
        }

        JSONObject hand = new JSONObject("{'json': " + user.hand + "}");
        int userTotal = GameUtil.score(GameUtil.toCards(hand));
        String text = "<b>Ваш счет:</b> " + userTotal + "\n<b>Счет бота:</b> " + total + "\n\n" +
                "<b>Ваши карты:</b> " + GameUtil.showHand(GameUtil.toCards(hand)) + "\n<b>Карты бота:</b> " + GameUtil.showHand(botHand);

        if (total == userTotal || (total > 21 && userTotal > 21)) return "<b>Ничья</b>\n" + text;
        if (total > 21 && userTotal <= 21) return "<b>Вы выиграли</b>\n" + text;
        if (total <= 21 && userTotal > 21) return "<b>Вы проиграли</b>\n" + text;
        if (total < userTotal) return "<b>Вы выиграли</b>\n" + text;
        return "<b>Вы проиграли</b>\n" + text;
    }
}

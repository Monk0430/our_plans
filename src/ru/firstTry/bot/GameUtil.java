package ru.firstTry.bot;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GameUtil {

    public static int random(int size) {
        return (int)(Math.random() * size);
    }

    public static List<List<Integer>> formatCards(ArrayList<Card> cards) {
        List<List<Integer>> result = new ArrayList<>();
        for(Card card : cards) {
            List<Integer> _card = new ArrayList<>();
            _card.add(card.getRank());
            _card.add(card.getSuit());
            result.add(_card);
        }
        return result;
    }

    public static List<Card> toCards(JSONObject json) {
        List<Card> result = new ArrayList<>();
        JSONArray jsonArray = json.getJSONArray("json");
        int length = jsonArray.length();
        for (int i = 0; i < length; i++) {
            List<Integer> list = new ArrayList<>();
            result.add(new Card(jsonArray.getJSONArray(i).getInt(0),
                    jsonArray.getJSONArray(i).getInt(1)));
        }
        return result;
    }

    public static List<List<Integer>> toArray(JSONObject json) {
        List<List<Integer>> result = new ArrayList<>();
        JSONArray jsonArray = json.getJSONArray("json");
        int length = jsonArray.length();
        for (int i = 0; i < length; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(jsonArray.getJSONArray(i).getInt(0));
            list.add(jsonArray.getJSONArray(i).getInt(1));
            result.add(list);
        }
        return result;
    }

    public static int score(List<Card> hand) {
        int value = 0;
        for(Card card : hand){
            value += card.getRank() +3;
        }
        return value;
    }

    public static String showHand(List<Card> hand) {

        StringBuilder str = new StringBuilder("\n");
        for(Card card : hand){
            str.append(card.nameOfCard()).append("\n");
        }
        return "" + str;
    }
}

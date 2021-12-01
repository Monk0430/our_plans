package ru.firstTry.bot;

import java.util.ArrayList;

public class Game {

    private final ArrayList<Cards> hand;
    public Game(Deck deck) {
        hand = new ArrayList<Cards>();
        for (int i = 0; i < 2; i++) {
            hand.add(deck.DrawCard());
        }
        //showHand();
    }

    public String play(Deck deck,String command) {
        switch (command) {
            case "посмотреть руку":
                return showHand();
            case "взять карту":
                Cards drewCard = deck.DrawCard();
                hand.add(drewCard);
                return drewCard.nameOfCard();
            case "хватит" :
                return Scoring();
            default:
                return "null";
        }
    }


    public String showHand(){
        String str = "\n";
        for(Cards card : hand){
            str += (card.nameOfCard() + "\n");
        }
        return "у вас на руке: " + str;
    }
    public String Scoring(){
        int value = 0;
        for(Cards card : hand){
            value += card.getRank() +3;
        }
        if(value >21)
            return "вы проиграли";
        else
            return  String.valueOf(value);
    }
}


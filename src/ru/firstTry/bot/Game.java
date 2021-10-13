package ru.firstTry.bot;

import java.util.ArrayList;

public class Game {

    private ArrayList<Cards> hand;
    public Game(Deck deck){
        hand = new ArrayList<Cards>();
        for (int i = 0; i < 2; i++) {
            hand.add(deck.DrawCard());
        }
        //showHand();
    }

    public void play(Deck deck, BotRequest command) {
        switch (command.getInput()) {
            case "посмотреть руку":
                showHand();
                break;
            case "взять карту":
                Cards drewCard = deck.DrawCard();
                System.out.println(drewCard.nameOfCard());
                hand.add(drewCard);
                break;
            case "хватит":
                Scoring();
                break;
            default:
                System.out.println("неопознанная команда");
                break;
        }
    }


    public void showHand(){
        System.out.println("у вас на руке :");
        for(Cards card : hand){
            System.out.println(card.nameOfCard());
        }
    }
    public void Scoring(){
        int value = 0;
        for(Cards card : hand){
            value += card.getRank() +3;
        }
        if(value >21)
            System.out.println("вы проиграли");
        else
            System.out.println(value);
    }
}


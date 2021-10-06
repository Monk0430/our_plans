package ru.firstTry.bot;
import java.util.ArrayList;

public class Deck {
    private final ArrayList<Cards> deck;

    public Deck()
    {
        deck = new ArrayList<>(36);
        for(int i =0 ; i < 4; i++) {
            for(int j = 0; j< 9; j++){
                deck.add(new Cards(j,i));
            }
        }
    }
    public Cards DrawCard(){
        int rnd = (int)(Math.random() * deck.size());
        Cards card = deck.get(rnd);
        deck.remove(card);
        return card;
    }

}

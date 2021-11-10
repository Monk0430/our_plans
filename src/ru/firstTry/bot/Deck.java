package ru.firstTry.bot;
import java.util.ArrayList;
import java.util.Scanner;

public class Deck {
    private ArrayList<Cards> deck;
    /*Deck deck = new Deck();
    Game newGame = new Game(deck);
    Scanner sc = new Scanner(System.in);
    while(true){
        String command = sc.nextLine();
        newGame.play(deck, command);
        if(command.equals("стоп"))
            break;
    }*/

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

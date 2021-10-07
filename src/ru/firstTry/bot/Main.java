package ru.firstTry.bot;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Game newGame = new Game(deck);
        Console console = new Console();
        console.print('\n', "Привет.");
        Processor processor = new Processor();
        BotRequest command;

        do {
            command = console.input();
            String str =  processor.processing(command);
            if(str.equals("go"))
            {
                newGame.play(deck, command.getInput());
            }
            else
            console.print(str);
        } while (!command.getInput().equals("-exit"));

    }
}

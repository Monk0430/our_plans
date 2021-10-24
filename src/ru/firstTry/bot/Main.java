package ru.firstTry.bot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) {
//        Deck deck = new Deck();
//        Game newGame = new Game(deck);
//        Console console = new Console();
//        console.print('\n', "Привет.");
//        Processor processor = new Processor();
//        BotRequest command;
//        BotRequest commandForGame;
//        boolean flag = false;
//
//        do {
//            command = console.input();
//            String str =  processor.processing(command);
//            if(str.equals("go"))
//            {
//                console.print("да начнётся игра");
//                commandForGame = console.input();
//                command = null;
//                while(!commandForGame.getInput().equals("stop")){
//                    if(flag)
//                        commandForGame = console.input();
//                    newGame.play(deck,commandForGame);
//                    flag = true;
//                }
//            }
//            else
//            console.print(str);
//        } while (!command.getInput().equals("-exit"));

        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new Handler());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }


    }
}

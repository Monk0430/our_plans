package ru.firstTry.bot;

import org.json.JSONArray;
import org.json.JSONObject;

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

        Processor processor = new Processor();
        TelegramAPI bot = new TelegramAPI();
        int updateId = 0;

        while (true) {
            JSONObject data = bot.getUpdates(updateId + 1);
            if (data.getBoolean("ok")){

                JSONArray results = data.getJSONArray("result");
                for(Object result : results) {
                    JSONObject update = new JSONObject(result.toString());
                    System.out.println(update);
                    updateId = update.getInt("update_id");
                    int chatId = update.getJSONObject("message").getJSONObject("chat").getInt("id");
                    String text = update.getJSONObject("message").getString("text");
                    bot.sendMessage(chatId, processor.processing(text));
                }

            }
        }


    }
}

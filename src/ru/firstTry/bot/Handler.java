package ru.firstTry.bot;

import org.javatuples.Pair;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.sql.SQLException;

public class Handler extends TelegramLongPollingBot {
    private final Unifer unifer = new Unifer();

    @Override
    public String getBotToken() {
        return Config.getValue("bot.token");
    }

    @Override
    public String getBotUsername() {
        return Config.getValue("bot.name");
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = new SendMessage();
            message.setChatId(update.getMessage().getChatId().toString());
            message.setParseMode("HTML");

            message.setText("<b>Нажмите на кнопку</b>");
            message.setReplyMarkup(Keyboards.getStartKeyboard());


            long longChatId = update.getMessage().getChatId();
            String userName = update.getMessage().getChat().getUserName();
            String fullName = update.getMessage().getChat().getFirstName() + " "
                    + update.getMessage().getChat().getLastName();
            try {
                DBHandler dbHandler = DBHandler.getInstance();
                if (dbHandler.getUserByChatId(longChatId) == null)
                    dbHandler.addUser(new User(1, longChatId, userName, fullName, 0));
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
        if (update.hasCallbackQuery()) {
            String chatId = update.getCallbackQuery().getMessage().getChatId().toString();
            Integer messageId = update.getCallbackQuery().getMessage().getMessageId();
            AnswerCallbackQuery answer = new AnswerCallbackQuery();
            EditMessageText message = new EditMessageText();
            message.setChatId(chatId);
            message.setMessageId(messageId);
            message.setParseMode("HTML");

            Pair<String, InlineKeyboardMarkup> creator = unifer.handleUpdate(update);
            message.setText(creator.getValue0());
            message.setReplyMarkup(creator.getValue1());
            try {
                if (answer.getText() != null)
                    execute(answer);
                else
                    execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

        }

    }
}
        /*if (update.hasCallbackQuery()) {
            String chatId = update.getCallbackQuery().getMessage().getChatId().toString();
            Integer messageId = update.getCallbackQuery().getMessage().getMessageId();
            String data = update.getCallbackQuery().getData();

            AnswerCallbackQuery answer = new AnswerCallbackQuery();

            EditMessageText message = new EditMessageText();
            message.setChatId(chatId);
            message.setMessageId(messageId);
            message.setParseMode("HTML");

            switch (data) {
                case "start" -> {
                    message.setText("<b>Нажмите на кнопку</b>");
                    message.setReplyMarkup(Keyboards.getStartKeyboard());
                }
                case "weather" -> {
                    int temp = WeatherAPI.get_weather();
                    message.setText("<b>Температура в Ектеринбурге: " + "" + temp + "°С</b>");
                    message.setReplyMarkup(Keyboards.getBackKeyboard("start"));
                }
                case "anecdote" -> {
                    message.setText("<b>Колобок повесился</b>");
                    message.setReplyMarkup(Keyboards.getBackKeyboard("start"));
                }
                case "play" -> {
                    deck = new Deck();
                    newGame = new Game(deck);
                    newGame.showHand();
                    message.setText("<b>сыграем</b>");
                    message.setReplyMarkup(Keyboards.getStartGameKeyboard());
                }
                case "hand" -> {
                    message.setText(newGame.play(deck,"посмотреть руку"));
                    message.setReplyMarkup(Keyboards.getBackKeyboard("play"));
                }
                case "take" -> {
                    message.setText(newGame.play(deck,"взять карту"));
                    message.setReplyMarkup(Keyboards.getBackKeyboard("play"));
                } case "result" -> {
                    message.setText(newGame.play(deck,"хватит"));
                    message.setReplyMarkup(Keyboards.getBackKeyboard("start"));
                }
                default -> {
                    answer.setCallbackQueryId(update.getCallbackQuery().getId());
                    answer.setText("⚠️ Эту функцию еще не завезли ⚠️");
                    try {
                        execute(answer);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            }
     */









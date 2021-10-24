package ru.firstTry.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Handler extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return Config.getBotUsername();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = new SendMessage();
            message.setChatId(update.getMessage().getChatId().toString());
            message.setParseMode("HTML");

            message.setText("<b>Нажмите на кнопку</b>");
            message.setReplyMarkup(Keyboards.getStartKeyboard());

            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

        if (update.hasCallbackQuery()) {
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

    @Override
    public String getBotToken() {
        return Config.getBotToken();
    }



}

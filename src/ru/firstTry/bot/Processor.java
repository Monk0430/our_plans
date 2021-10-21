package ru.firstTry.bot;

public class Processor {

    public String processing(String command) {
        switch (command) {
            case "/start":
                return "Привет!) Нажми /help, чтобы ознакомится с командами.";
            case "/help":
                return (
                    "/weather - показывает погоду в Екатеринбурге. %0A" +
                    "/anecdote - показывает рандомный анекдот. %0A" +
                    "/exit - завершить сеанс."
            );
            case "/weather":
                int temp = WeatherAPI.get_weather();
                return ("Температура в Ектеринбурге: " + "" + temp + "°С");

            case "/anecdote": return ("Колобок повесился.");
            case "/game": return ("go");
            default: return("Неизвестная комманда.");
        }
    }
}

package ru.firstTry.bot;

public class Processor {

    public String processing(BotRequest command) {
        switch (command.getInput()) {
            case "-help":
                return (
                    '\n' +
                    "-weather - показывает погоду в Екатеринбурге." + '\n' +
                    "-anecdote - показывает рандомный анекдот." + '\n' +
                    "-exit - завершить сеанс."
            );
            case "-weather":
                int temp = WeatherAPI.get_weather();
                return ("Температура в Ектеринбурге:" + "" + temp + "°С");

            case "-anecdote": return ("Колобок повесился.");
            case "-exit": return ("Пока.");
            case "-game": return ("go");
            default: return("Неизвестная комманда.");
        }
    }
}

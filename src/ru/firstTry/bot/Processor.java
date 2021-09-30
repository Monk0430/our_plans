package ru.firstTry.bot;

public class Processor {

    public void processing(String command) {
        Console console = new Console();

        switch (command) {
            case "-help" -> console.print(
                    '\n',
                    "-weather - показывает погоду в Екатеринбурге.",
                    "-anecdote - показывает рандомный анекдот.",
                    "-exit - завершить сеанс."
            );
            case "-weather" -> {
                int temp = Weather.get_weather();
                console.print("Температура в Ектеринбурге:", "" + temp, "°С");
            }
            case "-anecdote" -> console.print("Колобок повесился.");
            case "-exit" -> console.print("Пока.");
            //case "-game21" ->
            default -> console.print("Неизвестная комманда.");
        }
    }
}

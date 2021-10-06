package ru.firstTry.bot;

public class Main {
    public static void main(String[] args) {
        Console console = new Console();
        console.print('\n', "Привет.");
        Processor processor = new Processor();
        BotRequest command;

        do {
            command = console.input();
            processor.processing(command);
        } while (!command.getInput().equals("-exit"));
    }
}

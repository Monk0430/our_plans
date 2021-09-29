package ru.firstTry.bot;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Console console = new Console();
        console.print('\n', "Привет.");
        Processor processor = new Processor();
        String command;

        do {
            command = console.input();
            processor.processing(command);
        } while (!command.equals("-exit"));
    }
}

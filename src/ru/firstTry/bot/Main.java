package ru.firstTry.bot;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Input input = new Input();
        Processing command = new Processing();
        OutPut output = new OutPut();
        String str = input.readLn();
        String comm = command.processing(str);
        output.writeln(comm);
    }
}

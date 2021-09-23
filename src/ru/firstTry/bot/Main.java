package ru.firstTry.bot;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(getHelloMessage("User"));
        Input input = new Input();
        Processing command = new Processing();
        OutPut output = new OutPut();
        String str = "";
        while (!str.equals("-exit")){
            str = input.readLn();
            String comm = command.processing(str);
            output.writeln(comm);
        }
    }
    public static String getHelloMessage(String name){
        return "Hello, " + name + "!";
    }
}

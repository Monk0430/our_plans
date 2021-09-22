package ru.firstTry.bot;

import java.util.HashMap;
import java.util.Map;

public class Processing {
    public String Processing(String command) {
        switch (command) {
            case "-help":
                return "-weather - показывает погоду в Екатеринбурге.\n-anecdote - показывает рандомный анекдот.";
            case "-weather":
                // Code

                return "14";
            case "-anecdote":
                // Code
                return "Anecdote";
            default:
                return "Неизвестная комманда.";
        }
    }
}

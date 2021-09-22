package ru.firstTry.bot;

import java.util.HashMap;
import java.util.Map;

public class Processing {
    public Map Dict;
    public  Processing() {
        Dict = new HashMap();
        Dict.put("-help", "list of bot commands:\n" +
                "-weather\n" +
                "-anecdote");
        Dict.put("-weather", "it's not working yet :c");
        Dict.put("-anecdote", "haha");
    }

}

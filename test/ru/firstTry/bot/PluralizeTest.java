package ru.firstTry.bot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PluralizeTest {
    @Test
    void genitiveCase() {
        Handler handler = new Handler();
        String reply = handler.pluralize(20);
        assertEquals("пользователей", reply);
    }
    @Test
    void nominativeCase() {
        Handler handler = new Handler();
        String reply = handler.pluralize(1);
        assertEquals("пользователь", reply);
    }
    @Test
    void accusativeCase() {
        Handler handler = new Handler();
        String reply = handler.pluralize(22);
        assertEquals("пользователя", reply);
    }

}

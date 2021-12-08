package ru.firstTry.bot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {
    @Test
    void testCorrectHelloMessage() {
        String name = "User";
        String helloMessage = Main.getHelloMessage(name);
        assertEquals("Hello, " + name + "!", helloMessage);
    }
}
package ru.firstTry.bot;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class MainTest {
    @Test
    void testCorrectHelloMessage() {
        String name = "User";
        String helloMessage = Main.getHelloMessage(name);
        assertEquals("Hello, " + name + "!", helloMessage);
    }
}
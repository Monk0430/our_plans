package ru.firstTry.bot;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class ProcessingTest {
    @Test
    void testCorrectCommandOutput() throws IOException {
        Processing command = new Processing();
        String comm = command.processing("-anecdote");
        assertEquals("Колобок повесился.", comm);
    }
    @Test
    void test2() throws IOException {
        Processing command = new Processing();
        String comm = command.processing("-help");
        assertEquals("-weather - показывает погоду в Екатеринбурге.\n-anecdote - показывает рандомный анекдот.", comm);
    }
//    @Test
//    void test3() throws IOException {
//        Processing command = new Processing();
//        String comm = command.processing("-weather");
//        assertEquals("14", comm);
//    }
    @Test
    void test4() throws IOException {
        Processing command = new Processing();
        String comm = command.processing("-someOtherUnknownCommand");
        assertEquals("Неизвестная комманда.", comm);
    }
}
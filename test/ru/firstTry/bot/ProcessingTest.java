package ru.firstTry.bot;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProcessingTest {
    @Test
    public void testCorrectCommandOutput() throws IOException {
        Processing command = new Processing();
        String comm = command.processing("-anecdote");
        assertEquals("Колобок повесился.", comm);
    }

    @Test
    public void test2() throws IOException {
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
    public void test4() throws IOException {
        Processing command = new Processing();
        String comm = command.processing("-someOtherUnknownCommand");
        assertEquals("Неизвестная комманда.", comm);
    }
}
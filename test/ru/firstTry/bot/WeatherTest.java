package ru.firstTry.bot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherTest {
    @Test
    void testResponseCode() {
        String responceCode = WeatherAPI.get_responceCode();
        assertEquals("200", responceCode);
    }
}

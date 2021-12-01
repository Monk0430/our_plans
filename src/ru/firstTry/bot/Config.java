package ru.firstTry.bot;
import java.io.*;
import java.util.Properties;

public class Config {

    public static String getValue(String key)  {
        FileInputStream fis;
        Properties property = new Properties();

        try {
            fis = new FileInputStream("src/resources/config.properties");
            property.load(fis);
            return property.getProperty(key);

        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
        return null;
    }
}

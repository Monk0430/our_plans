package ru.firstTry.bot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Requests {

    public static String get(String link) {
        String result = "{}";
        try {
            URL url = new URL(link);
            URLConnection yc = url.openConnection();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(yc.getInputStream())
            );
            String inputLine;
            while ((inputLine = in.readLine()) != null)
                result = inputLine;
            in.close();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        return result;
    }

}

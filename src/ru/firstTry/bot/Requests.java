package ru.firstTry.bot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class Requests {
    private final String USER_AGENT = "Mozilla/5.0";

    public String get(String url) {
        StringBuffer response = new StringBuffer();
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);

            int responseCode = con.getResponseCode();

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return response.toString();
    }

    public String getResponceCode(String url) {
        StringBuffer responseCode = new StringBuffer();
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);
            int response_Code = con.getResponseCode();
            responseCode.append(response_Code);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return responseCode.toString();
    }

}
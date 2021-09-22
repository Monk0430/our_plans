package ru.firstTry.bot;

import java.util.Scanner;

public class Input {

    public  String text;
    public  Input(){
        this.text = text;
    }

    public void readln(){
        Scanner sc = new Scanner(System.in);
        text = sc.next();
        System.out.println(text);
    }
}

package ru.firstTry.bot;

import java.util.Scanner;

public class Console {

    public String input() {
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    /**
     * @param texts - аргументы для вывода текста
     */
    public void print(String ... texts) {
        for (String text : texts) System.out.print(text + " ");
        System.out.println();
    }

    /**
     * @param sup - окончание
     * @param texts - аргументы для вывода текста
     */
    public void print(char sup, String ... texts) {
        for (String text : texts) System.out.print("" + text + sup);
    }

}

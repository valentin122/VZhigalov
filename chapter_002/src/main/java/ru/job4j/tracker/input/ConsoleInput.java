package ru.job4j.tracker.input;

import ru.job4j.tracker.menu.MenuOutException;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    @Override
    public int ask(String question, ArrayList<Integer> range) throws MenuOutException {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutException("out of menu range");
        }
        return key;
    }
}

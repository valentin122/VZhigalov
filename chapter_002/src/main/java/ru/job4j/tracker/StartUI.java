package ru.job4j.tracker;

import ru.job4j.tracker.input.ConsoleInput;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.ValidateInput;
import ru.job4j.tracker.menu.MenuTracker;

import java.util.ArrayList;

/**
 * StartUI
 *
 * @author Valentin Zhigalov (VAL1915@ya.ru)
 * @version 0.1
 * @since 16.01.19
 */

public class StartUI {
    private final Input input;
    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        ArrayList<Integer> range = new ArrayList<>();
        int rangeMenu = menu.getActionsLength();
        for (int i = 0; i < rangeMenu; i++) {
            range.add(i);
        }
        do {
            menu.show();
            menu.select(input.ask("select:", range));
        } while (!"6".equals(this.input.ask("Exit?(6): ")));

    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }
}


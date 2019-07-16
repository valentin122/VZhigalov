package ru.job4j.tracker;

import java.util.ArrayList;

/**
 * StartUI
 *
 * @author Valentin Zhigalov (VAL1915@ya.ru)
 * @version 0.1
 * @since 16.01.19
 */

public class StartUI {
    MenuTracker menuTracker = new MenuTracker();
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

class Exit implements UserAction {

    public int key() {
        return 6;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("Selected exit. Goodbye!");

    }

    @Override
    public String info() {
        return "6. Exit";
    }
}


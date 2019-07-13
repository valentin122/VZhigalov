package ru.job4j.tracker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * StartUI
 *
 * @author Valentin Zhigalov (VAL1915@ya.ru)
 * @version 0.1
 * @since 16.01.19
 */

public class StartUI {
    MenuTracker menuTracker = new MenuTracker();
    public int rangeMenu = menuTracker.getActionsLength();
    private final Input input;
    private final Tracker tracker;
     protected boolean exit = false;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    //Exit exitProgram = new Exit();

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        ArrayList<Integer> range = new ArrayList<>(rangeMenu);
        menu.fillActions();
        for (int i = 0; i < rangeMenu; i++) {
            range.add(i);
        }
        do {
            menu.show();
            menu.select(input.ask("select:", range));
        } while (!"6".equals(this.input.ask("Exit?(6): ")));
    }

    private String longToDate(long date) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd,MM,yy");
        return sdf.format(new Date(date));
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
    private boolean exit = true;
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


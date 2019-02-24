package ru.job4j.tracker;

import java.text.SimpleDateFormat;
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
    private int range = menuTracker.getActionsLength();
    private final Input input;
    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    Exit exitProgram = new Exit();

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        int[] range = new int[menu.getActionsLength()];
        menu.fillActions();
        for (int i = 0; i < menu.getActionsLength(); i++) {
            range[i] = i;
        }
        do {
            menu.show();
            menu.select(input.ask("select:", range));
        } while (!"y".equals(this.input.ask("Exit?(y): ")));
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
class Exit {
    public String key() {
        execute();
        return "y";
    }
    public void execute() {
        System.out.println("The selected menu item 6. Exit. Goodbye!");
    }
}


package ru.job4j.tracker.menu;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;

class Exit implements UserAction {
    @Override
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

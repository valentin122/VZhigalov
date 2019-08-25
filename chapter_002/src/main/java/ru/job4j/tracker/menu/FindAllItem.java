package ru.job4j.tracker.menu;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;

public class FindAllItem implements UserAction {
    @Override
    public int key() {
        return 1;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("----------- Show all items ------------");
        for (Item item : tracker.findAll()) {
            System.out.println(item);
        }
    }

    @Override
    public String info() {
        return "1. Show all items";
    }
}

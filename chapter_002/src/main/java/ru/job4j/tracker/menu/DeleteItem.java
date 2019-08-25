package ru.job4j.tracker.menu;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;

public class DeleteItem implements UserAction {
    @Override
    public int key() {
        return 3;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------- Delete item by id -------------");
        System.out.println("------------- Input id item -------------");
        String id = input.ask("Please, input id item: ");
        if (tracker.delete(id)) {
            System.out.println("------------- Deleted -------------");
        } else {
            System.out.println("------------- Not found -------------");
        }
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "Delete item");
    }
}

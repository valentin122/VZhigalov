package ru.job4j.tracker.menu;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;

import java.util.function.Consumer;

public class DeleteItem implements UserAction {
    private final Consumer<String> output;

    public DeleteItem(Consumer<String> output) {
        this.output = output;
    }

    @Override
    public int key() {
        return 3;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        output.accept("------------- Delete item by id -------------");
        output.accept("------------- Input id item -------------");
        String id = input.ask("Please, input id item: ");
        if (tracker.delete(id)) {
            output.accept("------------- Deleted -------------");
        } else {
            output.accept("------------- Not found -------------");
        }
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "Delete item");
    }
}

package ru.job4j.tracker.menu;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;

import java.util.function.Consumer;

public class UpdateItem implements UserAction {
    private final Consumer<String> output;

    public UpdateItem(Consumer<String> output) {
        this.output = output;
    }

    @Override
    public int key() {
        return 2;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        output.accept("------------- Editing item -------------");
        String id = input.ask("Please input id item : ");
        String name = input.ask("Please input new item's name: ");
        String desc = input.ask("Please input new item's description: ");
        Item item = new Item(name, desc);
        if (tracker.replace(id, item)) {
            output.accept(" ------------- Item replace -------------");
        } else {
            output.accept("------------- Item not found -------------");
        }
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "UpdateItem");
    }
}

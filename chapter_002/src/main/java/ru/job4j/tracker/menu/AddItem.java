package ru.job4j.tracker.menu;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;

import java.util.function.Consumer;

public class AddItem implements UserAction {
    private final Consumer<String> output;

    public AddItem(Consumer<String> output) {
        this.output = output;
    }

    @Override
    public int key() {
        return 0;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        output.accept("------------ Adding new item --------------");
        String name = input.ask("Please, provide item name:");
        String desc = input.ask("Please, provide item description:");
        Item item = new Item(name, desc);
        tracker.add(item);
        output.accept("------------ New Item with Id : " + item.getId());
        output.accept("------------ New Item with Name : " + item.getName());
        output.accept("------------ New Item with Description : " + item.getDesc());
    }

    @Override
    public String info() {
        return "0. Add new Item.";
    }
}

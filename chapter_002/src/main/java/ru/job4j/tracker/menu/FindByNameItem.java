package ru.job4j.tracker.menu;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;

import java.util.ArrayList;
import java.util.function.Consumer;

public class FindByNameItem implements UserAction {
    private final Consumer<String> output;

    public FindByNameItem(Consumer<String> output) {
        this.output = output;
    }

    @Override
    public int key() {
        return 5;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        output.accept("------------ Find item by name ------------");
        String name = input.ask("Please input item's name:");
        ArrayList<Item> foundItems = tracker.findByName(name);
        if (foundItems.size() > 0) {
            for (Item element : foundItems) {
                output.accept("------------ Found item:" + element);
            }
        } else {
            output.accept("------------ Not found with name " + name);
        }
    }

    @Override
    public String info() {
        return "5. Find by name";
    }
}

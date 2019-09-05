package ru.job4j.tracker.menu;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;

import java.util.function.Consumer;

public class FindById implements UserAction {
    private final Consumer<String> output;

    public FindById(Consumer<String> output) {
        this.output = output;
    }

    @Override
    public int key() {
        return 4;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Enter Item id to find : ");
        Item foundItem = tracker.findById(id);
        if (foundItem != null) {
            output.accept("Item founded by id: " + foundItem);
        } else {
            output.accept("Id not found!");
        }
    }

    @Override
    public String info() {
        return "4. Find item by id : ";
    }
}

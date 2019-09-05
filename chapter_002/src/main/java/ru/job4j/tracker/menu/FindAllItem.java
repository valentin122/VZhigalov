package ru.job4j.tracker.menu;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;

import java.util.function.Consumer;

public class FindAllItem implements UserAction {
    private final Consumer<String> output;

    public FindAllItem(Consumer<String> output) {
        this.output = output;
    }

    @Override
    public int key() {
        return 1;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        output.accept("----------- Show all items ------------");
        for (Item item : tracker.findAll()) {
            output.accept(String.valueOf(item));
        }
    }

    @Override
    public String info() {
        return "1. Show all items";
    }
}

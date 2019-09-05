package ru.job4j.tracker.menu;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;

import java.util.function.Consumer;

class Exit implements UserAction {
    private final Consumer<String> output;

    Exit(Consumer<String> output) {
        this.output = output;
    }

    @Override
    public int key() {
        return 6;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        output.accept("Selected exit. Goodbye!");
    }

    @Override
    public String info() {
        return "6. Exit";
    }
}

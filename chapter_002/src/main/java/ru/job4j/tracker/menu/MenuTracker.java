package ru.job4j.tracker.menu;

import ru.job4j.tracker.*;
import ru.job4j.tracker.input.Input;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    List<UserAction> actions = new ArrayList<>();
    private final Consumer<String> output;



    public MenuTracker(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    public void fillActions() {
        this.actions.add(new AddItem(output));
        this.actions.add(new FindAllItem(output));
        this.actions.add(new UpdateItem(output));
        this.actions.add(new DeleteItem(output));
        this.actions.add(new FindById(output));
        this.actions.add(new FindByNameItem(output));
        this.actions.add(new Exit(output));
    }

    public void show() {
        for (UserAction action : this.actions) {
            output.accept(action.info());
        }
    }

    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    public int getActionsLength() {
        return actions.size();
    }
}


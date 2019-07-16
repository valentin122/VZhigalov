package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    List<UserAction> actions = new ArrayList<>();



    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public MenuTracker() {
    }

    public void fillActions() {
        this.actions.add(new AddItem());
        this.actions.add(new FindAllItem());
        this.actions.add(new UpdateItem());
        this.actions.add(new DeleteItem());
        this.actions.add(new FindById());
        this.actions.add(new FindByNameItem());
        this.actions.add(new Exit());
    }

    public void show() {
        for (UserAction action : this.actions) {
            System.out.println(action.info());
        }
    }

    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    public int getActionsLength() {
        return actions.size();
    }
}


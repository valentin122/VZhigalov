package ru.job4j.tracker;

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    public UserAction[] actions = new UserAction[6];

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public MenuTracker() {

    }

    public void fillActions() {
        this.actions[0] = new AddItem();
        this.actions[1] = new FindAllItem();
        this.actions[2] = new UpdateItem();
        this.actions[3] = new DeleteItem();
        this.actions[4] = new FindById();
        this.actions[5] = new FindByNameItem();
    }

    public void show() {
        for (UserAction action : this.actions) {
            System.out.println(action.info());
        }
    }

    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    public int getActionsLength() {
        return actions.length;
    }
}


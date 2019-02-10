package ru.job4j.tracker;

public class UpdateItem implements UserAction {
    @Override
    public int key() {
        return 2;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------- Editing item -------------");
        String id = input.ask("Please input id item : ");
        String name = input.ask("Please input new item's name: ");
        String desc = input.ask("Please input new item's description: ");
        Item item = new Item(name, desc);
        if (tracker.replace(id, item)) {
            System.out.println(" ------------- Item replace -------------");
        } else {
            System.out.println("------------- Item not found -------------");
        }
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "UpdateItem");
    }
}

package ru.job4j.tracker;

public class FindByNameItem implements UserAction {
    @Override
    public int key() {
        return 5;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Find item by name ------------");
        String name = input.ask("Please input item's name:");
        Item[] foundItems = tracker.findByName(name);
        if (foundItems.length > 0) {
            for (Item element : foundItems) {
                System.out.println("------------ Found item:" + element);
            }
        } else {
            System.out.println("------------ Not found with name " + name);
        }
    }

    @Override
    public String info() {
        return "5. Find by name";
    }
}

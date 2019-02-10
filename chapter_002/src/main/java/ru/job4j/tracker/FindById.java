package ru.job4j.tracker;

public class FindById implements UserAction {
    @Override
    public int key() {
        return 4;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Enter Item id to find : ");
        Item foundItem = tracker.findById(id);
        if (foundItem != null) {
            System.out.println("Item founded by id: ");
        } else {
            System.out.println("Id not found!");
        }
    }

    @Override
    public String info() {
        return "4. Find item by id : ";
    }
}

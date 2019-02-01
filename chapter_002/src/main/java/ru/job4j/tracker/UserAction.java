package ru.job4j.tracker;

public interface UserAction {
    int key();
    void execute(Item item, Tracker tracker);
    String info();
}

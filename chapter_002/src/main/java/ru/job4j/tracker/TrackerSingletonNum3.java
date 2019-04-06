package ru.job4j.tracker;


import ru.job4j.tracker.Item;

public class TrackerSingletonNum3 {
    private static final TrackerSingletonNum3 INSTANCE = new TrackerSingletonNum3();

    private TrackerSingletonNum3() {
    }

    public static TrackerSingletonNum3 getInstance() {
        return INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }
}
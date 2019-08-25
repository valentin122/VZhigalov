package ru.job4j.tracker;

public class TrackerSingletonNum2 {
    private static TrackerSingletonNum2 instance;

    private TrackerSingletonNum2() {
    }

    public static TrackerSingletonNum2 getInstance() {
        if (instance == null) {
            instance = new TrackerSingletonNum2();
        }
        return instance;
    }

    public Item add(Item model) {
        return model;
    }
}
package ru.job4j.tracker;

public enum TrackerSingletonNum1 {
    INSTANCE;

    public Item add(Item model) {
        return model;
    }
}
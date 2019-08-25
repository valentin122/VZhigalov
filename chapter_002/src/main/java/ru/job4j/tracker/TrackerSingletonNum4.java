package ru.job4j.tracker;

public class TrackerSingletonNum4 {
    private TrackerSingletonNum4() {
    }

    public static TrackerSingletonNum4 getInstance() {
        return Holder.INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }

    private static final class Holder {
        private static final TrackerSingletonNum4 INSTANCE = new TrackerSingletonNum4();
    }

    public static void main(String[] args) {
        TrackerSingletonNum4 tracker = TrackerSingletonNum4.getInstance();
    }
}

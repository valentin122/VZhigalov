package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        int countIndexInsert = tasks.size();
        for (int i = 0; i < countIndexInsert; i++) {
            if (task.getPriority() <= tasks.get(i).getPriority()) {
                countIndexInsert = i;
                break;
            }
        }
        tasks.add(countIndexInsert, task);
    }

    public Task take() {
        return this.tasks.poll();
    }
}
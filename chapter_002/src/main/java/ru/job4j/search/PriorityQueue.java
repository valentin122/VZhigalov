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
        if (tasks.size() == 0) {
            tasks.add(task);
        } else {
            for (Task taskTemp: tasks) {
                int i = 0;
                if (task.getPriority() < taskTemp.getPriority()) {
                    tasks.add(i, task);
                    break;
                }
                i++;
            }
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}
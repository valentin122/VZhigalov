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
            int size = tasks.size();
            Task taskTemp;
            for (int i = 0; i < size; i++) {
                taskTemp = tasks.get(i);
                if (task.getPriority() <= taskTemp.getPriority()) {
                    tasks.add(i, task);
                    break;
                } else if(i == (size - 1)) {
                    tasks.add(task);
                }
            }

        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}
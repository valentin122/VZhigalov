package ru.job4j.search;

import java.util.LinkedList;
import java.util.ListIterator;

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
        ListIterator<Task> listIterator = tasks.listIterator();
        while (listIterator.hasNext()) {
            if (task.getPriority() <= listIterator.next().getPriority()) {
                countIndexInsert = listIterator.previousIndex();
                break;
            }
        }
        tasks.add(countIndexInsert, task);
    }

    public Task take() {
        return this.tasks.poll();
    }
}
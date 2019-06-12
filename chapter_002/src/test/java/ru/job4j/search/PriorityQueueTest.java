package ru.job4j.search;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PriorityQueueTest {
    @Test
    public void whenHigherPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 4));
        queue.put(new Task("middle", 10));
        queue.put(new Task("middleHard", 8));
        queue.put(new Task("middleHard2", 20));
        queue.put(new Task("middleHard3", 2));
        Task result = queue.take();
        assertThat(result.getDesc(), is("middleHard3"));
    }
    @Test
    public void whenSecondPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("middleHard", 8));
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 4));
        Task result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }
}
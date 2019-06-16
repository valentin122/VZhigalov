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
        queue.put(new Task("m", 10));
        queue.put(new Task("mi", 8));
        queue.put(new Task("mid2", 20));
        queue.put(new Task("middleHard3", 2));
        Task result = queue.take();
        assertThat(result.getDesc(), is("middleHard3"));
        Task result2 = queue.take();
        assertThat(result2.getDesc(), is("urgent"));
        Task result3 = queue.take();
        assertThat(result3.getDesc(), is("low"));
    }
    @Test
    public void whenSecondPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("middleHard", 8));
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 4));
        Task first = queue.take();
        assertThat(first.getDesc(), is("urgent"));
    }
}
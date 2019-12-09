package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleQueueTest {
    SimpleQueue<Integer> simpleQueue = new SimpleQueue<>();

    @Before
    public void setUp() {
        simpleQueue.push(1);
        simpleQueue.push(2);
        simpleQueue.push(3);
    }

    @Test
    public void poll() {
        assertThat(simpleQueue.poll(), is(1));
    }

    @Test
    public void push() {
        simpleQueue.push(4);
        simpleQueue.poll();
        simpleQueue.poll();
        simpleQueue.poll();
        assertThat(simpleQueue.poll(), is(4));
    }
}
package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleStackTest {
    SimpleStack<Integer> simpleStack = new SimpleStack<Integer>();

    @Before
    public void setUp() {
        simpleStack.push(1);
        simpleStack.push(2);
        simpleStack.push(3);
        simpleStack.push(4);
    }

    @Test
    public void push() {
        assertThat(simpleStack.poll(), is(4));
    }

    @Test
    public void poll() {
        assertThat(simpleStack.poll(), is(4));
        assertThat(simpleStack.poll(), is(3));
        assertThat(simpleStack.poll(), is(2));
        assertThat(simpleStack.poll(), is(1));
    }
}
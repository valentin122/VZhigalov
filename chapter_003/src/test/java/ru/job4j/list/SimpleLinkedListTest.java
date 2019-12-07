package ru.job4j.list;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.Before;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleLinkedListTest {
    private SimpleLinkedList<Integer> list;

    @Before
    public void beforeTest() {
        list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void add() {
        assertThat(list.get(0), is(3));
    }

    @Test
    public void delete() {
        assertThat(list.delete(), is(3));
        assertThat(list.delete(), is(2));
        assertThat(list.delete(), is(1));
        assertThat(list.getSize(), is(0));
    }

    @Test
    public void get() {
        assertThat(list.get(2), is(1));
    }

    @Test
    public void getSize() {
        assertThat(list.getSize(), is(3));
    }

    @Test
    public void whenAddOverLimitElements() {
        for (int i = 0; i < 50; i++) {
            list.add(i);
        }
        assertThat(list.getSize(), is(53));
    }

    @Test
    public void whenIterateThanOk() {
        list.add(3);
        list.add(4);
        Iterator<Integer> it = list.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        MatcherAssert.assertThat(it.hasNext(), is(false));
    }


}
package ru.job4j.map;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleHashMapTest {
    SimpleHashMap<Integer, String> map = new SimpleHashMap<>();

    @Before
    public void setUp() {
        map.insert(1, "1");
    }

    @Test
    public void insert() {
        map.insert(2, "2");
        assertThat(map.get(2).equals("2"), is(true));
    }

    @Test
    public void get() {
        assertThat(map.get(1).equals("1"), is(true));
    }

    @Test
    public void delete() {
        assertThat(map.delete(1), is(true));
        assertThat(map.getSize(), is(0));
    }

    @Test
    public void resizeTest() {
        assertThat(map.getSize(), is(1));
        map.insert(2, "2");
        map.insert(3, "3");
        map.insert(4, "4");
        map.insert(5, "5");
        map.insert(6, "6");
        map.insert(7, "7");
        map.insert(8, "8");
        map.insert(9, "9");
        map.insert(10, "10");
        assertThat(map.getSize(), is(10));
    }

    @Test
    public void iteratorTest() {
        map.insert(2, "2");
        map.insert(3, "3");
        map.insert(4, "4");
        map.insert(5, "5");

        var it = map.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("1"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("2"));
        assertThat(it.next(), is("3"));
        assertThat(it.next(), is("4"));
        assertThat(it.next(), is("5"));
        assertThat(it.hasNext(), is(false));
    }
}
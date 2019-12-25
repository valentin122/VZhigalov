package ru.job4j.map;

import org.junit.Before;
import org.junit.Test;

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

}
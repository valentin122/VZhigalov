package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class SimpleArrayTest {
    SimpleArray<Integer> simpleArray = new SimpleArray(10);

    @Before
    public void setUp() {
        for (int i = 0; i < 8; i++) {
            simpleArray.add(i);
        }
    }

    @Test
    public void add() {
        simpleArray.add(1);
        assertThat(simpleArray.get(8), is(1));
    }

    @Test
    public void set() {
        simpleArray.set(1, 11);
        assertThat(simpleArray.get(1), is(11));
    }

    @Test
    public void remove() {
        System.out.println(simpleArray.toString());
        simpleArray.remove(0);
        simpleArray.remove(0);
        assertThat(simpleArray.get(0), is(2));
    }

    @Test
    public void iterator() {
        Iterator<Integer> it = simpleArray.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(0));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(6));
        assertThat(it.next(), is(7));
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void whenToStringThanResult() {
        String expected = "SimpleArray{objects=[0, 1, 2, 3, 4, 5, 6, 7, null, null], index=8, size=8}";
        String actual = simpleArray.toString();
        assertThat(actual.equals(expected), is(true));
    }

    @Test
    public void whenAddOverLimitElements() {
        assertThat(simpleArray.get(8), is(nullValue()));
        for (int i = 0; i < 50; i++) {
            simpleArray.add(i);
        }
        assertThat(simpleArray.get(57), is(49));
    }
}
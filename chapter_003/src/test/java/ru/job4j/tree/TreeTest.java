package ru.job4j.tree;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TreeTest {
    Tree<Integer> tree = new Tree<>(1);

    @Before
    public void setUp() {
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
    }

    @Test
    public void when6ElFindLastThen6() {
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }

    @Test
    public void whenIterateTreeThenGetAllNodes() {
        Iterator<Node> it = tree.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next().getValue(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next().getValue(), is(2));
        assertThat(it.next().getValue(), is(3));
        assertThat(it.next().getValue(), is(4));
        assertThat(it.next().getValue(), is(5));
        assertThat(it.next().getValue(), is(6));
        assertThat(it.hasNext(), is(false));

    }

    @Test
    public void whenTreeNotBinaryThanFalse() {
        assertThat(tree.isBinary(), is(false));
    }

    @Test
    public void whenTreeIsBinaryThanTrue() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(3, 5);
        tree.add(5, 6);
        assertThat(tree.isBinary(), is(true));
    }

}
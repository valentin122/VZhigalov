package ru.job4j.tracker;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class StartUITest {
    private Tracker tracker = new Tracker();
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void init() {

        tracker.add(new Item("test1", "desc1"));
        tracker.add(new Item("test2", "desc2"));
        tracker.add(new Item("test3", "desc3"));
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(new PrintStream(stdout));
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        //Tracker tracker = new Tracker();
        String[] action1 = {"0", "test name", "desc", "y"};
        new StartUI(new StubInput(action1), tracker).init();
        assertThat(tracker.findAll()[3].getName(), is("test name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {

        String[] action2 = {"2", tracker.findAll()[0].getId(), "changed name", "changed description", "y"};
        new StartUI(new StubInput(action2), tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("changed name"));
    }
    @Test
    public void whenDeleteThenTrackerEmpty() {
        String[] action3 = {"3", tracker.findAll()[0].getId(), "y"};
        new StartUI(new StubInput(action3), tracker).init();
        assertThat(tracker.findAll().length, is(2));
    }
    @Test
    public void whenShowAll() {
        String[] action = {"1", "y"};
        StringBuilder expected = new StringBuilder();
        for (Item item : tracker.findAll()) {
            expected.append(
                    String.format(item.getId(), item.getName(), item.getDesc()));
        }
        new StartUI(new StubInput(action), tracker).init();
        assertThat(new String(out.toByteArray()).contains(expected), is(true));
    }
    @Test
    public void whenFindByIdThenShow() {
        String id = tracker.findAll()[0].getId();
        String[] action = {"4", id, "y"};
        Item item = tracker.findById(id);
        String expected = String.format(item.getId(), item.getName(), item.getDesc());

     /*   for (item : tracker.findByName("test name")) {
            expected.append(
                    String.format("%-20s%-11s%-25s%n", item.getId(), item.getName(), item.getDesc()));
        }*/
        new StartUI(new StubInput(action), tracker).init();
        assertThat(out.toString().contains(expected), is(true));
    }
    @Test
    public void whenFindByNameThenShow() {
        String[] action = {"5", "test2", "y"};
        StringBuilder expected = new StringBuilder();
        for (Item item : tracker.findByName("test2")) {
            expected.append(
                    String.format(item.getId(), item.getName(), item.getDesc()));
        }
        new StartUI(new StubInput(action), tracker).init();
        assertThat(out.toString().contains(expected), is(true));
    }
}

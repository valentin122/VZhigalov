package ru.job4j.tracker;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

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
        ArrayList<String> action1 = new ArrayList<>();
        String[] add = {"0", "test name", "desc", "y"};
        action1.toArray(add);
        new StartUI(new StubInput(action1), tracker).init();
        assertThat(tracker.findAll().get(3).getName(), is("test name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        ArrayList<String> action2 = new ArrayList<>();
        String[] add2 = {"2", tracker.findAll().get(0).getId(), "changed name", "changed description", "y"};
        action2.toArray(add2);
        new StartUI(new StubInput(action2), tracker).init();
        assertThat(tracker.findAll().get(0).getName(), is("changed name"));
    }
    @Test
    public void whenDeleteThenTrackerEmpty() {
        ArrayList<String> action3 = new ArrayList<>();
        String[] add3 = {"3", tracker.findAll().get(0).getId(), "y"};
        action3.toArray(add3);
        new StartUI(new StubInput(action3), tracker).init();
        assertThat(tracker.findAll().size(), is(2));
    }
    @Test
    public void whenShowAll() {
        ArrayList<String> action = new ArrayList<>();
        String[] add = {"1", "y"};
        action.toArray(add);
        StringBuilder expected = new StringBuilder();
        expected.append("0. Add new Item.")
                .append(System.lineSeparator() + "1. Show all items")
                .append(System.lineSeparator() + "2. UpdateItem")
                .append(System.lineSeparator() + "3. Delete item")
                .append(System.lineSeparator() + "4. Find item by id : ")
                .append(System.lineSeparator() + "5. Find by name")
                .append(System.lineSeparator() + "----------- Show all items ------------")
                .append(System.lineSeparator());
        for (Item item : tracker.findAll()) {
            expected.append(
                    String.format("%-20s%-11s%-25s%n", item.getId(), item.getName(), item.getDesc()));
        }
        new StartUI(new StubInput(action), tracker).init();

        assertThat(new String(out.toByteArray()), is(expected.toString()));
    }
    @Test
    public void whenFindByIdThenShow() {
        ArrayList<String> action = new ArrayList<>();
        String id = tracker.findAll().get(0).getId();
        String[] add = {"4", id, "y"};
        action.toArray(add);
        Item item = tracker.findById(id);
        String expected = String.format(item.getId(), item.getName(), item.getDesc());
        new StartUI(new StubInput(action), tracker).init();
        assertThat(out.toString().contains(expected), is(true));
    }
    @Test
    public void whenFindByNameThenShow() {
        ArrayList<String> action = new ArrayList<>();
        String[] add = {"5", "test2", "y"};
        action.toArray(add);
        StringBuilder expected = new StringBuilder();
        for (Item item : tracker.findByName("test2")) {
            expected.append(
                    String.format(item.getId(), item.getName(), item.getDesc()));
        }
        new StartUI(new StubInput(action), tracker).init();
        assertThat(out.toString().contains(expected), is(true));
    }
}

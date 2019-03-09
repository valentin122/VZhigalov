package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;



public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1234L);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public  void whenDeleteNameThenNull() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription", 123L);
        Item item2 = new Item("test2", "testDescription", 123L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.delete(item1.getId());
        assertThat(tracker.findById(item1.getId()), is(nullValue()));
    }
    @Test
    public void whenFindByNameThenName() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription", 123L);
        Item item2 = new Item("test2", "testDescription", 123L);
        tracker.add(item1);
        tracker.add(item2);
        Item[] expected = {tracker.findAll()[1]};
        Item[] result = tracker.findByName("test2");
        assertThat(result, is(expected));
    }
}

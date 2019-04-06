package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerSingletonNum2Test {
    @Test
    public void whenCreateNewTrackerThenTrackerEqualTracker2() {
        TrackerSingletonNum2 tracker = TrackerSingletonNum2.getInstance();
        TrackerSingletonNum2 trackerTwo = TrackerSingletonNum2.getInstance();
        assertThat(tracker == trackerTwo, is(true));
    }
}

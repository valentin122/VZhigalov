package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerSingletonNum4Test {
    @Test
    public void whenCreateNewTrackerThenTrackerEqualTracker3() {
        TrackerSingletonNum4 tracker = TrackerSingletonNum4.getInstance();
        TrackerSingletonNum4 trackerTwo = TrackerSingletonNum4.getInstance();
        assertThat(tracker == trackerTwo, is(true));
    }
}

package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerSingletonNum1Test {
    @Test
    public void whenCreateNewTrackerThenTrackerEqualTracker2() {
        TrackerSingletonNum1 tracker = TrackerSingletonNum1.INSTANCE;
        TrackerSingletonNum1 trackerTwo = TrackerSingletonNum1.INSTANCE;
        assertThat(tracker == trackerTwo, is(true));
    }
}

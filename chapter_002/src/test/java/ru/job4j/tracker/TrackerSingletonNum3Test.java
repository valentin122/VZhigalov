package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerSingletonNum3Test {
    @Test
    public void whenCreateNewTrackerThenTrackerEqualTracker3() {
        TrackerSingletonNum3 tracker = TrackerSingletonNum3.getInstance();
        TrackerSingletonNum3 trackerTwo = TrackerSingletonNum3.getInstance();
        assertThat(tracker == trackerTwo, is(true));
    }
}

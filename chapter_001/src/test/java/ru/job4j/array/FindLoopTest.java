/**
 * SquareTest
 *
 * @author Valentin Zhigalov (VAL1915@ya.ru)
 * @version 0.1
 * @since 08.10.18
 */

package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FindLoopTest {

    @Test
    public void whenArrayHasLengh5Then0() {
        FindLoop find = new FindLoop();
        int[] data = new int[]{5, 10, 3};
        int value = 5;
        int result = find.indexOf(data, value);
        int expect = 0;
        assertThat(result, is(expect));
    }

    @Test
    public void whenArrayHasLengh11Then1() {
        FindLoop find = new FindLoop();
        int[] data = new int[]{15, 11, 123};
        int value = 123;
        int result = find.indexOf(data, value);
        int expect = 2;
        assertThat(result, is(expect));
    }

    @Test
    public void whenArrayHasLengh5ThenMinus1() {
        FindLoop find = new FindLoop();
        int[] data = new int[]{15, 110, 123};
        int value = 5;
        int result = find.indexOf(data, value);
        int expect = -1;
        assertThat(result, is(expect));
    }
}
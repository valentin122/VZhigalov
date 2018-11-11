/**
 * SortTwoArrTest {
 *
 * @author Valentin Zhigalov (VAL1915@ya.ru)
 * @version 0.1
 * @since 11.11.18
 */


package ru.job4j.array;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortTwoArrTest {
    @Test
    public void whenFirstArrayAndSecondArrayMergredThenSortedArray() {
        SortTwoArr turner = new SortTwoArr();
        int[] arrayOne = new int[]{0, 2, 5, 6};
        int[] arrayTwo = new int[]{1, 2, 3, 4};
        int[] resultArray = turner.merge(arrayOne, arrayTwo);
        int[] expectArray = new int[]{0, 1, 2, 2, 3, 4, 5, 6};
        assertThat(resultArray, Matchers.is(expectArray));

    }
    @Test
    public void whenFirstArrayAndSecondArrayMergredThenSortedArrayTest2() {
        SortTwoArr turner = new SortTwoArr();
        int[] arrayOne = new int[]{0, 2, 5, 6, 7, 9, 11};
        int[] arrayTwo = new int[]{1, 2, 3, 4, 8};
        int[] resultArray = turner.merge(arrayOne, arrayTwo);
        int[] expectArray = new int[]{0, 1, 2, 2, 3, 4, 5, 6, 7, 8, 9, 11};
        assertThat(resultArray, Matchers.is(expectArray));

    }

}
/**
 * TurnTest
 *
 * @author Valentin Zhigalov (VAL1915@ya.ru)
 * @version 0.1
 * @since 10.10.18
 */

package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TurnTest {
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        Turn turner = new Turn();
        int[] input = new int[]{4, 1, 6, 2};
        int[] result = turner.turn(input);
        int[] expect = new int[]{2, 6, 1, 4};
        assertThat(result, is(expect));
    }

    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
        //напишите здесь тест, проверяющий переворот массива с нечётным числом элементов, например {1, 2, 3, 4, 5}.
        Turn turner = new Turn();
        int[] input = new int[]{1, 2, 3, 4, 5};
        int[] resultArray = turner.turn(input);
        int[] expectArray = new int[]{5, 4, 3, 2, 1};
        assertThat(resultArray, is(expectArray));
    }
}
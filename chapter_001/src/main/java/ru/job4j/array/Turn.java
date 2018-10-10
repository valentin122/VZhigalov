/**
 * Turn
 *
 * @author Valentin Zhigalov (VAL1915@ya.ru)
 * @version 0.1
 * @since 10.10.18
 */

package ru.job4j.array;

public class Turn {
    public int[] turn(int[] array) {
        for (int i = 0; i < (array.length / 2); i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;

        }
        return array;
    }
}
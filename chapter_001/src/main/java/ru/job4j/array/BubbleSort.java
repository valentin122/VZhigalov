/**
 * BubbleSort
 *
 * @author Valentin Zhigalov (VAL1915@ya.ru)
 * @version 0.1
 * @since 11.10.18
 */

package ru.job4j.array;

public class BubbleSort {
    /**
     * method sort array
     *
     * @param array any int array
     * @return sorted array
     */
    public int[] sort(int[] array) {
        for (int index = array.length - 1; index > 0; index--) {
            for (int i = 0; i < index; i++) {
                if (array[i] > array[i + 1]) {
                    int tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                }
            }

        }
        return array;
    }
}
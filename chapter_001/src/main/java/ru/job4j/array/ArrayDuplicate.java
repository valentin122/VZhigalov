/**
 * ArrayDuplicate
 *
 * @author Valentin Zhigalov (VAL1915@ya.ru)
 * @version 0.1
 * @since 20.10.18
 */

package ru.job4j.array;

import java.util.Arrays;

public class ArrayDuplicate {
    /**
     * Метод remove. Возвращает массив с уникальными значениями.
     *
     * @param array входящий массив.
     * @return массив с уникальными значениями, образанный по количеству элементов массива.
     */
    public String[] remove(String[] array) {
        int line = array.length;
        for (int i = 0; i < line; i++) {
            for (int j = i + 1; j < line; j++) {
                if (array[i].equals(array[j])) {
                    array[j] = array[line - j];
                    line--;
                    j--;
                }
            }

        }
        return Arrays.copyOf(array, line);
    }


}
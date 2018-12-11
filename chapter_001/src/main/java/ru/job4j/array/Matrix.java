/**
 * Matrix
 *
 * @author Valentin Zhigalov (VAL1915@ya.ru)
 * @version 0.1
 * @since 16.10.18
 */

package ru.job4j.array;

public class Matrix {
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];

        for (int index = 0; index < size; index++) {
            for (int i = 0; i < size; i++) {
                table[index][i] = (index + 1) * (i + 1);
            }
        }
        return table;
    }
}

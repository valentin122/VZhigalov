/**
 * Square
 *
 * @author Valentin Zhigalov (VAL1915@ya.ru)
 * @version 0.1
 * @since 10.10.18
 */

package ru.job4j.array;

public class Square {
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 1; i <= bound; i++) { // заполнить массив через цикл элементами от 1 до bound возведенными в квадрат
            rst[i - 1] = i * i;
        }

        return rst;
    }
}
/**
 *Square
 *
 *@author Valentin Zhigalov (VAL1915@ya.ru)
 *@since 08.10.18
 *@version 0.1
 */

package ru.job4j.array;

public class Square {
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 1; i != (bound + 1); i++) { // заполнить массив через цикл элементами от 1 до bound возведенными в квадрат
            rst[i - 1] = i * i;
        }

        return rst;
    }
}
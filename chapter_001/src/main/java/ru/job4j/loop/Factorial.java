/**
 *Factorial
 *
 *@author Valentin Zhigalov (VAL1915@ya.ru)
 *@since 23.06.18
 *@version 0.1
 */

package ru.job4j.loop;

public class Factorial {
    /**
     * Вычисляет факториал числа n.
     * @param n - число, чей факториал ищем.
     * @return факториал n.
     */

    int n;
    public int calc(int n) {
        int factorialN = 1;
        if (n > 0) {
            for (int i = 1; i <= n; i++) {
                factorialN *= i;
            }
        }
    return factorialN;
    }





}
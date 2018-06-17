/**
 *Max
 *
 *@author Valentin Zhigalov (VAL1915@ya.ru)
 *@since 17.06.18
 *@version 0.1
 */

package ru.job4j.max;

public class Max {

    /**
     * "Находит" большее из чисел.
     * @param "ввод чисел."
     * @return бОльшее из чисел.
     */
    public int max(int first, int second) {
        int maxim = (first > second) ? first : second;
        return maxim;
    }




}
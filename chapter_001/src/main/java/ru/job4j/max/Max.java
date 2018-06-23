/**
 *Max
 *
 *@author Valentin Zhigalov (VAL1915@ya.ru)
 *@since 23.06.18
 *@version 0.3
 */

package ru.job4j.max;

public class Max {

    /**
     * "Находит" большее из чисел.
     * @param "ввод чисел."
     * @return бОльшее из чисел.
     */
    public int max(int first, int second) {
        return (first > second) ? first : second;
    }

    public int max(int first, int second, int third) {
        int temp = this.max(first, second);
            int tempotery = this.max(temp, third);
        return tempotery;
    }


}
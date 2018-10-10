/**
 * FindLoop
 *
 * @author Valentin Zhigalov (VAL1915@ya.ru)
 * @version 0.1
 * @since 08.10.18
 */

package ru.job4j.array;

public class FindLoop {
    int index = 0;

    public int indexOf(int[] data, int el) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int i = 0; i < data.length; i++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
            index++;
        }
        return rst;
    }
}
/**
 *Counter
 *
 *@author Valentin Zhigalov (VAL1915@ya.ru)
 *@since 23.06.18
 *@version 0.1
 */

package ru.job4j.loop;

public class Counter {

    int summ = 0;

    public int add(int start, int finish) {

        for (int index = start; index <= finish; index++) {
            if (index % 2 == 0) {
                summ += index;
            }
        }
    return summ;
    }
}


package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *Counter
 *
 *@author Valentin Zhigalov (VAL1915@ya.ru)
 *@since 28.06.18
 *@version 0.1
 */

public class CounterTest {
    @Test
    public void whenSumEvenNumbersFromOneToTenThenThirty() {
        Counter counter = new Counter();
        int start = 1;
        int finish = 10; //напишите здесь тест, проверяющий,
        int result = counter.add(start, finish);
        assertThat(result, is(30)); // что сумма чётных чисел от 1 до 10 при вызове метода counter.add будет равна 30.
    }
}
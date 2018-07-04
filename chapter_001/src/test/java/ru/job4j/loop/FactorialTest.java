/**
 *FactorialTest
 *
 *@author Valentin Zhigalov (VAL1915@ya.ru)
 *@since 04.07.18
 *@version 0.1
 */

package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FactorialTest {
    @Test
    public void whenCalculateFactorialForFiveThenOneHundreedTwenty() {
        Factorial factorial = new Factorial();
        int n = 5;
        int result = factorial.calc(n);
        assertThat(result, is(120));
        //напишите здесь тест, проверяющий, что факториал для числа 5 равен 120.
    }

    @Test
    public void whenCalculateFactorialForZeroThenOne() {
        Factorial factorial = new Factorial();
        int n = 0;
        int result = factorial.calc(n);
        assertThat(result, is(1));
        //напишите здесь тест, проверяющий, что факториал для числа 0 равен 1.
    }
}
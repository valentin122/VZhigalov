/**
 * ArrayDuplicateTest
 *
 * @author Valentin Zhigalov (VAL1915@ya.ru)
 * @version 0.1
 * @since 16.10.18
 */

package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        //напишите здесь тест, проверяющий удаление дубликатов строк из массива строк.
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] inputArray = {"Мир", "Труд", "Мир", "Труд", "Труд", "Мир", "Май", "Мир"};
        String[] expectArray = {"Мир", "Труд", "Май"};
        String[] resultArray = arrayDuplicate.remove(inputArray);
        assertThat(resultArray, is(expectArray));
    }
}
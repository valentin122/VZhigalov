package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StreamConvertMatrixToListTest {

    @Test
    public void whenMatrix3x3ThenList() {
        Integer[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        StreamConvertMatrixToList streamConvertMatrixToList = new StreamConvertMatrixToList();
        List<Integer> result = streamConvertMatrixToList.convertMatrixToList(matrix);
        assertThat(result.size(), is(9));
    }
}

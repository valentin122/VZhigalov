package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FunctionInDiapazonTest {
    FunctionInDiapazon function = new FunctionInDiapazon();

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D, 17D);
        assertThat(result, is(expected));
    }
    @Test
    public void whenQuadraticFrom1To3() {
        List<Double> result = function.quadratic(1, 3);
        List<Double> expected = Arrays.asList(1d, 4d, 9d);
        assertThat(result, is(expected));
    }
    @Test
    public void whenLogFrom1To3() {
        List<Double> result = function.log(1, 3);
        List<Double> expected = Arrays.asList(Math.log(1d), Math.log(2d), Math.log(3d));
        assertThat(result, is(expected));
    }
}

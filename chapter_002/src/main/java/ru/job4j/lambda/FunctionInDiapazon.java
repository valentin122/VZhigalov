package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionInDiapazon {
    List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> result = new ArrayList<>();
        for (int index = start; index <= end; index++) {
            result.add(func.apply((double) index));
        }
        return result;
    }

    public List<Double> quadratic(int start, int end) {
        return diapason(start, end, n -> Math.pow(n, 2));
    }

    public List<Double> log(int start, int end) {
        return diapason(start, end, Math::log);
    }
}

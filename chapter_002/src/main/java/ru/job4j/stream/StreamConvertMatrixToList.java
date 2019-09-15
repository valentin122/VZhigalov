package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamConvertMatrixToList {
    public List<Integer> convertMatrixToList(Integer[][] matrix) {
    List<Integer> result = new ArrayList<>();
    result = Arrays.stream(matrix).flatMap(e -> Arrays.stream(e)).collect(Collectors.toList());
    return result;
    }
}

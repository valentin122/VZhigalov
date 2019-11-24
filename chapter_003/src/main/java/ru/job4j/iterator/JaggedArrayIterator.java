package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class JaggedArrayIterator implements Iterator {

    private final int[][] matrix;
    private int indexCol = 0;
    private int indexRow = 0;

    public JaggedArrayIterator(int[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public boolean hasNext() {
        return indexCol < matrix.length && indexRow < matrix[indexCol].length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int result = matrix[indexCol][indexRow++];
        if (indexRow == matrix[indexCol].length) {
            indexRow = 0;
            indexCol++;
        }
        return result;
    }
}

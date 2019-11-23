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
        int result;
        if (matrix[indexCol][indexRow] == matrix[indexCol][(matrix[indexCol].length - 1)]) {
            result = matrix[indexCol++][indexRow];
            indexRow = 0;
        } else {
            result = matrix[indexCol][indexRow++];
        }
        return result;
    }
}

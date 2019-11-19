package ru.job4j.iterator;

import java.util.Iterator;

public class JaggedArrayIterator implements Iterator {

    private final int[][] matrix;
    private int indexCol = 0;
    private int indexRow = 0;

    public JaggedArrayIterator(int [][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public boolean hasNext() {
        boolean result = true;
        if(indexCol >= matrix.length - 1) {
            if(indexCol >= matrix.length) {
                result = false;
            } else if(indexRow > matrix[matrix.length - 1].length - 1) {
               result = false;
            }
        }
        return result;
    }

    @Override
    public Integer next() {
        int result;
            // текущая ячейка               //последняя ячейка в этой строке
        if(matrix[indexCol][indexRow] == matrix[indexCol][(matrix[indexCol].length - 1)]) {
            result = matrix[indexCol++][indexRow];
            indexRow = 0;
        } else {
            result = matrix[indexCol][indexRow++];
        }
        return result;
    }
}

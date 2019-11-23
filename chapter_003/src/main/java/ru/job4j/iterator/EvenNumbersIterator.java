package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {

    private final int[] ints;
    private int index = 0;

    public EvenNumbersIterator(final int[] ints) {
        this.ints = ints;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        for (int i = index; i < ints.length; i++) {
            if (ints[i] % 2 == 0) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int result = 0;
        for (int i = index; i < ints.length; i++) {
            if (ints[i] % 2 == 0) {
                result = ints[i];
                index = ++i;
                break;
            }
        }
        return result;
    }
}

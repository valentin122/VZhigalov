package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {

    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {

        return new Iterator<Integer>() {

            private Iterator<Integer> current;

            {
                if (it != null && it.hasNext()) {
                    current = it.next();
                }
            }

            @Override
            public boolean hasNext() {
                boolean hasNext = false;
                if (current.hasNext()) {
                    hasNext = current.hasNext();
                } else if (it.hasNext()) {
                    while (it.hasNext()) {
                        current = it.next();
                        hasNext = current.hasNext();
                        if (hasNext) {
                            break;
                        }
                    }
                }
                return hasNext;
            }

            @Override
            public Integer next() {
                if (!current.hasNext()) {
                    if (!it.hasNext()) {
                        throw new NoSuchElementException();
                    } else {
                        current = it.next();
                    }
                }
                return current.next();
            }
        };
    }

    private Iterator<Integer> getIterator(Iterator<Iterator<Integer>> iter) {
        Iterator<Integer> iterator = null;
        if (!iter.hasNext()) {
            throw new NoSuchElementException();
        }
        iterator = iter.next();
        return iterator;
    }
}
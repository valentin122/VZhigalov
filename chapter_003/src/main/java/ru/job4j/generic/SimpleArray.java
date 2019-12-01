package ru.job4j.generic;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {
    Object[] objects;
    int index = 0;
    int size = 0;

    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    public void add(T model) {
        objects[index++] = model;
        size++;
    }

    public void set(int index, T model) {
        objects[index] = model;
    }

    public void remove(int index) {
        for (int i = index; i < size; i++) {
            objects[i] = objects[i + 1];
        }
        size--;
    }

    public Object get(int index) {
        return objects[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int indexIterator = 0;

            @Override
            public boolean hasNext() {
                return indexIterator < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) objects[indexIterator++];
            }
        };
    }

    @Override
    public String toString() {
        return "SimpleArray{"
                + "objects=" + Arrays.toString(objects)
                + ", index=" + index
                + ", size=" + size
                + '}';
    }
}

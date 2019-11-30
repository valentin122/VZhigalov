package ru.job4j.generic;

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
        objects[index] = model;
        size++;
    }

    public void set(int index, T model) {
        objects[index] = model;
    }

    public void remove(int index) {
        Object[] objects2 = new Object[objects.length];
        System.arraycopy(objects, 0, objects2, 0, (index));
        System.arraycopy(objects, ++index, objects2, index, (size - index - 1));
        objects = objects2;
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
}

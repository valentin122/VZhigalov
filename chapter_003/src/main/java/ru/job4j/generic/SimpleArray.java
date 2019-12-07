package ru.job4j.generic;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] objects;
    private int index = 0;
    private int size = 0;


    public SimpleArray(int volume) {
        this.objects = new Object[volume];
    }

    public void add(T model) {
        if (size == objects.length) {
            enlargement();
        }
        objects[index++] = model;
        size++;
    }

    public void set(int index, T model) {
        if (index <= size) {
            objects[index] = model;
        }
    }

    public boolean remove(int index) {
        if (index <= size) {
            System.arraycopy(objects, index + 1, objects, index, size - 1);
            return true;
        } else {
            return false;
        }
    }

    public Object get(int index) {
        if (index <= size) {
            return objects[index];
        } else {
            return new ArrayIndexOutOfBoundsException();
        }
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

    private void enlargement() {
        Object[] objectsTemp = new Object[objects.length * 2];
        System.arraycopy(objects, 0, objectsTemp, 0, size);
        objects = objectsTemp;
    }
}

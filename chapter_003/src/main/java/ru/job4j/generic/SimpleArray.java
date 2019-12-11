package ru.job4j.generic;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] objects;
    private int index = 0;
    private int size = 0;
    private int modCount = 0;

    public SimpleArray(int volume) {
        this.objects = new Object[volume];
    }

    public void add(T model) {
        enlargement();
        objects[index++] = model;
        size++;
        modCount++;
    }

    public void set(int index, T model) {
        if (index <= size) {
            objects[index] = model;
            modCount++;
        }
    }

    public boolean remove(int index) {
        if (index <= size) {
            System.arraycopy(objects, index + 1, objects, index, size - 1);
            modCount++;
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
        int savedModCount = modCount;
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
                if (savedModCount != modCount) {
                    new ConcurrentModificationException();
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
        if (size == objects.length) {
            Object[] objectsTemp = new Object[objects.length * 2];
            System.arraycopy(objects, 0, objectsTemp, 0, size);
            objects = objectsTemp;
        }
    }

    public int getSize() {
        return size;
    }
}

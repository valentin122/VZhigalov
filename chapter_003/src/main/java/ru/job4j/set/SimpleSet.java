package ru.job4j.set;

import ru.job4j.generic.SimpleArray;

import java.util.Iterator;

public class SimpleSet<T> implements Iterable {
    private SimpleArray<T> simpleArray;
    private int size;

    public SimpleSet(int size) {
        this.size = size;
        simpleArray = new SimpleArray<>(this.size);
    }

    public boolean add(T model) {
        Iterator<T> it = simpleArray.iterator();
        boolean result = true;
        while (it.hasNext()) {
            T itModel = it.next();
            if (itModel.equals(model)) {
                result = false;
                break;
            }
        }
        if (result) {
            simpleArray.add(model);
        }
        return result;
    }

    @Override
    public Iterator iterator() {
        return simpleArray.iterator();
    }
}

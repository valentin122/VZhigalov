package ru.job4j.list;

public class SimpleQueue<T> {

    private SimpleStack<T> simpleStackLifo = new SimpleStack<>();
    private SimpleStack<T> simpleStackFifo = new SimpleStack<>();

    public T poll() {
        while (simpleStackLifo.getSize() != 0) {
            simpleStackFifo.push(simpleStackLifo.poll());
        }
        return simpleStackFifo.poll();
    }

    public void push(T value) {
        simpleStackLifo.push(value);
    }
}

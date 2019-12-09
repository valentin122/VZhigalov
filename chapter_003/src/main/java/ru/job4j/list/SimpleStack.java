package ru.job4j.list;

public class SimpleStack<T> {
    private SimpleLinkedList<T> simpleLinkedList = new SimpleLinkedList();

    public T poll() {
        T result = simpleLinkedList.delete();
        return result;
    }

    public void push(T value)  {
        simpleLinkedList.add(value);
    }
}

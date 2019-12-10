package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleLinkedList<E> implements Iterable<E> {

    private int size;
    private Node<E> first;
    private int modCount = 0;

    public void add(E data) {
        Node<E> newLink = new Node<>(data);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
        modCount++;
    }

    public E delete() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        E data = this.first.data;
        first = first.next;
        size--;
        modCount++;
        return data;
    }

    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public Iterator<E> iterator() {
        int savedModCount = modCount;
        return new Iterator<E>() {
            private int indexIterator = 0;

            @Override
            public boolean hasNext() {
                return indexIterator < size;
            }

            @Override
            public E next() {
                if (savedModCount != modCount) {
                    new ConcurrentModificationException();
                }
                E result = first.data;
                indexIterator++;
                first = first.next;
                return result;
            }
        };
    }

    boolean hasCycle(Node first) {
        Node slow = first;
        Node fast = first;

        if (first == null) {
            return false;
        }

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * Класс предназначен для хранения данных.
     */
    private static class Node<E> {

        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }
}


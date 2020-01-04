package ru.job4j.tree;

import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree {
    private int modCount = 0;
    private int size = 0;

    private Node<E> root;

    public Tree(E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(Comparable parent, Comparable child) {
        boolean rsl = false;
        Optional<Node<E>> parentTemp = findBy(parent);
        Optional<Node<E>> childTemp = findBy(parent);
        if (parentTemp.isPresent()) {
            if (childTemp.isPresent()) {
                parentTemp.get().add(new Node<>(child));
                modCount++;
                size++;
                rsl = true;
            }
        }
        return rsl;
    }

    @Override
    public Optional<Node<E>> findBy(Comparable value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue((E) value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    public int getSize() {
        return size;
    }

    public boolean isBinary() {
        boolean result = true;
        Iterator<Node> it = iterator();
        while (it.hasNext()) {
            if (it.next().leaves().size() > 2) {
                result = false;
                break;
            }
        }
        return result;
    }

    @Override
    public Iterator iterator() {
        int iteratorModCount = modCount;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(root);

        return new Iterator() {

            @Override
            public boolean hasNext() {
                return queue.size() > 0;
            }

            @Override
            public Node<E> next() {
                if (queue.size() == 0) {
                    new NoSuchElementException();
                }
                if (iteratorModCount != modCount) {
                    new ConcurrentModificationException();
                }
                Node<E> result = queue.poll();
                for (Node<E> node : result.leaves()) {
                    queue.add(node);
                }
                return result;
            }
        };
    }
}

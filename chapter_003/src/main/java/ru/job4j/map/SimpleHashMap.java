package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class SimpleHashMap<K, V> implements Iterable<V> {
    private Entry<K, V>[] map;
    private int modCount = 0;
    private int size = 8;
    private int count = 0;

    public SimpleHashMap() {
        map = new Entry[size];
    }

    public SimpleHashMap(int initialSize) {
        this.size = initialSize;
        map = new Entry[initialSize];
    }

    public boolean insert(K key, V value) {
        int bucket = getIndexBucket(key);
        if (map[bucket] == null) {
            resize();
            map[bucket] = new Entry<>(key, value);
            count++;
            modCount++;
            return true;
        } else {
            return false;
        }
    }

    public int getSize() {
        return count;
    }

    public V get(K key) {
        return map[getIndexBucket(key)].value;
    }

    public boolean delete(K key) {
        int hashTarget = hash(key);
        int innerHash = hash(map[getIndexBucket(key)].key);
        if (hashTarget == innerHash) {
            map[getIndexBucket(key)] = null;
            modCount++;
            count--;
            return true;
        } else {
            return false;
        }
    }

    private int getIndexBucket(K key) {
        if (hash(key) == 0) {
            return 0;
        }
        int index = (hash(key) % size);
        return index;
    }

    private int hash(K key) {
        if (key == null) {
            return 0;
        } else {
            int h = key.hashCode();
            return (h) ^ (h >>> 16);
        }
    }

    private void resize() {
        if (count == map.length) {
            Entry<K, V>[] mapTemp = new Entry[(map.length * 2)];
            System.arraycopy(map, 0, mapTemp, 0, size);
        }
    }

    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {
            int index = 0;
            int modified = modCount;

            @Override
            public boolean hasNext() {
                boolean result = false;
                for (int i = index; i < size; i++) {
                    if (map[i].key != null) {
                        result = true;
                    }
                }
                return result;
            }

            @Override
            public V next() {
                V result = null;
                if (modCount != modified) {
                    new ConcurrentModificationException();
                }
                for (int i = index; i < size; i++) {
                    if (map[i].key != null) {
                        result = map[index].value;
                        break;
                    }
                }
                return result;
            }
        };
    }

    class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
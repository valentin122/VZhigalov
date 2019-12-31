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
        } else if (key.equals(map[bucket].key)) {
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
        boolean result = false;
        int hashTarget = hash(key);
        int innerHash = hash(map[getIndexBucket(key)].key);
        if (hashTarget == innerHash) {
            if (map[getIndexBucket(key)].key.equals(key)) {
                map[getIndexBucket(key)] = null;
                modCount++;
                count--;
                result = true;
            }
        }
        return result;
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
            size = map.length * 2;
            Entry<K, V>[] mapTemp = new Entry[size];
            for (Entry<K, V> entry : map) {
                mapTemp[getIndexBucket(entry.key)] = entry;
            }
        }
    }

    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {
            int index = 0;
            int modified = modCount;
            int indexNext = 0;

            @Override
            public boolean hasNext() {
                boolean result = false;
                for (int i = index; i < size; i++) {
                    if (map[i].key != null) {
                        indexNext = i;
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
                if (indexNext != 0) {
                    result = map[indexNext].value;
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
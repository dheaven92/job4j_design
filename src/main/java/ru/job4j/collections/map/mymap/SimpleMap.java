package ru.job4j.collections.map.mymap;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;
    private int capacity = 8;
    private int count = 0;
    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        int index = hash(key);
        if (table[index] != null) {
            return false;
        }
        if (count >= capacity * LOAD_FACTOR) {
            grow();
        }
        table[index] = new MapEntry<>(key, value);
        count++;
        modCount++;
        return true;
    }

    @Override
    public V get(K key) {
        int index = hash(key);
        if (table[index] == null) {
            return null;
        }
        return table[index].value;
    }

    @Override
    public boolean remove(K key) {
        int index = hash(key);
        if (table[index] == null) {
            return false;
        }
        table[index] = null;
        count--;
        modCount++;
        return true;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<>() {
            private int index = 0;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (count == 0) {
                    return false;
                }
                while (index < capacity && table[index] == null) {
                    index++;
                }
                return index < capacity && table[index] != null;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[index++].key;
            }
        };
    }

    private int hash(K key) {
        return key == null ? 0 : key.hashCode() % capacity;
    }

    private void grow() {
        capacity *= 2;
        MapEntry<K, V>[] extendedTable = new MapEntry[capacity];
        count = 0;
        for (MapEntry<K, V> entry : table) {
            if (entry != null) {
                int index = hash(entry.key);
                extendedTable[index] = entry;
                count++;
            }
        }
        table = extendedTable;
    }

    private static class MapEntry<K, V> {
        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}

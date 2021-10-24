package ru.job4j.gc.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {

    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, V value) {
        V currentValue = get(key);
        if (currentValue == null) {
            cache.put(key, new SoftReference<>(value));
        }
    }

    public V get(K key) {
        return cache.containsKey(key) ? cache.get(key).get() : null;
    }

    protected abstract V load(K key);
}

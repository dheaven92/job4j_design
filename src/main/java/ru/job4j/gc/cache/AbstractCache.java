package ru.job4j.gc.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {

    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, V value) {
        cache.put(key, new SoftReference<>(value));
    }

    public V get(K key) {
        V currentValue = cache.get(key) != null ? cache.get(key).get() : null;
        if (currentValue == null) {
            currentValue = load(key);
            cache.put(key, new SoftReference<>(currentValue));
        }
        return currentValue;
    }

    protected abstract V load(K key);
}

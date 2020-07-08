package com.Akif;

/**
 * KWHashMap interface from the book
 * @param <K> key type in the table.
 * @param <V> value type in the table.
 */
public interface KWHashMap<K,V> {
    V get(Object key);
    boolean isEmpty();
    V put(K key, V value);
    V remove(Object key);
    int size();
}

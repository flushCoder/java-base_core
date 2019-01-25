package com.cx.collections.hashmap;

/**
 * @author:wuming
 */
public class Entry<K, V> {
    public K k;
    public V v;
    public int hash;
    public Entry<K,V> next;

    public Entry(K k, V v, int hash, Entry<K, V> next) {
        this.k = k;
        this.v = v;
        this.hash = hash;
        this.next = next;
    }
}

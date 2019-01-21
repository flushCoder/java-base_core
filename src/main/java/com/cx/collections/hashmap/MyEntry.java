package com.cx.collections.hashmap;

/**
 * @author:wuming
 */
public class MyEntry<K, V> {
    K k;
    V v;
    MyEntry<K, V> next;

    public MyEntry(K k, V v, MyEntry<K, V> next) {
        this.k = k;
        this.v = v;
        this.next = next;
    }
}

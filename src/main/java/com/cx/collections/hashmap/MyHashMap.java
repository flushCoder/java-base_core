package com.cx.collections.hashmap;


public class MyHashMap<K, V> {


    public static final Integer CAPACITY = 8;
    public MyEntry[] table = new MyEntry[CAPACITY];
    public int size;
    public int threshold = 8;

    public V put(K k, V v){
        Integer hash = k.hashCode();
        Integer index = hash % 8;
        for(MyEntry<K, V> entry = table[index]; entry != null; entry = entry.next){
            if(entry.k.equals(k)){
                V oldValue = entry.v;
                entry.v = v;
                return oldValue;
            }
        }

        if(size >= threshold){
            threshold = 16;
            Integer newLength = CAPACITY << 1;
            MyEntry<K, V>[] oldTable = table;
            table = new MyEntry[newLength];
            for(MyEntry<K, V> entry : oldTable){
                while(entry != null){
                    MyEntry<K, V> next = entry.next;
                    Integer i = entry.k.hashCode() % 16;
                    entry.next = table[i];
                    table[i] = entry;
                    entry = next;
                }
            }

            index = hash % 16;
        }

        MyEntry myEntry = new MyEntry<>(k, v, table[index]);
        table[index] = myEntry;
        size ++;
        return null;
    }

    public V get(K k){
        Integer hash = k.hashCode();
        Integer index = hash % 8;
        for(MyEntry<K, V> entry = table[index]; entry != null; entry = entry.next){
            if(entry.k.equals(k)){
                V value = entry.v;
                return value;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        MyHashMap<String, String> myHashMap = new MyHashMap<>();
        myHashMap.put("1", "1");
        myHashMap.put("17", "17");
        myHashMap.put("2", "2");
        myHashMap.put("3", "3");
        myHashMap.put("4", "4");
        myHashMap.put("5", "5");
        myHashMap.put("6", "6");
        myHashMap.put("7", "7");
        myHashMap.put("8", "8");
        myHashMap.put("9", "9");
        myHashMap.put("10", "10");


        String s = myHashMap.get("17");
        System.out.println(s);
    }
}

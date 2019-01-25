package com.cx.collections.hashmap;

/**
 * @author:wuming
 */
public class HashMap<K, V> {

    public final int CAPACITY = 4;
    public Entry[] table;
    public int size;

    public HashMap() {
        this.table = new Entry[CAPACITY];
    }

    public V put(K key, V value){
        int hashCode = key.hashCode();
        int index = hashCode & (CAPACITY - 1);
        for(Entry<K, V> entry=table[index]; entry != null; entry=entry.next){
            if(entry.k.equals(key)){
                V oldValue = entry.v;
                entry.v = value;
                return oldValue;
            }
        }

        table[index] = new Entry(key, value, hashCode, table[index]);

        int newSize = ++size;
        if(newSize > (int)(table.length * 0.75)){
            resize();
        }

        return null;
    }

    public void resize(){
        Entry[] newTable = new Entry[table.length * 2];
        for(Entry<K, V> entry: table){
            if(entry != null){
                int index = entry.hash & (CAPACITY - 1);
                //1.8 扩容原理
                if((table.length & entry.hash) == table.length){
                    newTable[index+table.length] = table[index];
                }else{
                    newTable[index] = table[index];
                }
            }
        }
    }

    public V get(K key){
        int hashCode = key.hashCode();
        int index = hashCode & (CAPACITY - 1);
        for(Entry<K, V> entry=table[index]; entry != null; entry=entry.next){
            if(entry.k.equals(key)){
                V value = entry.v;
                return value;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("1", "1");
        hashMap.put("5", "5");
        hashMap.put("2", "2");
        hashMap.put("3", "3");
        hashMap.put("4", "4");

        System.out.println(hashMap.get("1"));
        System.out.println(hashMap.get("2"));
        System.out.println(hashMap.get("3"));
        System.out.println(hashMap.get("4"));
        System.out.println(hashMap.get("5"));

        int hashCode = "5".hashCode();
        int index = hashCode & 3;
        System.out.println(index);

    }
}

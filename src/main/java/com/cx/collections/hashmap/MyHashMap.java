package com.cx.collections.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class MyHashMap {

    public void test(){

        Map<String, String> map = new HashMap<String, String>();
        HashMap hashMap = new HashMap(map);
        hashMap.put("", "");
        hashMap.get("");
        System.out.println(1 << 4);
    }

    public static void main(String[] args) {
        final HashMap<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    map.put(UUID.randomUUID().toString(), "");
                }
            }).start();
        }
    }
}

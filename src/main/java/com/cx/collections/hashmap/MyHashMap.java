package com.cx.collections.hashmap;

import java.util.HashMap;
import java.util.Map;


public class MyHashMap {

    public void test(){

        Map<String, String> map = new HashMap<String, String>();
        HashMap hashMap = new HashMap(map);
        hashMap.put("", "");
        hashMap.get("");
        System.out.println(1 << 4);
    }

    public static void main(String[] args) {
        System.out.println(1 << 4);
    }
}

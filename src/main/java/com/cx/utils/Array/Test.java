package com.cx.utils.Array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

public class Test {

    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        list.add("1");
        System.out.println(22>>1);
        Set<String> set = new HashSet<>();

        ConcurrentHashMap ch = new ConcurrentHashMap();

        Thread thread = new Thread();

        String initialReference = "initialReference";
        AtomicReference<String> atomicReference = new AtomicReference<>(initialReference);
        String newReference = "newReference";
        boolean b = atomicReference.compareAndSet(initialReference, newReference);
        System.out.println(b);
        System.out.println(atomicReference.compareAndSet(initialReference, newReference));

        List<String> ll = Lists.list();

        Lists.list();

    }
}

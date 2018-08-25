package com.cx.utils.lambda;

import com.alibaba.fastjson.JSON;

import java.util.*;

public class Demo01 {

    public static void main(String[] args){
        List<People> list = new ArrayList<>();
        list.add(new People("a", 13));
        list.add(new People("b", 16));
        list.add(new People("c", 15));

       /* Collections.sort(list, new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                return o1.getAge()-o2.getAge();
            }
        });

        System.out.println(JSON.toJSON(list));*/


        System.out.println("前========="+JSON.toJSON(list));
        Collections.sort(list, (People p1, People p2) -> p1.getAge()-p2.getAge());
        System.out.println("后========="+JSON.toJSON(list));
    }
}

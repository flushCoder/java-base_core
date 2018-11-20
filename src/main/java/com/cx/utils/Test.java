package com.cx.utils;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        for (String temp : list) {
            if("1".equals(temp)){
                list.remove(temp);
            }
        }
        System.out.println(JSON.toJSONString(list));
        System.out.println(EnumTest.getNameBySceneId(EnumTest.HUANBEI.getSceneId()));
    }
}

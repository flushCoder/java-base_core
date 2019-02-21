package com.cx.designpatterns.singleton.hungry;

/**
 * 饿汉式
 * @author:wuming
 */
public class HungrySingleton {

    private HungrySingleton(){};

    private static final HungrySingleton singleton = new HungrySingleton();

    public static HungrySingleton getSingleton(){
        System.out.println(System.currentTimeMillis() + ":" + singleton);
        return singleton;
    }
}
